import React from 'react';
import { IRoute } from '../models/route';
import { Routes } from '../routes';

export type IRoutingContext = {
  value: IRoute;
  updateRouting: (value: IRoute) => void;
};
export const RoutingContext = React.createContext<any>({});

const RoutingProvider: React.FC<React.ReactNode> = ({ children }) => {
  const [route, setRoute] = React.useState<IRoute>(Routes.Home);

  const updateRouting = (value: IRoute) => {
    setRoute(value);
  };

  return (
    <RoutingContext.Provider value={{ value: route, updateRouting: updateRouting }}>{children}</RoutingContext.Provider>
  );
};

export default RoutingProvider;
