import { SensorReading } from '../data';

interface Environmental {
  pressure?: SensorReading<number>;
  temperature?: SensorReading<number>;
  humidity?: SensorReading<number>;
  uvIndex?: SensorReading<number>;
  soundLevel?: SensorReading<number>;
  ambientLight?: SensorReading<number>;
}

interface IndoorAirQuality {
  co2?: SensorReading<number>;
  voc?: SensorReading<number>;
}

interface AccelerationOrientation {
  acceleration?: SensorReading<number[]>;
  orientation?: SensorReading<number[]>;
}

interface Battery {
  batteryLevel?: SensorReading<number>;
}

interface UserInterface {
  rgbLeds?: Uint8Array;
}

export interface ThunderSense2SensorData {
  environment?: Environmental;
  indoorAirQuality?: IndoorAirQuality;
  accelerationOrientation?: AccelerationOrientation;
  battery?: Battery;
  userInterface?: UserInterface;
}
