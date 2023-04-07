import React from 'react';

import { BluetoothUtils } from '../../../../core/utils/bluetooth-utils';
import { BluetoothEvent } from '../../../../models/bluetooth/event/bluetoothEvent';
import { SensorReading } from '../../../../models/data';
import { IServiceContext, ServiceContext } from '../service.provider';
import { BluetoothRemoteGATTCharacteristic } from '../../../../models/bluetooth/bluetoothGATTCharacteristic';

interface Properties {
  children?: any;
}

export interface ISensors_AccelerationContext {
  value: SensorReading<number[]> | null;
}

export const Sensors_AccelerationContext = React.createContext<any>({});

export const Sensors_AccelerationProvider = (props: Properties) => {
  const [value, setValue] = React.useState<SensorReading<number[]> | null>(null);

  const services = React.useContext<IServiceContext>(ServiceContext);
  const characteristic = services?.value?.accelerationOrientation?.characteristics?.acceleration;

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
    <Sensors_AccelerationContext.Provider value={{ value: value } as ISensors_AccelerationContext}>
      {props.children}
    </Sensors_AccelerationContext.Provider>
  );

  async function attachChangeListener(charactersitic: BluetoothRemoteGATTCharacteristic) {
    try {
      await BluetoothUtils.addChangeListener(charactersitic, notifyHandler);
      log('[SUCCESS] Added change listener to acceleration characteristic!');
    } catch (error) {
      log('[ERROR] Sensors_AccelerationProvider.attachChangeListener(): ' + error);
    }
  }

  function notifyHandler(event: BluetoothEvent) {
    if (!event.currentTarget) {
      return;
    }
    const data = event.currentTarget.value.buffer;

    // The data is stored in 6 Bytes but represents 3 floats with low precision.
    // Therefore the buffer has to be split each 2 Bytes, parsed as a number and the converted to a signed number.
    // At the end a division by 100 is needed to get the 2 decimal places.
    const x = BluetoothUtils.toSigned16Bit(BluetoothUtils.parseNumber(new DataView(data.slice(0, 2)))) / 100;
    const y = BluetoothUtils.toSigned16Bit(BluetoothUtils.parseNumber(new DataView(data.slice(2, 4)))) / 100;
    const z = BluetoothUtils.toSigned16Bit(BluetoothUtils.parseNumber(new DataView(data.slice(4, 6)))) / 100;

    const now = new Date();
    setValue({
      latestValue: {
        timestamp: now,
        value: [x, y, z],
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
