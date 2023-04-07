import axios from 'axios';
import { Alarm } from '../../models/project/alarm';
import { AlarmRule } from '../../models/project/alarmRule';
import { CubeSide } from '../../models/project/types';
import { User } from '../../models/project/user';
import { UserProject } from '../../models/project/userProject';
import { Project } from './../../models/project/project';

export class UserService {
  static async getUser(): Promise<User> {
    return new Promise((resolve, reject) => {
      axios
        .get('/backend/api/user')
        .then((res) => {
          const data: User = res.data.result.user;
          resolve(data);
        })
        .catch((err) => {
          reject(err);
        });
    });
  }

  static async getUserProjects(user: User | null): Promise<UserProject[]> {
    return new Promise((resolve, reject) => {
      if (!user?.id) {
        reject('User is null!');
        return;
      }
      axios
        .get(`/backend/api/user/${user.id}/projects`)
        .then((res) => {
          const data: UserProject[] = res.data.result;
          resolve(data);
        })
        .catch((err) => {
          reject(err);
        });
    });
  }

  static async getAlarms(user: User | null): Promise<Alarm[]> {
    return new Promise((resolve, reject) => {
      if (!user?.id) {
        reject('User is null!');
        return;
      }

      axios
        .get(`/backend/api/user/${user.id}/alarms`)
        .then((res) => {
          const data: Alarm[] = res.data.result;
          resolve(data);
        })
        .catch((err) => {
          reject(err);
        });
    });
  }

  static async getAlarmRules(user: User | null): Promise<AlarmRule[]> {
    return new Promise((resolve, reject) => {
      if (!user?.id) {
        reject('User is null!');
        return;
      }

      axios
        .get('/backend/api/user/${user.id}/alarms/rules')
        .then((res) => {
          const data: AlarmRule[] = res.data.result;
          resolve(data);
        })
        .catch((err) => {
          reject(err);
        });
    });
  }

  static async postUserProjectSelected(user: User | null, projectId: number, selected: boolean): Promise<any> {
    return new Promise((resolve, reject) => {
      if (!user?.id) {
        reject('User is null!');
        return;
      }

      axios
        .post(`/backend/api/user/${user.id}/project/${projectId}/select`, { value: selected })
        .then((res) => {
          resolve(res);
        })
        .catch((err) => {
          reject(err);
        });
    });
  }

  static async postUserProjectColor(user: User | null, projectId: number, color: string): Promise<any> {
    return new Promise((resolve, reject) => {
      if (!user?.id) {
        reject('User is null!');
        return;
      }

      axios
        .post(`/backend/api/user/${user.id}/project/${projectId}/color`, { value: color })
        .then((res) => {
          resolve(res);
        })
        .catch((err) => {
          reject(err);
        });
    });
  }

  static async postUserProjectCubeSide(user: User | null, projectId: number, cubeSide: CubeSide): Promise<any> {
    return new Promise((resolve, reject) => {
      if (!user?.id) {
        reject('User is null!');
        return;
      }

      axios
        .post(`/backend/api/user/${user.id}/project/${projectId}/cubeside`, { value: cubeSide })
        .then((res) => {
          resolve(res);
        })
        .catch((err) => {
          reject(err);
        });
    });
  }

  static async postUserProjectActive(user: User | null, projectId: number): Promise<any> {
    return new Promise((resolve, reject) => {
      if (!user?.id) {
        reject('User is null!');
        return;
      }

      axios
        .post(`/backend/api/user/${user.id}/project/${projectId}/active`, { value: true })
        .then((res) => {
          resolve(res);
        })
        .catch((err) => {
          reject(err);
        });
    });
  }
}
