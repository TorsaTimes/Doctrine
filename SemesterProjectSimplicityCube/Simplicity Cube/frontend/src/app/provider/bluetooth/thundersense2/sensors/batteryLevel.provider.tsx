import React from 'react';

import { BluetoothUtils } from '../../../../core/utils/bluetooth-utils';
import { BluetoothEvent } from '../../../../models/bluetooth/event/bluetoothEvent';
import { SensorReading } from '../../../../models/data';
import { IServiceContext, ServiceContext } from '../service.provider';
import { BluetoothRemoteGATTCharacteristic } from '../../../../models/bluetooth/bluetoothGATTCharacteristic';

interface Properties {
  children?: any;
}

export interface ISensors_BatteryLevelContext {
  value: SensorReading<number> | null;
}

export const Sensors_BatteryLevelContext = React.createContext<any>({});

export const Sensors_BatteryLevelProvider = (props: Properties) => {
  const [value, setValue] = React.useState<SensorReading<number> | null>(null);

  const services = React.useContext<IServiceContext>(ServiceContext);
  const characteristic = services?.value?.battery?.characteristics?.batteryLevel;

  React.useEffect(() => {
    if (!services?.value) {
      return;
    }
    if (!characteristic) {
      return;
    }

    attachChangeListener(characteristic);
  }, [services]);

  return (
    <Sensors_BatteryLevelContext.Provider value={{ value: value } as ISensors_BatteryLevelContext}>
      {props.children}
    </Sensors_BatteryLevelContext.Provider>
  );

  async function attachChangeListener(charactersitic: BluetoothRemoteGATTCharacteristic) {
    try {
      await BluetoothUtils.addChangeListener(charactersitic, notifyHandler);
      log('[SUCCESS] Added change listener to batteryLevel characteristic!');
    } catch (error) {
      log('[ERROR] Sensors_BatteryLevelProvider.attachChangeListener(): ' + error);
    }
  }

  function notifyHandler(event: BluetoothEvent) {
    if (!event.currentTarget) {
      return;
    }
    const batteryLevel = BluetoothUtils.parseNumber(event.currentTarget.value);
    const now = new Date();

    setValue({
      latestValue: {
        timestamp: now,
        value: batteryLevel,
      },
    });
  }

  /**
   * Logging for debbuging purposes.
   */
  function log(msg: string) {
    const formattedMessage = `[${new Date().toLocaleTimeString()}]: ${msg}`;
    console.log(formattedMessage);
  }
};
