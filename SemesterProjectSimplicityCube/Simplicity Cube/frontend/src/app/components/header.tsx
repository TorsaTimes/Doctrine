import React from 'react';
import { Link } from 'react-router-dom';
import { css, cx } from '@emotion/css';

import { Icon } from './Icon/icon';
import { IRoutes } from '../routes';
import { IRoute } from '../models/route';
import { RoutingContext, IRoutingContext } from '../provider/routing.provider';
import { GattServerContext, IGattServerContext } from '../provider/bluetooth/gatt-server.provider';
import { AppContext, IAppContext } from '../provider/app-context.provider';

interface Properties {
  routes: IRoutes;
}

export const Header = (props: Properties) => {
  const { routes } = props;

  const routing = React.useContext<IRoutingContext>(RoutingContext);
  const server = React.useContext<IGattServerContext>(GattServerContext);
  const app = React.useContext<IAppContext>(AppContext);

  const styles = getStyles();

  const createNavItem = (route: IRoute): JSX.Element => {
    return (
      <Link to={route.path} className={styles.navItem}>
        <nav
          className={cx(
            styles.navItemContent,
            routing.value.path === route.path ? styles.navItemActive : styles.navItemInActive,
            styles.hideForMobile
          )}
        >
          <Icon iconName={route.icon}></Icon>
          <span className={styles.navItemText}>{route.displayName}</span>
        </nav>
      </Link>
    );
  };

  const isConnected = server.value?.connected === true;

  return (
    <header className={styles.header}>
      <span>
        <div className={styles.headerIcon}>
          <Icon iconName='bluetooth' size={36} />
          <span className={styles.headerTitle}>
            <span>Web-BT</span>
          </span>
        </div>
      </span>
      <div className={styles.headerNavbar}>
        <span className={styles.navHeaderRegion}>
          {createNavItem(routes.Home)}
          {createNavItem(routes.Projects)}
          {createNavItem(routes.Alarms)}
          {createNavItem(routes.ProjectTimeManagement)}
        </span>

        <span className={styles.btHeaderRegion}>
          <nav className={styles.navItem} title='Reload user data' onClick={(_) => app.refreshAll()}>
            <div className={cx(styles.navItemContent)}>
              <Icon iconName='refresh' size={24} />
            </div>
          </nav>

          <nav
            className={styles.navItem}
            title={isConnected ? 'Disconnect Bluetooth device' : 'Connect Bluetooth device'}
          >
            {!isConnected && (
              <div className={cx(styles.navItemContent, styles.btOffline)} onClick={(_) => server.connectDevice()}>
                <Icon iconName='bluetooth_disabled' size={36} />
              </div>
            )}
            {isConnected && (
              <div className={cx(styles.navItemContent, styles.btOnline)} onClick={(_) => server.disconnectDevice()}>
                <Icon iconName='bluetooth_connected' size={36} />
              </div>
            )}
          </nav>
        </span>
      </div>
    </header>
  );
};

const getStyles = () => {
  return {
    header: css`
      display: flex;
      flex-direction: row;
      align-items: center;

      width: 100%;
      height: 0.6rem;
      background: #141619;

      color: white;

      white-space: nowrap;
      border-bottom: 0.01rem solid #444;
    `,

    hideForMobile: css`
      @media (max-width: 900px) {
        div,
        span {
          display: none;
        }
      }
    `,

    headerIcon: css`
      display: flex;
      flex-direction: row;
      align-items: center;
      padding-left: 0.12rem;
      height: 100%;
    `,
    headerTitle: css`
      font-size: 0.24rem;
      padding-right: 0.12rem;
      margin-right: 0.12rem;
      border-right: 0.01rem solid white;
    `,

    headerNavbar: css`
      display: flex;
      flex-direction: row;
      align-items: center;
      justify-content: space-between;
      flex: 1;
      height: 100%;
    `,

    navItem: css`
      height: 100%;
      color: white;

      cursor: pointer;
      transition: 0.5s all;
      &:hover {
        background: #2875f0;
      }
    `,
    navItemText: css`
      margin-left: 0.03rem;
    `,
    navItemInActive: css`
      border: 0.01rem solid transparent;
    `,
    navItemActive: css`
      background: #202226;

      border-left: 0.01rem solid #444;
      border-top: 0.01rem solid #444;
      border-right: 0.01rem solid #444;

      color: #28aaf0;
    `,

    navItemContent: css`
      height: 100%;
      width: 100%;
      padding: 0 0.12rem;

      display: flex;
      flex-direction: row;
      align-items: center;
      justify-content: center;
    `,
    navHeaderRegion: css`
      display: flex;
      flex-direction: row;
      align-items: center;
      justify-content: center;
      height: 100%;
      padding-left: 0.12rem;
    `,

    btHeaderRegion: css`
      display: flex;
      flex-direction: row;
      align-items: center;
      justify-content: center;
      height: 100%;
      align-self: flex-end;
      padding-left: 0.12rem;
    `,

    btOnline: css`
      color: #00e600;
    `,
    btOffline: css`
      color: #ff0000;
    `,
  };
};
