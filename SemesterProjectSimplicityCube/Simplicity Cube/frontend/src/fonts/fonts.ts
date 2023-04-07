import { injectGlobal } from '@emotion/css';

import roboto_woff2 from './Roboto-Regular.woff2';
import matIcon_woff2 from './MaterialIconsRound-Regular.woff2';

injectGlobal`
@font-face {
  font-family: 'Roboto';
  src: url(${roboto_woff2}) format('woff2');
  font-weight: normal;
  font-style: normal;
}
@font-face {
  font-family: 'MaterialIcons';
  src: url(${matIcon_woff2}) format('woff2');
  font-weight: normal;
  font-style: normal;
}
`;
