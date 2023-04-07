import { BluetoothDevice } from './bluetoothDevice';
import { BluetoothRemoteGATTService } from './bluetoothRemoteGATTService';
import { BluetoothServiceUUID } from './bluetoothUUID';

export interface BluetoothRemoteGATTServer {
  readonly device: BluetoothDevice;
  readonly connected: boolean;

  connect(): Promise<BluetoothRemoteGATTServer>;
  disconnect(): void;
  getPrimaryService(service: BluetoothServiceUUID): Promise<BluetoothRemoteGATTService>;
  getPrimaryServices(service?: BluetoothServiceUUID): Promise<BluetoothRemoteGATTService[]>;
}
