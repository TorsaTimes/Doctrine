import React from 'react';

import { GattServerContext, IGattServerContext } from '../gatt-server.provider';

import { BluetoothRemoteGATTServer } from '../../../models/bluetooth/bluetoothRemoteGATTServer';
import { CharacteristicUuid, ServiceUuid } from '../../../models/uuid';
import { ThunderSense2Services } from '../../../models/thunder-sense/services';
import { Sensors_AccelerationProvider } from './sensors/acceleration.provider';
import { Sensors_BatteryLevelProvider } from './sensors/batteryLevel.provider';
import { Sensors_OrientationProvider } from './sensors/orientation.provider';
import { Sensors_DataPollingProvider } from './sensors/data-polling.provider';
import { UI_RgbLedProvider } from './ui/rgb-Led.provider';

export interface IServiceContext {
  value: ThunderSense2Services | null;
}

export const ServiceContext = React.createContext<any>({});

interface Properties {
  children?: any;
}

export const ServiceProvider = (props: Properties) => {
  const [services, setServices] = React.useState<ThunderSense2Services | null>(null);

  const server = React.useContext<IGattServerContext>(GattServerContext);

  /**
   * On change of the bluetooth GATT Server, get all services and characteristics again
   */
  React.useEffect(() => {
    if (!server?.value) {
      setServices(null);
      return;
    }

    initializeCharacteristics(server.value);
  }, [server]);

  return (
    <ServiceContext.Provider value={{ value: services } as IServiceContext}>
      <Sensors_AccelerationProvider>
        <Sensors_BatteryLevelProvider>
          <Sensors_OrientationProvider>
            <Sensors_DataPollingProvider>
              <UI_RgbLedProvider>{props.children}</UI_RgbLedProvider>
            </Sensors_DataPollingProvider>
          </Sensors_OrientationProvider>
        </Sensors_BatteryLevelProvider>
      </Sensors_AccelerationProvider>
    </ServiceContext.Provider>
  );

  async function initializeCharacteristics(btServer: BluetoothRemoteGATTServer): Promise<boolean> {
    if (!btServer) {
      return false;
    }

    try {
      const environmentService = await btServer.getPrimaryService(ServiceUuid.ENVIRONMENT_SENSING);
      const pressure = await environmentService.getCharacteristic(CharacteristicUuid.PRESSURE);
      const temperature = await environmentService.getCharacteristic(CharacteristicUuid.TEMPERATURE);
      const humidity = await environmentService.getCharacteristic(CharacteristicUuid.HUMIDITY);
      const uvIndex = await environmentService.getCharacteristic(CharacteristicUuid.UV_INDEX);
      const soundLevel = await environmentService.getCharacteristic(CharacteristicUuid.SOUND_LEVEL);
      const ambientLight = await environmentService.getCharacteristic(CharacteristicUuid.AMBIENT_LIGHT_REACT);

      const indoorAirQualityService = await btServer.getPrimaryService(ServiceUuid.INDOOR_AIR_QUALITY);
      const co2 = await indoorAirQualityService.getCharacteristic(CharacteristicUuid.CO2_READING);
      const voc = await indoorAirQualityService.getCharacteristic(CharacteristicUuid.TVOC_READING);

      const batteryService = await btServer.getPrimaryService(ServiceUuid.BATTERY);
      const batteryLevel = await batteryService.getCharacteristic(CharacteristicUuid.BATTERY_LEVEL);

      const accelerationOrientationService = await btServer.getPrimaryService(ServiceUuid.ACCELERATION_ORIENTATION);
      const acceleration = await accelerationOrientationService.getCharacteristic(CharacteristicUuid.ACCELERATION);
      const orientation = await accelerationOrientationService.getCharacteristic(CharacteristicUuid.ORIENTATION);

      const userInterfaceService = await btServer.getPrimaryService(ServiceUuid.USER_INTERFACE);
      const rgbLeds = await userInterfaceService.getCharacteristic(CharacteristicUuid.RGB_LEDS);

      setServices({
        environment: {
          service: environmentService,
          characteristics: {
            pressure: pressure,
            temperature: temperature,
            humidity: humidity,
            uvIndex: uvIndex,
            soundLevel: soundLevel,
            ambientLight: ambientLight,
          },
        },
        indoorAirQuality: {
          service: indoorAirQualityService,
          characteristics: {
            co2: co2,
            voc: voc,
          },
        },
        battery: {
          service: batteryService,
          characteristics: {
            batteryLevel: batteryLevel,
          },
        },
        accelerationOrientation: {
          service: accelerationOrientationService,
          characteristics: {
            acceleration: acceleration,
            orientation: orientation,
          },
        },
        userInterface: {
          service: userInterfaceService,
          characteristics: { rgbLeds: rgbLeds },
        },
      });

      log('[SUCCESS] ServiceProvider.initializeCharacteristics: Got all characteristics!');
    } catch (error) {
      log('[ERROR] ServiceProvider.initializeCharacteristics: ' + error);
      return false;
    }

    return true;
  }

  /**
   * Logging for debbuging purposes.
   */
  function log(msg: string) {
    const formattedMessage = `[${new Date().toLocaleTimeString()}]: ${msg}`;
    console.log(formattedMessage);
  }
};
