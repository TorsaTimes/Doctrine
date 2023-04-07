import React from 'react';
import { BluetoothDevice } from '../../models/bluetooth/bluetoothDevice';
import { BluetoothRemoteGATTServer } from '../../models/bluetooth/bluetoothRemoteGATTServer';
import { ServiceUuid } from '../../models/uuid';


// Define services to narrow down the shown devices as much as possible
const ThunderSense2_Services = [
  ServiceUuid.ACCELERATION_ORIENTATION,
  //ServiceUuid.AMBIENT_LIGHT,
  //ServiceUuid.AUTOMATION_IO,
  ServiceUuid.BATTERY,
  //ServiceUuid.CSC,
  //ServiceUuid.DEVICE_INFORMATION,
  ServiceUuid.ENVIRONMENT_SENSING,
  //ServiceUuid.GENERIC_ACCESS,
  //ServiceUuid.GENERIC_ATTRIBUTE,
  //ServiceUuid.HALL_EFFECT,
  ServiceUuid.INDOOR_AIR_QUALITY,
  //ServiceUuid.POWER_MANAGEMENT,
  ServiceUuid.USER_INTERFACE,
];

interface Properties {
  children?: any;
}

export interface IGattServerContext {
  value?: BluetoothRemoteGATTServer;
  update: (value?: BluetoothRemoteGATTServer) => void;
  connectDevice: () => void;
  disconnectDevice: () => void;
}

export const GattServerContext = React.createContext<any>({});

export const GattServerProvider = (props: Properties) => {
  const [device, setDevice] = React.useState<BluetoothDevice | undefined>(undefined);
  const [server, setServer] = React.useState<BluetoothRemoteGATTServer | undefined>(undefined);

  const contextValue: IGattServerContext = {
    value: server,
    update: updateServer,
    connectDevice: connectDevice,
    disconnectDevice: disconnect,
  };

  /**
   * On change of the bluetooth device, try to connect to its GATT-Server.
   */
  React.useEffect(() => {
    if (device) {
      connectServer();
    }
  }, [device]);

  return <GattServerContext.Provider value={contextValue}>{props.children}</GattServerContext.Provider>;

  function updateServer(server?: BluetoothRemoteGATTServer) {
    setServer(server);
  }

  /**
   * Disconnects the GATT-Server and therefore the bluetooth device.
   */
  function disconnect() {
    log('Disconnecting...');
    if (server) {
      server.disconnect();
      log(`Disconnected device '${server.device.name}'!`);
    }

    setDevice(undefined);
    updateServer(undefined);
  }

  /**
   * Opens the device selector of the browser after verifying that bluetooth is supported.
   * This can't be called automatically and has to be triggered by a user input (click on a button)
   */
  async function connectDevice() {
    try {
      log('Checking for Bluetooth compatibility...');

      if ((navigator as any).bluetooth === undefined) {
        throw 'Bluetooth is not supported by your browser!';
      }

      const isBtAvailable = await (navigator as any).bluetooth.getAvailability();
      if (!isBtAvailable) {
        throw 'Bluetooth is not available!';
      }

      log('Requesting Bluetooth Device...');
      const deviceObj = await (navigator as any).bluetooth.requestDevice({
        filters: [{ services: ThunderSense2_Services }],
      });

      log(`Connected to device '${deviceObj.name}'.`);
      setDevice(deviceObj);
    } catch (error) {
      log('[ERROR/DEVICE] ' + error);
    }
  }

  /**
   * Connects to the GATT-Server of the device.
   */
  async function connectServer() {
    try {
      log('Connecting to GATT Server...');

      if (!device || !device.gatt) {
        throw 'GATT is not available!';
      }

      const serverObj = await device.gatt.connect();
      updateServer(serverObj);

      log('Connected to GATT Server!');
    } catch (error) {
      log('[ERROR/CONNECT] ' + error);
    }
  }

  /**
   * Logging for debbuging purposes.
   */
  function log(msg: string) {
    const formattedMessage = `[${new Date().toLocaleTimeString()}]: ${msg}`;
    console.log(formattedMessage);
  }
};
