import { BluetoothEvent } from '../../models/bluetooth/event/bluetoothEvent';
import { BluetoothRemoteGATTCharacteristic } from './../../models/bluetooth/bluetoothGATTCharacteristic';

export class BluetoothUtils {
  /**
   * Decodes a Uint8Array from the bluetooth protocol into a number.
   * @param rawValue The buffer that is returned on reading a characteristic / event value.
   * @param factor The factor that the number is stored in. 
   * Some values e.g. temperature will be floats where the last two digits represent the digits after the decimal point (factor: 0.01).
   */
  static parseNumber(rawValue: DataView, factor: number = 1): number {
    const decoded = new Uint8Array(rawValue.buffer);

    let value = 0;
    for (let i = decoded.length - 1; i >= 0; --i) {
      const byte = decoded[i];
      value = (value << 8) | byte;
    }

    return value * factor;
  }

  /**
   * Converts an unsiged 16 bit number to a signed 16 bit number.
   * @param val The value that has to be transformed.
   */
  static toSigned16Bit(val: number): number {
    const isNegative = val & 0x08000;
    if (!isNegative) {
      return val;
    }

    const signedValue = val & 0x7fff;
    const signed = -(1 << 15) + signedValue;
    return signed;
  }

  /**
   * Removes and then adds a "characteristicvaluechanged" listener on a characteristic that supports bluetooth-"notify"
   * May throw an error. Be sure to surround call with a try/catch
   * @param characteristic The characteristic on which to add a "characteristicvaluechanged" listener
   * @param handler The event handler function
   */
  static async addChangeListener(
    characteristic: BluetoothRemoteGATTCharacteristic  | null,
    handler: (event: BluetoothEvent) => void
  ): Promise<void> {
    if (!characteristic || !handler) {
      return;
    }

    characteristic.removeEventListener('characteristicvaluechanged', handler);
    await characteristic.stopNotifications();
    characteristic.addEventListener('characteristicvaluechanged', handler);
    await characteristic.startNotifications();
  }
}
