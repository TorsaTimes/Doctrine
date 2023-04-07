import React from 'react';
import { css, cx } from '@emotion/css';
import { GattServerContext, IGattServerContext } from '../provider/bluetooth/gatt-server.provider';

export const Footer = () => {
  const server = React.useContext<IGattServerContext>(GattServerContext);
  const isConnected = server.value?.connected === true;

  const styles = getStyles();

  return (
    <footer className={styles.footer}>
      <div className={styles.content}>
        <div>
          <div></div>
          <div>
            <span className={cx(styles.btStatus, styles.padding)}>
              <span>Device: {server.value && isConnected ? server.value.device.name : '-'}</span>
              <span>
                Status:{' '}
                <span className={isConnected ? styles.btOnline : styles.btOffline}>
                  {server.value && isConnected ? 'connected' : 'disconnected'}
                </span>
              </span>
            </span>
          </div>
        </div>
      </div>
    </footer>
  );
};

const getStyles = () => {
  return {
    footer: css`
      position: relative;
      display: flex;
      flex-direction: column;
      height: 0.36rem;
      width: 100%;
      border-top: 0.01rem solid #666;
      background: #333;
      color: white;
    `,

    content: css`
      overflow-y: auto;
      padding: 0.06rem;
      display: flex;
      flex-direction: column-reverse;
    `,

    padding: css`
      padding: 0 0.12rem;
    `,

    btStatus: css`
      display: flex;
      flex-direction: row;
      justify-content: center;
      padding-right: 0.06rem;
      gap: 0.12rem;
    `,

    btOnline: css`
      color: #00e600;
    `,
    btOffline: css`
      color: #ff0000;
    `,
  };
};
