export class HtmlUtils {
  static hexToRgba(hex: string): { r: number; g: number; b: number; a: number } | null {
    if (hex.charAt(0) !== '#') {
      return null;
    }

    // #fff which equals #ffffff 
    if (hex.length === 4) {
      const result = /^#?([a-f\d]{1})([a-f\d]{1})([a-f\d]{1})$/i.exec(hex);
      return result
        ? {
            r: parseInt(result[1].concat(result[1]), 16),
            g: parseInt(result[2].concat(result[2]), 16),
            b: parseInt(result[3].concat(result[3]), 16),
            a: 255,
          }
        : null;
    }
  
    // #ffffff and so on
    const result = /^#?([a-f\d]{2})([a-f\d]{2})([a-f\d]{2})$/i.exec(hex);
    return result
      ? {
          r: parseInt(result[1], 16),
          g: parseInt(result[2], 16),
          b: parseInt(result[3], 16),
          a: 255,
        }
      : null;
  }
}
