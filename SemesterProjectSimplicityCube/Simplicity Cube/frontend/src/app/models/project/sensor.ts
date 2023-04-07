export enum SensorType {
  temperature = 'temperature',
  pressure = 'pressure',
  humidity = 'humidity',
  uv_index = 'uv_index',
  sound_level = 'sound_level',
  ambient_light = 'ambient_light',
  acceleration_x = 'acceleration_x',
  acceleration_y = 'acceleration_y',
  acceleration_z = 'acceleration_z',
  orientation_x = 'orientation_x',
  orientation_y = 'orientation_y',
  orientation_z = 'orientation_z',
  battery_level = 'battery_level',
  co2 = 'co2',
  voc = 'voc',
}

export interface Sensor {
  id: number;
  name: SensorType;
}
