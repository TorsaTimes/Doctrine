import { BluetoothRemoteGATTCharacteristic } from './bluetoothGATTCharacteristic';
import { UUID } from './bluetoothUUID';

export interface BluetoothRemoteGATTDescriptor {
  readonly characteristic: BluetoothRemoteGATTCharacteristic;
  readonly uuid: UUID;
  readonly value?: ArrayBuffer;
  readValue(): Promise<ArrayBuffer>;
  writeValue(value: BufferSource): Promise<void>;
}
