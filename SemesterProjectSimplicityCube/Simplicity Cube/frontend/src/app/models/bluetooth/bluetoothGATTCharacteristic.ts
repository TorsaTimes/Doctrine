import { BluetoothCharacteristicProperties } from './bluetoothCharacteristicProperties';
import { BluetoothRemoteGATTDescriptor } from './bluetoothRemoteGATTDescriptor';
import { BluetoothRemoteGATTService } from './bluetoothRemoteGATTService';
import { UUID, BluetoothDescriptorUUID } from './bluetoothUUID';
import { BluetoothEventListener } from './event/bluetoothEventListener';

export interface BluetoothRemoteGATTCharacteristic {
  readonly service: BluetoothRemoteGATTService;
  readonly uuid: UUID;
  readonly properties: BluetoothCharacteristicProperties;
  readonly value?: DataView;

  getDescriptor(descriptor: BluetoothDescriptorUUID): Promise<BluetoothRemoteGATTDescriptor>;
  getDescriptors(descriptor?: BluetoothDescriptorUUID): Promise<BluetoothRemoteGATTDescriptor[]>;
  readValue(): Promise<DataView>;
  writeValue(value: BufferSource): Promise<void>;
  startNotifications(): Promise<void>;
  stopNotifications(): Promise<void>;

  addEventListener(type: string, callback: BluetoothEventListener): void;
  removeEventListener(type: string, callback: BluetoothEventListener): void;
}
