import { BluetoothDevice } from './bluetoothDevice';
import { BluetoothRemoteGATTCharacteristic } from './bluetoothGATTCharacteristic';
import { BluetoothServiceUUID, UUID, BluetoothCharacteristicUUID } from './bluetoothUUID';

interface ServiceEventHandlers {}
export interface BluetoothRemoteGATTService extends ServiceEventHandlers {
  readonly uuid: UUID;
  readonly isPrimary: boolean;
  readonly device: BluetoothDevice;
  getCharacteristic(characteristic: BluetoothCharacteristicUUID): Promise<BluetoothRemoteGATTCharacteristic>;
  getCharacteristics(characteristic?: BluetoothCharacteristicUUID): Promise<BluetoothRemoteGATTCharacteristic[]>;
  getIncludedService(service: BluetoothServiceUUID): Promise<BluetoothRemoteGATTService>;
  getIncludedServices(service?: BluetoothServiceUUID): Promise<BluetoothRemoteGATTService[]>;
}
