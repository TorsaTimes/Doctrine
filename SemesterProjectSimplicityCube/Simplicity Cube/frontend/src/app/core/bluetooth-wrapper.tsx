import React from 'react';
import { css, cx } from '@emotion/css';

import { GattServerProvider } from '../provider/bluetooth/gatt-server.provider';
import { ServiceProvider } from '../provider/bluetooth/thundersense2/service.provider';

interface Properties {
  children: any;
}
export const BluetoothWrapper = (props: Properties): JSX.Element => {
  const styles = getStyles();

  return (
    <div className={styles.content}>
      <GattServerProvider>
        <ServiceProvider>{props.children}</ServiceProvider>
      </GattServerProvider>
    </div>
  );
};

const getStyles = () => {
  return {
    content: css`
      display: flex;
      flex-direction: column;
      height: 100%;
      width: 100%;
    `,
  };
};
