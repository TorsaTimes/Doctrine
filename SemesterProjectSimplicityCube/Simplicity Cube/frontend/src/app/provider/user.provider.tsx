import React from 'react';
import { UserService } from '../core/services/user.service';
import { User } from './../models/project/user';

interface Properties {
  children?: any;
}

export interface IUserContext {
  value: User | null;
  update: (value: User | null) => void;
}

export const UserContext = React.createContext<any>({});

export const UserProvider = (props: Properties) => {
  const [value, setValue] = React.useState<User | null>(null);

  const contextValue: IUserContext = {
    value: value,
    update: updateValue,
  };

  React.useEffect(() => {
    UserService.getUser().then((user) => {
      setValue(user);
    });
  }, []);

  return <UserContext.Provider value={contextValue}>{props.children}</UserContext.Provider>;

  function updateValue(value: User | null) {
    setValue(value);
  }
};
