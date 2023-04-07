import dotenv from 'dotenv';
import express from 'express';
import { exit } from 'process';
// import { performance } from 'perf_hooks';

import { attemptQuery, dbPool } from './database/mysql';
import { Project } from './model/project';
import { Sensor } from './model/sensor';
import { UserProject } from './model/userProject';
import { handleError, okResponse } from './utils/helper';

// initialize configuration
dotenv.config();

const db_host = process.env.DB_HOST;
const db_port = Number.parseInt(process.env.DB_PORT ?? '0', 10);

const port = process.env.SERVER_PORT;
const app = express();

if (!db_host || db_host.length === 0) {
  console.log('DB_HOST has to be set in environmental variables! Exiting...');
  exit(1);
}
if (db_port === 0 || Number.isNaN(db_port)) {
  console.log('DB_PORT has to be set in environmental variables! Exiting...');
  exit(1);
}

dbPool.set(db_host, db_port);

// parse application/x-www-form-urlencoded
app.use(express.urlencoded({ extended: false }));

// parse application/json
app.use(express.json());

app.get('/', (req, res) => {
  res.status(404).send();
});
app.get('/api/', (req, res) => {
  res.status(404).send();
});

app.get('/api/user', (req, res) => {
  const response = res;

  const query = 'SELECT * FROM user WHERE id = 1;';
  attemptQuery(query, [], (err: any, rows: any, fields: any) => {
    if (err) {
      response.status(500).json({ error: err });
      return;
    }
    response.status(200).json({ result: { user: rows[0] } });
  });
});

app.get('/api/project/:id', (req, res) => {
  const response = res;
  const projectId: number = Number.parseInt(req.params.id, 10);

  if (Number.isNaN(projectId)) {
    response.status(400).json({});
    return;
  }

  const query = 'SELECT * FROM project WHERE id = ?;';
  attemptQuery(query, [], (err: any, rows: any, fields: any) => {
    if (err) {
      response.status(500).json({ error: err });
      return;
    }

    if (rows.length === 0) {
      response.status(404).json({error: 'Project does not exist!'});
      return;
    }

    const data: Project = rows[0];
    response.status(200).json({ result: data });
  });
});

app.get('/api/projects', (req, res) => {
  const response = res;

  const query = 'SELECT * FROM project;';
  attemptQuery(query, [], (err: any, rows: any, fields: any) => {
    if (err) {
      response.status(500).json({ error: err });
      return;
    }
    const data: Project[] = rows;
    response.status(200).json({ result: data });
  });
});

app.get('/api/sensors', (req, res) => {
  const response = res;

  const blacklistedSensors: string[] = [
    'acceleration_x',
    'acceleration_y',
    'acceleration_z',
    'orientation_x',
    'orientation_y',
    'orientation_z',
  ];

  const query = 'SELECT * FROM sensor;';
  attemptQuery(query, [], (err: any, rows: any, fields: any) => {
    if (err) {
      response.status(500).json({ error: err });
      return;
    }
    const data: Sensor[] = rows;
    const sensors = data.filter((_) => !blacklistedSensors.includes(_.name));
    response.status(200).json({ result: sensors });
  });
});

app.get('/api/user/:id/projects', (req, res) => {
  const response = res;
  const userId: number = Number.parseInt(req.params.id, 10);

  if (userId === Number.NaN) {
    response.status(400).json({});
    return;
  }

  const query = 'SELECT * FROM user_project WHERE userId = ?;';
  attemptQuery(query, [userId], (err: any, rows: any, fields: any) => {
    if (err) {
      response.status(500).json({ error: err });
      return;
    }

    const data: UserProject[] = rows;
    response.status(200).json({ result: data });
  });
});

app.post('/api/user/:id/project/:pid/select', (req, res) => {
  const response = res;
  const userId: number = Number.parseInt(req.params.id);
  const projectId: number = Number.parseInt(req.params.pid);

  const selected: boolean = req.body.value;

  if (Number.isNaN(userId) || Number.isNaN(projectId) || selected === undefined) {
    response.status(400).json({});
    return;
  }

  const getTakenCubeFace = async (): Promise<number[]> => {
    const query = 'SELECT cubeFace FROM user_project WHERE userId = ? AND cubeFace != -1;';
    return new Promise<number[]>((resolve, reject) => {
      attemptQuery(query, [userId], (err: any, rows: any, fields: any) => {
        if (err) {
          reject({ code: 500, json: { error: err } });
          return;
        }
        resolve(rows.map((x: any) => x.cubeFace));
      });
    });
  };

  const callUpsertProcedure = async (cubeSide: number): Promise<void> => {
    enum resultCodes {
      ERROR_USER_INVALID = 1,
      ERROR_PROJECT_INVALID = 2,
      ERROR_MAX_USERPROJECTS_SELECTED = 3,
      SUCCESS_INSERTED = 4,
      SUCCESS_UPDATED = 5,
    }

    const maxSelectedProjects = 6;
    const query = 'CALL upsert_user_project_selected(?, ?, ?, ?, ?);';
    return new Promise<void>((resolve, reject) => {
      attemptQuery(
        query,
        [userId, projectId, maxSelectedProjects, selected, cubeSide],
        (err: any, rows: any, fields: any) => {
          if (err) {
            reject({ code: 500, json: { error: err } });
            return;
          }
          if (rows.length < 2 || rows[0].length === 0) {
            reject({ code: 500, json: { error: 'unknown_database_error' } });
            return;
          }

          const resultCode = rows[0][0].resultCode;
          switch (resultCode) {
            case resultCodes.ERROR_USER_INVALID:
              reject({ code: 400, json: { error: 'user_invalid' } });
              break;
            case resultCodes.ERROR_PROJECT_INVALID:
              reject({ code: 400, json: { error: 'project_invalid' } });
              break;
            case resultCodes.ERROR_MAX_USERPROJECTS_SELECTED:
              reject({ code: 400, json: { error: 'maximum_userprojects_selected' } });
              break;
            case resultCodes.SUCCESS_INSERTED:
            case resultCodes.SUCCESS_UPDATED:
              resolve();
              break;
            default:
              reject({ code: 500, json: { error: 'unknown_database_error' } });
              break;
          }
        }
      );
    });
  };

  getTakenCubeFace()
    .then((usedCubeFaces) => {
      let cubeSide = -1;
      if (usedCubeFaces.length > 0) {
        const nextFreeCubeSide = [0, 1, 2, 3, 4, 5].find((x) => !usedCubeFaces.includes(x));
        if (nextFreeCubeSide !== undefined) {
          cubeSide = nextFreeCubeSide;
        }
      }

      callUpsertProcedure(cubeSide)
        .then(() => okResponse(response))
        .catch((err) => handleError(response, err, req.path));
    })
    .catch((err) => handleError(response, err, req.path));
});

app.post('/api/user/:id/project/:pid/color', (req, res) => {
  const response = res;
  const userId: number = Number.parseInt(req.params.id);
  const projectId: number = Number.parseInt(req.params.pid);

  const color: string = req.body.value;

  if (Number.isNaN(userId) || Number.isNaN(projectId) || color === undefined) {
    response.status(400).json({});
    return;
  }

  const query = 'CALL upsert_user_project_color(?, ?, ?);';

  const callProcedure = async (): Promise<void> => {
    enum resultCodes {
      ERROR_USER_INVALID = 1,
      ERROR_PROJECT_INVALID = 2,
      SUCCESS_INSERTED = 3,
      SUCCESS_UPDATED = 4,
    }

    return new Promise<void>((resolve, reject) => {
      attemptQuery(query, [userId, projectId, color], (err: any, rows: any, fields: any) => {
        if (err) {
          reject({ code: 500, json: { error: err } });
          return;
        }
        if (rows.length < 2 || rows[0].length === 0) {
          reject({ code: 500, json: { error: 'unknown_database_error' } });
          return;
        }

        const resultCode = rows[0][0].resultCode;
        switch (resultCode) {
          case resultCodes.ERROR_USER_INVALID:
            reject({ code: 400, json: { error: 'user_invalid' } });
            break;
          case resultCodes.ERROR_PROJECT_INVALID:
            reject({ code: 400, json: { error: 'project_invalid' } });
            break;
          case resultCodes.SUCCESS_INSERTED:
          case resultCodes.SUCCESS_UPDATED:
            resolve();
            break;
          default:
            reject({ code: 500, json: { error: 'unknown_database_error' } });
            break;
        }
      });
    });
  };

  callProcedure()
    .then(() => okResponse(response))
    .catch((err) => handleError(response, err, req.path));
});

app.post('/api/user/:id/project/:pid/active', (req, res) => {
  const response = res;
  const userId: number = Number.parseInt(req.params.id);
  const projectId: number = Number.parseInt(req.params.pid);

  const active: boolean = req.body.value;

  if (Number.isNaN(userId) || Number.isNaN(projectId) || active === undefined) {
    response.status(400).json({});
    return;
  }

  const query = 'CALL upsert_user_project_active(?, ?, ?);';

  const callProcedure = async (): Promise<void> => {
    enum resultCodes {
      ERROR_USER_INVALID = 1,
      ERROR_PROJECT_INVALID = 2,
      SUCCESS_INSERTED = 3,
      SUCCESS_UPDATED = 4,
    }

    return new Promise<void>((resolve, reject) => {
      attemptQuery(query, [userId, projectId, active], (err: any, rows: any, fields: any) => {
        if (err) {
          reject({ code: 500, json: { error: err } });
          return;
        }
        if (rows.length < 2 || rows[0].length === 0) {
          reject({ code: 500, json: { error: 'unknown_database_error' } });
          return;
        }

        const resultCode = rows[0][0].resultCode;
        switch (resultCode) {
          case resultCodes.ERROR_USER_INVALID:
            reject({ code: 400, json: { error: 'user_invalid' } });
            break;
          case resultCodes.ERROR_PROJECT_INVALID:
            reject({ code: 400, json: { error: 'project_invalid' } });
            break;
          case resultCodes.SUCCESS_INSERTED:
          case resultCodes.SUCCESS_UPDATED:
            resolve();
            break;
          default:
            reject({ code: 500, json: { error: 'unknown_database_error' } });
            break;
        }
      });
    });
  };

  callProcedure()
    .then(() => okResponse(response))
    .catch((err) => handleError(response, err, req.path));
});

app.post('/api/user/:id/project/:pid/cubeside', (req, res) => {
  const response = res;
  const userId: number = Number.parseInt(req.params.id);
  const projectId: number = Number.parseInt(req.params.pid);

  const cubeFace: number = req.body.value;

  if (Number.isNaN(userId) || Number.isNaN(projectId) || cubeFace === undefined) {
    response.status(400).json({});
    return;
  }

  const query = 'CALL upsert_user_project_cubeFace(?, ?, ?);';

  const callProcedure = async (): Promise<void> => {
    enum resultCodes {
      ERROR_USER_INVALID = 1,
      ERROR_PROJECT_INVALID = 2,
      SUCCESS_INSERTED = 3,
      SUCCESS_UPDATED = 4,
    }

    return new Promise<void>((resolve, reject) => {
      attemptQuery(query, [userId, projectId, cubeFace], (err: any, rows: any, fields: any) => {
        if (err) {
          reject({ code: 500, json: { error: err } });
          return;
        }
        if (rows.length < 2 || rows[0].length === 0) {
          reject({ code: 500, json: { error: 'unknown_database_error' } });
          return;
        }

        const resultCode = rows[0][0].resultCode;
        switch (resultCode) {
          case resultCodes.ERROR_USER_INVALID:
            reject({ code: 400, json: { error: 'user_invalid' } });
            break;
          case resultCodes.ERROR_PROJECT_INVALID:
            reject({ code: 400, json: { error: 'project_invalid' } });
            break;
          case resultCodes.SUCCESS_INSERTED:
          case resultCodes.SUCCESS_UPDATED:
            resolve();
            break;
          default:
            reject({ code: 500, json: { error: 'unknown_database_error' } });
            break;
        }
      });
    });
  };

  callProcedure()
    .then(() => okResponse(response))
    .catch((err) => handleError(response, err, req.path));
});

// start the express server
app.listen(port, () => {
  console.log(`Server started at http://localhost:${port}`);
});
