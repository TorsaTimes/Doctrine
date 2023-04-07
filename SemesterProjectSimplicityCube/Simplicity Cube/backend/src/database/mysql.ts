import mysql, { queryCallback } from 'mysql';
export type DbCallback = queryCallback;

export class DataBasePool {
  pool?: mysql.Pool;

  set(host: string, port: number) {
    this.pool = mysql.createPool({
      connectionLimit: 10,
      acquireTimeout: 10000,
      waitForConnections: true,
      multipleStatements: false,
      host: host,
      user: 'admin',
      password: '7512c96c2a78159a6e1c8ab1e869f729f6ace2d3042b16bada09679455014bc0',
      port: port,
      database: 'project_db',
      debug: false,
    });
  }

  get() {
    return this.pool;
  }
}

export const dbPool = new DataBasePool();

const maxRetries = 5;
export function attemptQuery(options: string | mysql.QueryOptions, values: any[], callback: DbCallback) {
  function tryQueryConnection(i: number) {
    dbPool.get()!.getConnection((err, connection) => {
      if (err) {
        if (i >= maxRetries) {
          console.log(`Database connection timed out after ${i} tries.`);
          callback(err, undefined, undefined);
          return;
        }
        console.log(`Database connection error. Retry ${i}/${maxRetries}.`);
        setTimeout(function () {
          tryQueryConnection(i + 1);
        }, 1000);
        return;
      } else {
        console.log(`Database connection success. Try ${i}/${maxRetries}.`);
        connection.query(options, values, (err: any, res: any, fields: any) => {
          connection.release();
          callback(err, res, fields);
        });
      }
    });
  }

  if (dbPool.get() === undefined) {
    console.error('Database not initialized!');
    throw 'Database not initialized!';
  }

  tryQueryConnection(0);
}

export async function getDatabaseConnection(): Promise<mysql.PoolConnection> {
  return new Promise<mysql.PoolConnection>((resolve, reject) => {
    function tryQueryConnection(i: number) {
      dbPool.get()!.getConnection((err, connection) => {
        if (err) {
          if (i >= maxRetries) {
            console.log(`Database connection timed out after ${i} tries.`);
            reject();
            return;
          }
          console.log(`Database connection error. Retry ${i}/${maxRetries}.`);
          setTimeout(function () {
            tryQueryConnection(i + 1);
          }, 1000);
          return;
        } else {
          console.log(`Database connection success. Try ${i}/${maxRetries}.`);
          resolve(connection);
          return;
        }
      });
    }

    if (dbPool.get() === undefined) {
      console.error('Database not initialized!');
      throw 'Database not initialized!';
    }

    tryQueryConnection(0);
  });
}
