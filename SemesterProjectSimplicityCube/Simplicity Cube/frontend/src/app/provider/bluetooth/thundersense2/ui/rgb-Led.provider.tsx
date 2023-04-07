import React from 'react';
import { HtmlUtils } from '../../../../core/utils/html-utils';

import { IServiceContext, ServiceContext } from '../service.provider';

interface Properties {
  children?: any;
}

export interface IUI_RgbLedContext {
  value: Uint8Array | null;
  setValue: (color: string) => void;
}

export const UI_RgbLedContext = React.createContext<any>({});

export const UI_RgbLedProvider = (props: Properties) => {
  const [value, setValue] = React.useState<Uint8Array | null>(null);
  const [writeFinished, setWriteFinished] = React.useState<boolean>(true);

  const services = React.useContext<IServiceContext>(ServiceContext);
  const characteristic = services?.value?.userInterface?.characteristics?.rgbLeds;

  React.useEffect(() => {
    if (!services?.value) {
      setWriteFinished(false);
      return;
    }

    if (!characteristic) {
      setWriteFinished(false);
      return;
    }

    setWriteFinished(true);
  }, [services]);

  return (
    <UI_RgbLedContext.Provider value={{ value, setValue: updateValue }}>{props.children}</UI_RgbLedContext.Provider>
  );

  function updateValue(color: string) {
    const parsedColor = HtmlUtils.hexToRgba(color);
    if (!parsedColor) {
      return;
    }

    const encodedColor = new Uint8Array([parsedColor.a, parsedColor.r, parsedColor.g, parsedColor.b]);

    setValue(encodedColor);
    writeValue(encodedColor);
  }

  /**
   * Writes the selected RGB(A) Color to the board.
   */
  async function writeValue(color: Uint8Array) {
    if (!characteristic) {
      return;
    }
    if (!writeFinished) {
      return;
    }

    setWriteFinished(false);

    try {
      await characteristic.writeValue(color);
    } catch (error) {
      log('[ERROR] Sensors_RgbLedProvider.writeValue: ' + error);
    }

    setWriteFinished(true);
  }

  /**
   * Logging for debbuging purposes.
   */
  function log(msg: string) {
    const formattedMessage = `[${new Date().toLocaleTimeString()}]: ${msg}`;
    console.log(formattedMessage);
  }
};
