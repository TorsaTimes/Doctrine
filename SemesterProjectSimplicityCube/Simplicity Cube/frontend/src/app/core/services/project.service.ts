import axios from 'axios';
import { Project } from '../../models/project/project';

export class ProjectService {
  static async getProjects(): Promise<Project[]> {
    return new Promise((resolve, reject) => {
      axios
        .get('/backend/api/projects')
        .then((res) => {
          const data: Project[] = res.data.result;
          resolve(data);
        })
        .catch((err) => {
          reject(err);
        });
    });
  }

  static async getProject(projectId: string): Promise<Project> {
    return new Promise((resolve, reject) => {
      axios
        .get(`/backend/api/project/${projectId}`)
        .then((res) => {
          const data: Project = res.data.result;
          resolve(data);
        })
        .catch((err) => {
          reject(err);
        });
    });
  }
}
