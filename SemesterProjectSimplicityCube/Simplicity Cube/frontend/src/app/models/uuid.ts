import { BluetoothCharacteristicUUID, BluetoothDescriptorUUID, BluetoothServiceUUID } from './bluetooth/bluetoothUUID';

export class ServiceUuid {
  static readonly GENERIC_ACCESS: BluetoothServiceUUID = '00001800-0000-1000-8000-00805f9b34fb';
  static readonly GENERIC_ATTRIBUTE: BluetoothServiceUUID = '00001801-0000-1000-8000-00805f9b34fb';
  static readonly DEVICE_INFORMATION: BluetoothServiceUUID = '0000180a-0000-1000-8000-00805f9b34fb';
  static readonly BATTERY: BluetoothServiceUUID = '0000180f-0000-1000-8000-00805f9b34fb';
  static readonly AUTOMATION_IO: BluetoothServiceUUID = '00001815-0000-1000-8000-00805f9b34fb';
  /** NOT_AVAILABLE */
  static readonly CSC: BluetoothServiceUUID = '00001816-0000-1000-8000-00805f9b34fb';
  static readonly ENVIRONMENT_SENSING: BluetoothServiceUUID = '0000181a-0000-1000-8000-00805f9b34fb';
  static readonly ACCELERATION_ORIENTATION: BluetoothServiceUUID = 'a4e649f4-4be5-11e5-885d-feff819cdc9f';
  /** NOT_AVAILABLE */
  static readonly AMBIENT_LIGHT: BluetoothServiceUUID = 'd24c4f4e-17a7-4548-852c-abf51127368b';
  static readonly INDOOR_AIR_QUALITY: BluetoothServiceUUID = 'efd658ae-c400-ef33-76e7-91b00019103b';
  /** Magnetic Field Service */
  static readonly HALL_EFFECT: BluetoothServiceUUID = 'f598dbc5-2f00-4ec5-9936-b3d1aa4f957f';
  static readonly USER_INTERFACE: BluetoothServiceUUID = 'fcb89c40-c600-59f3-7dc3-5ece444a401b';
  static readonly POWER_MANAGEMENT: BluetoothServiceUUID = 'ec61a454-ed00-a5e8-b8f9-de9ec026ec51';
}

export class CharacteristicUuid {
  static readonly DEVICE_NAME: BluetoothCharacteristicUUID = '00002a00-0000-1000-8000-00805f9b34fb'; // Generic Access Service
  static readonly APPEARANCE: BluetoothCharacteristicUUID = '00002a01-0000-1000-8000-00805f9b34fb';
  static readonly ATTRIBUTE_CHANGED: BluetoothCharacteristicUUID = '00002a05-0000-1000-8000-00805f9b34fb';
  static readonly SYSTEM_ID: BluetoothCharacteristicUUID = '00002a23-0000-1000-8000-00805f9b34fb';
  static readonly MODEL_NUMBER: BluetoothCharacteristicUUID = '00002a24-0000-1000-8000-00805f9b34fb'; // Device Information Service
  static readonly SERIAL_NUMBER: BluetoothCharacteristicUUID = '00002a25-0000-1000-8000-00805f9b34fb'; // Device Information Service
  static readonly FIRMWARE_REVISION: BluetoothCharacteristicUUID = '00002a26-0000-1000-8000-00805f9b34fb';
  static readonly HARDWARE_REVISION: BluetoothCharacteristicUUID = '00002a27-0000-1000-8000-00805f9b34fb';
  static readonly MANUFACTURER_NAME: BluetoothCharacteristicUUID = '00002a29-0000-1000-8000-00805f9b34fb';
  
  static readonly BATTERY_LEVEL: BluetoothCharacteristicUUID = '00002a19-0000-1000-8000-00805f9b34fb'; // Battery Service
  static readonly POWER_SOURCE: BluetoothCharacteristicUUID = 'EC61A454-ED01-A5E8-B8F9-DE9EC026EC51';
  
  static readonly CSC_CONTROL_POINT: BluetoothCharacteristicUUID = '00002a55-0000-1000-8000-00805f9b34fb'; // CSC Service
  static readonly CSC_MEASUREMENT: BluetoothCharacteristicUUID = '00002a5b-0000-1000-8000-00805f9b34fb';
  static readonly CSC_FEATURE: BluetoothCharacteristicUUID = '00002a5c-0000-1000-8000-00805f9b34fb';
  static readonly CSC_UNKNOWN: BluetoothCharacteristicUUID = '9f70a8fc-826c-4c6f-9c72-41b81d1c9561';

  /** Environment Service */
  static readonly PRESSURE: BluetoothCharacteristicUUID = '00002a6d-0000-1000-8000-00805f9b34fb';
  /** Environment Service */
  static readonly TEMPERATURE: BluetoothCharacteristicUUID = '00002a6e-0000-1000-8000-00805f9b34fb';
  /** Environment Service */
  static readonly HUMIDITY: BluetoothCharacteristicUUID = '00002a6f-0000-1000-8000-00805f9b34fb';
  /** Environment Service */
  static readonly UV_INDEX: BluetoothCharacteristicUUID = '00002a76-0000-1000-8000-00805f9b34fb';
  /** Environment Service */
  static readonly SOUND_LEVEL: BluetoothCharacteristicUUID = 'c8546913-bf02-45eb-8dde-9f8754f4a32e';
  /** Environment Service */
  static readonly ENV_CONTROL_POINT: BluetoothCharacteristicUUID = 'c8546913-bf03-45eb-8dde-9f8754f4a32e';
  /** Environment Service React board -> Actually works with Thunder Sense 2?! */
  static readonly AMBIENT_LIGHT_REACT: BluetoothCharacteristicUUID = 'c8546913-bfd9-45eb-8dde-9f8754f4a32e'; // Ambient Light Service for React board
  /** Environment Service Sense board */
  static readonly AMBIENT_LIGHT_SENSE: BluetoothCharacteristicUUID = 'c8546913-bf01-45eb-8dde-9f8754f4a32e'; // Ambient Light Service for Sense board

  /** Indoor Air Quality Service */
  static readonly CO2_READING: BluetoothCharacteristicUUID = 'efd658ae-c401-ef33-76e7-91b00019103b';
  /** Indoor Air Quality Service */
  static readonly TVOC_READING: BluetoothCharacteristicUUID = 'efd658ae-c402-ef33-76e7-91b00019103b';
  /** Indoor Air Quality Service */
  static readonly AIR_QUALITY_CONTROL_POINT: BluetoothCharacteristicUUID = 'efd658ae-c403-ef33-76e7-91b00019103b';

  static readonly HALL_STATE: BluetoothCharacteristicUUID = 'f598dbc5-2f01-4ec5-9936-b3d1aa4f957f';
  static readonly HALL_FIELD_STRENGTH: BluetoothCharacteristicUUID = 'f598dbc5-2f02-4ec5-9936-b3d1aa4f957f';
  static readonly HALL_CONTROL_POINT: BluetoothCharacteristicUUID = 'f598dbc5-2f03-4ec5-9936-b3d1aa4f957f';
  /** ACCELERATION ORIENTATION Service  */
  static readonly ACCELERATION: BluetoothCharacteristicUUID = 'c4c1f6e2-4be5-11e5-885d-feff819cdc9f'; // Accelarion and Orientation Service
  static readonly ORIENTATION: BluetoothCharacteristicUUID = 'b7c4b694-bee3-45dd-ba9f-f3b5e994f49a';
  
  static readonly CALIBRATE: BluetoothCharacteristicUUID = '71e30b8c-4131-4703-b0a0-b0bbba75856b';
  static readonly PUSH_BUTTONS: BluetoothCharacteristicUUID = 'fcb89c40-c601-59f3-7dc3-5ece444a401b';
  static readonly LEDS: BluetoothCharacteristicUUID = 'fcb89c40-c602-59f3-7dc3-5ece444a401b';
  static readonly RGB_LEDS: BluetoothCharacteristicUUID = 'fcb89c40-c603-59f3-7dc3-5ece444a401b';
  static readonly UI_CONTROL_POINT: BluetoothCharacteristicUUID = 'fcb89c40-c604-59f3-7dc3-5ece444a401b';
  static readonly DIGITAL: BluetoothCharacteristicUUID = '00002a56-0000-1000-8000-00805f9b34fb'; // Automation IO Service
}

export class DescriptorUuid {
  static readonly CLIENT_CHARACTERISTIC_CONFIGURATION: BluetoothDescriptorUUID = '00002902-0000-1000-8000-00805f9b34fb'; // Descriptors
  static readonly CHARACTERISTIC_PRESENTATION_FORMAT: BluetoothDescriptorUUID = '00002904-0000-1000-8000-00805f9b34fb';
}
