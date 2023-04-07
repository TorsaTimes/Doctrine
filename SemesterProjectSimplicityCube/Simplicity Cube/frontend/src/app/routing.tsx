import React from 'react';
import { HashRouter, Route, Switch } from 'react-router-dom';

import { Routes } from './routes';
import { IRoute } from './models/route';
import { RoutingContext, IRoutingContext } from './provider/routing.provider';

import { Content } from './core/content';
import { Footer } from './components/footer';
import { Header } from './components/header';

import { Home } from './core/pages/home';
import { Projects } from './core/pages/projects';
import { Alarms } from './core/pages/alarms';
import { ProjectTimeManagement } from './core/pages/project-time-management';

interface Props {}

export const RoutingComponent = (props: Props) => {
  const routing = React.useContext<IRoutingContext>(RoutingContext);

  function createRoute(currentRoute: IRoute, component: JSX.Element) {
    React.useEffect(() => {
      if (routing.value.path !== currentRoute.path) {
        routing.updateRouting(currentRoute);
      }
    }, [routing.value.path]);

    if (routing.value.path === currentRoute.path) {
      return component;
    }
    return <div></div>;
  }

  function HomeRoute() {
    return createRoute(Routes.Home, <Home />);
  }

  function ProjectsRoute() {
    return createRoute(Routes.Projects, <Projects />);
  }

  function AlarmsRoute() {
    return createRoute(Routes.Alarms, <Alarms />);
  }

  function ProjectTimeManagementRoute() {
    return createRoute(Routes.ProjectTimeManagement, <ProjectTimeManagement />);
  }

  return (
    <HashRouter>
      <Header routes={Routes} />
      <Content>
        <Switch>
          <Route exact path={Routes.ProjectTimeManagement.path} component={ProjectTimeManagementRoute} />
          <Route exact path={Routes.Alarms.path} component={AlarmsRoute} />
          <Route exact path={Routes.Projects.path} component={ProjectsRoute} />
          <Route component={HomeRoute} />
        </Switch>
      </Content>
      <Footer />
    </HashRouter>
  );
};
