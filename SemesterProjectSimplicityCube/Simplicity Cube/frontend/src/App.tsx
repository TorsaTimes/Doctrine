import React from 'react';

import './fonts/fonts';

import { RoutingComponent } from './app/routing';

import { BluetoothWrapper } from './app/core/bluetooth-wrapper';
import { UserProvider } from './app/provider/user.provider';
import { AppContextProvider } from './app/provider/app-context.provider';
import RoutingProvider from './app/provider/routing.provider';

export function App(): JSX.Element {
  return (
    <span style={{ height: '100%' }}>
      <UserProvider>
        <BluetoothWrapper>
          <AppContextProvider>
            <RoutingProvider>
              <RoutingComponent />
            </RoutingProvider>
          </AppContextProvider>
        </BluetoothWrapper>
      </UserProvider>
    </span>
  );
}
