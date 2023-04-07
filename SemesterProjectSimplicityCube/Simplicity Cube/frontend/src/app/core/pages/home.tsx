import React from 'react';
import { css } from '@emotion/css';

import { SensorPanel, ValueQuality } from './../content/sensor-panel';

import { AppContext, IAppContext } from '../../provider/app-context.provider';

import {
  ISensors_DataPollingContext,
  Sensors_DataPollingContext,
} from '../../provider/bluetooth/thundersense2/sensors/data-polling.provider';
import {
  ISensors_OrientationContext,
  Sensors_OrientationContext,
} from '../../provider/bluetooth/thundersense2/sensors/orientation.provider';
import {
  Sensors_BatteryLevelContext,
  ISensors_BatteryLevelContext,
} from '../../provider/bluetooth/thundersense2/sensors/batteryLevel.provider';
import {
  ISensors_AccelerationContext,
  Sensors_AccelerationContext,
} from '../../provider/bluetooth/thundersense2/sensors/acceleration.provider';

interface Props {}

export const Home = (props: Props) => {
  const sensorData = React.useContext<ISensors_DataPollingContext>(Sensors_DataPollingContext);

  const accelerationData = React.useContext<ISensors_AccelerationContext>(Sensors_AccelerationContext);
  const orientationData = React.useContext<ISensors_OrientationContext>(Sensors_OrientationContext);
  const batteryLevelData = React.useContext<ISensors_BatteryLevelContext>(Sensors_BatteryLevelContext);

  const app = React.useContext<IAppContext>(AppContext);

  const styles = getStyles();

  const acceleration = accelerationData?.value?.latestValue?.value ?? [];
  const orientation = orientationData?.value?.latestValue?.value ?? [];

  const temperature = sensorData?.value?.environment?.temperature?.latestValue.value ?? null;
  const pressure = sensorData?.value?.environment?.pressure?.latestValue?.value ?? null;
  const humidity = sensorData?.value?.environment?.humidity?.latestValue?.value ?? null;
  const uvIndex = sensorData?.value?.environment?.uvIndex?.latestValue?.value ?? null;
  const soundLevel = sensorData?.value?.environment?.soundLevel?.latestValue?.value ?? null;
  const ambientLight = sensorData?.value?.environment?.ambientLight?.latestValue?.value ?? null;

  const batteryLevel = batteryLevelData?.value?.latestValue?.value ?? null;

  const co2 = sensorData?.value?.indoorAirQuality?.co2?.latestValue?.value ?? null;
  const voc = sensorData?.value?.indoorAirQuality?.voc?.latestValue?.value ?? null;

  const currentProjectStats = (): JSX.Element => {
    const cubeSide = app.value.cubeSide;
    const selectedProjects = app.value.selectedUserProjects;
    const projects = app.value.projects;

    const currentUserProject = cubeSide >= 0 ? selectedProjects.filter((x) => x.cubeFace === cubeSide) : [];
    let projectName = '-';
    let projectDescription = '-';
    if (currentUserProject.length > 0) {
      const currentProject = projects.filter((x) => x.id === currentUserProject[0].projectId);
      if (currentProject.length > 0) {
        projectName = currentProject[0].name;
        projectDescription = currentProject[0].description;
      }
    }

    return (
      <div className={styles.content}>
        <h2>Current Project</h2>
        <div>
          <b>Cube Side:</b> {cubeSide >= 0 ? cubeSide + 1 : '-'}
        </div>
        <div>
          <b>Name:</b> {projectName}
        </div>
        <div>
          <b>Description:</b> {projectDescription}
        </div>
      </div>
    );
  };

  return (
    <div className={styles.container}>
      <div className={styles.content}>
        <h2>Environmental Sensors</h2>
        <div className={styles.items}>
          <SensorPanel
            iconName='thermostat'
            title='Temperature'
            unit='°C'
            values={[temperature]}
            decimals={2}
            valueQuality={
              temperature === null
                ? ValueQuality.Unknown
                : temperature < 30
                ? ValueQuality.Good
                : temperature < 40
                ? ValueQuality.Mediocre
                : ValueQuality.Bad
            }
          ></SensorPanel>
          <SensorPanel
            iconName='fitness_center'
            title='Pressure'
            unit='Pa'
            values={[pressure]}
            decimals={1}
            valueQuality={pressure === null ? ValueQuality.Unknown : ValueQuality.Good}
          ></SensorPanel>
          <SensorPanel
            iconName='invert_colors'
            title='Humidity'
            unit='%'
            values={[humidity]}
            decimals={2}
            valueQuality={
              humidity === null
                ? ValueQuality.Unknown
                : humidity >= 40 && humidity <= 60
                ? ValueQuality.Good
                : ValueQuality.Mediocre
            }
          ></SensorPanel>
          <SensorPanel
            iconName='flare'
            title='UV-Index'
            unit='UVI'
            values={[uvIndex]}
            decimals={0}
            valueQuality={
              uvIndex === null
                ? ValueQuality.Unknown
                : uvIndex < 3
                ? ValueQuality.Good
                : uvIndex < 6
                ? ValueQuality.Mediocre
                : ValueQuality.Bad
            }
          ></SensorPanel>
          <SensorPanel
            iconName='hearing'
            title='Sound level'
            unit='dB'
            values={[soundLevel]}
            decimals={2}
            valueQuality={
              soundLevel === null
                ? ValueQuality.Unknown
                : soundLevel < 60
                ? ValueQuality.Good
                : soundLevel < 80
                ? ValueQuality.Mediocre
                : ValueQuality.Bad
            }
          ></SensorPanel>
          <SensorPanel
            iconName='lightbulb_outline'
            title='Ambient Light'
            unit='lux'
            values={[ambientLight]}
            decimals={2}
            valueQuality={ambientLight === null ? ValueQuality.Unknown : ValueQuality.Good}
          ></SensorPanel>
          <SensorPanel
            iconName='speed'
            title='Acceleration'
            unit='m/s'
            values={acceleration}
            valuesPrefix={['X', 'Y', 'Z']}
            decimals={2}
            valueQuality={acceleration.length === 0 ? ValueQuality.Unknown : ValueQuality.Good}
          ></SensorPanel>
          <SensorPanel
            iconName='3d_rotation'
            title='Orientation'
            unit='°'
            values={orientation}
            valuesPrefix={['X', 'Y', 'Z']}
            decimals={2}
            valueQuality={orientation.length === 0 ? ValueQuality.Unknown : ValueQuality.Good}
          ></SensorPanel>
          <SensorPanel
            iconName='charging_station'
            title='Battery'
            unit='%'
            values={[batteryLevel]}
            decimals={0}
            valueQuality={
              batteryLevel === null
                ? ValueQuality.Unknown
                : batteryLevel > 50
                ? ValueQuality.Good
                : batteryLevel > 20
                ? ValueQuality.Mediocre
                : ValueQuality.Bad
            }
          ></SensorPanel>
          <SensorPanel
            iconName='co2'
            title='CO2'
            unit='ppm'
            values={[co2]}
            decimals={0}
            valueQuality={
              co2 === null
                ? ValueQuality.Unknown
                : co2 < 1000
                ? ValueQuality.Good
                : co2 < 2000
                ? ValueQuality.Mediocre
                : ValueQuality.Bad
            }
          ></SensorPanel>
          <SensorPanel
            iconName='air'
            title='VOC'
            unit='ppb'
            values={[voc]}
            decimals={0}
            valueQuality={
              voc === null
                ? ValueQuality.Unknown
                : voc < 400
                ? ValueQuality.Good
                : voc < 1300
                ? ValueQuality.Mediocre
                : ValueQuality.Bad
            }
          ></SensorPanel>
        </div>
      </div>
      {currentProjectStats()}
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

    items: css`
      display: flex;
      gap: 0.12rem;
      padding: 0.12rem;
      flex-wrap: wrap;
      justify-content: center;
    `,

    colorContent: css`
      display: flex;
      flex-direction: row;
    `,

    colorInput: css`
      width: 1rem;
      height: 0.3rem;
      border: none;
      outline: none;
    `,

    button: css`
      width: 1rem;
      height: 0.3rem;
      border: none;
      outline: none;
      background: #0a3d91;
      color: white;
      cursor: pointer;
      transition: 0.5s all;

      &:hover {
        background: #2875f0;
      }
    `,
  };
};
