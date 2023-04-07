import { BluetoothRemoteGATTServer } from './bluetoothRemoteGATTServer';

export interface BluetoothDevice {
  readonly id: string;
  readonly name?: string;
  readonly gatt?: BluetoothRemoteGATTServer;
  readonly uuids: string[];

  watchAdvertisements(): Promise<any>;
  unwatchAdvertisements(): void;
  readonly watchingAdvertisements: boolean;
}
