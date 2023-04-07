import { BluetoothRemoteGATTCharacteristic } from '../bluetooth/bluetoothGATTCharacteristic';
import { BluetoothRemoteGATTService } from '../bluetooth/bluetoothRemoteGATTService';

interface Service {
  service: BluetoothRemoteGATTService;
  characteristics: any;
}

interface EnvironmentalService extends Service {
  characteristics: {
    pressure: BluetoothRemoteGATTCharacteristic;
    temperature: BluetoothRemoteGATTCharacteristic;
    humidity: BluetoothRemoteGATTCharacteristic;
    uvIndex: BluetoothRemoteGATTCharacteristic;
    soundLevel: BluetoothRemoteGATTCharacteristic;
    ambientLight: BluetoothRemoteGATTCharacteristic;
  };
}

interface IndoorAirQualityService extends Service {
  characteristics: {
    co2: BluetoothRemoteGATTCharacteristic;
    voc: BluetoothRemoteGATTCharacteristic;
  };
}

interface AccelerationOrientationService extends Service {
  characteristics: {
    acceleration: BluetoothRemoteGATTCharacteristic;
    orientation: BluetoothRemoteGATTCharacteristic;
  };
}

interface BatteryService extends Service {
  characteristics: {
    batteryLevel: BluetoothRemoteGATTCharacteristic;
  };
}

interface UserInterfaceService extends Service {
  characteristics: {
    rgbLeds: BluetoothRemoteGATTCharacteristic;
  };
}

export interface ThunderSense2Services {
  environment: EnvironmentalService;
  indoorAirQuality: IndoorAirQualityService;
  accelerationOrientation: AccelerationOrientationService;
  battery: BatteryService;
  userInterface: UserInterfaceService;
}
