import { BluetoothEventTarget } from './bluetoothEventTarget';

export interface BluetoothEvent extends Event {
  readonly currentTarget: BluetoothEventTarget | null;
}
