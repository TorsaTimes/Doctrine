import axios from 'axios';
import { Sensor } from '../../models/project/sensor';

export class SensorService {
  static async getSensors(): Promise<Sensor[]> {
    return new Promise((resolve, reject) => {
      axios
        .get('/backend/api/sensors')
        .then((res) => {
          const data: Sensor[] = res.data.result;
          resolve(data);
        })
        .catch((err) => {
          reject(err);
        });
    });
  }
}
