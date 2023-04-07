import { BluetoothEvent } from './bluetoothEvent';

export interface BluetoothEventListener {
  (evt: BluetoothEvent): void;
}