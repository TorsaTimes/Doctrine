import React from 'react';

import { BluetoothUtils } from '../../../../core/utils/bluetooth-utils';
import { ThunderSense2SensorData } from '../../../../models/thunder-sense/characteristics';
import { IServiceContext, ServiceContext } from '../service.provider';
import { BluetoothRemoteGATTCharacteristic } from '../../../../models/bluetooth/bluetoothGATTCharacteristic';

interface Properties {
  children?: any;
}

export interface ISensors_DataPollingContext {
  value: ThunderSense2SensorData | null;
}

export const Sensors_DataPollingContext = React.createContext<any>({});

export const Sensors_DataPollingProvider = (props: Properties) => {
  const [value, setValue] = React.useState<ThunderSense2SensorData | null>(null);
  const [dataPollingFinished, setDataPollingFinished] = React.useState<boolean>(false);

  const services = React.useContext<IServiceContext>(ServiceContext);

  React.useEffect(() => {
    if (!services?.value) {
      setDataPollingFinished(false);
      return;
    }

    setDataPollingFinished(true);
  }, [services]);

  /**
   * Poll sensor data as soon as the last read is done.
   */
  React.useEffect(() => {
    if (!dataPollingFinished) {
      return;
    }

    async function poll() {
      setDataPollingFinished(false);
      await readCharacteristicsData();
      setDataPollingFinished(true);
    }

    poll();
  }, [dataPollingFinished]);

  return (
    <Sensors_DataPollingContext.Provider value={{ value: value } as ISensors_DataPollingContext}>
      {props.children}
    </Sensors_DataPollingContext.Provider>
  );

  async function readCharacteristicsData() {
    if (!services?.value) {
      return;
    }

    try {
      const pressure = await readNumeric(services.value.environment.characteristics.pressure, 0.1);
      const temperature = await readNumeric(services.value.environment.characteristics.temperature, 0.01);
      const humidity = await readNumeric(services.value.environment.characteristics.humidity, 0.01);
      const uvIndex = await readNumeric(services.value.environment.characteristics.uvIndex);
      const soundLevel = await readNumeric(services.value.environment.characteristics.soundLevel, 0.01);
      const ambientLight = await readNumeric(services.value.environment.characteristics.ambientLight, 0.01);

      const co2 = await readNumeric(services.value.indoorAirQuality.characteristics.co2, 1);
      const voc = await readNumeric(services.value.indoorAirQuality.characteristics.voc, 1);

      const now = new Date();
      setValue({
        ...value,
        environment: {
          pressure: { latestValue: { timestamp: now, value: pressure } },
          temperature: { latestValue: { timestamp: now, value: temperature } },
          humidity: { latestValue: { timestamp: now, value: humidity } },
          uvIndex: { latestValue: { timestamp: now, value: uvIndex } },
          soundLevel: { latestValue: { timestamp: now, value: soundLevel } },
          ambientLight: { latestValue: { timestamp: now, value: ambientLight } },
        },
        indoorAirQuality: {
          co2: { latestValue: { timestamp: now, value: co2 } },
          voc: { latestValue: { timestamp: now, value: voc } },
        },
      });
    } catch (error) {
      log('[ERROR] Sensors_DataPollingProvider.readNumericValue: ' + error);
    }
  }

  /**
   * This function will try to read a value from the characteristic, parse it as a number and apply the correct factor to it.
   * @param characteristic The characteristic from which to read a value.
   * @param factor The factor that the number is stored in.
   * Some values e.g. temperature will be floats where the last two digits represent the digits after the decimal point (factor: 0.01).
   */
  async function readNumeric(characteristic: BluetoothRemoteGATTCharacteristic, factor: number = 1): Promise<number> {
    const rawValue = await characteristic.readValue();
    return BluetoothUtils.parseNumber(rawValue, factor);
  }

  /**
   * Logging for debbuging purposes.
   */
  function log(msg: string) {
    const formattedMessage = `[${new Date().toLocaleTimeString()}]: ${msg}`;
    console.log(formattedMessage);
  }
};
