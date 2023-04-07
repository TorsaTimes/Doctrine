import React from 'react';
import { css, cx } from '@emotion/css';

import { AppContext, IAppContext } from '../../provider/app-context.provider';

interface Props {}

export const Alarms = (props: Props) => {
  const styles = getStyles();

  const app = React.useContext<IAppContext>(AppContext);
  const sensorList = app?.value?.sensors ?? [];

  return (
    <div className={styles.container}>
      <div className={styles.content}>
        <h2>Alarming</h2>
        <div >
          <select className={styles.customSelect}>
            {sensorList.map((_) => (
              <option key={'sensor_' + _.id}>{_.name}</option>
            ))}
          </select>
        </div>
      </div>
    </div>
  );
};

const getStyles = () => {
  return {
    container: css`
      width: 100%;
      flex: 1;
      padding-bottom: 0.6rem;
      background: #202226;
      color: white;
    `,
    content: css`
      display: flex;
      flex-direction: column;
      padding: 0.12rem;

      h2 {
        margin-bottom: 0.12rem;
      }
    `,

    customSelect: css`
      width: 150px;
      padding: 5px 35px 5px 5px;
      font-size: 16px;
      border: 1px solid #ccc;
      height: 34px;
      appearance: none;
      color: white;
      background: #444;

      option {
        color: white;
        background: #444;
      }
    `,
  };
};
