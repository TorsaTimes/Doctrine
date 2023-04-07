import { IconName } from './components/Icon/types';
import { IRoute } from './models/route';

export interface IRoutes {
  Home: IRoute;
  Projects: IRoute;
  Alarms: IRoute;
  ProjectTimeManagement: IRoute;
}

enum Paths {
  Home = '/',
  Projects = '/projects',
  Alarms = '/alarms',
  ProjectTimeManagement = '/project-management'
}

export const Routes: IRoutes = {
  Home: {
    path: Paths.Home,
    displayName: 'Home',
    icon: 'home' as IconName,
  },
  Projects: {
    path: Paths.Projects,
    displayName: 'Projects',
    icon: 'fact_check' as IconName,
  },
  Alarms: {
    path: Paths.Alarms,
    displayName: 'Alarms',
    icon: 'notifications_active' as IconName,
  },
  ProjectTimeManagement: {
    path: Paths.ProjectTimeManagement,
    displayName: 'Project Time Management',
    icon: 'timer' as IconName,
  },
};
