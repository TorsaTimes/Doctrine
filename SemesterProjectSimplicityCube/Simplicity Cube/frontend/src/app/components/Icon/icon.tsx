import React from 'react';
import { css, cx } from '@emotion/css';
import { IconName } from './types';
import { air_icon } from './../../../style/icons/air';
import { co2_icon } from '../../../style/icons/co2';

interface Props {
  iconName: IconName;
  size?: number;
}

export const Icon: React.FunctionComponent<Props> = (props: Props): JSX.Element => {
  const { iconName, size } = props;

  const styles = getStyles(size ?? 24);

  switch (iconName) {
    case 'co2':
      return <em className={cx(styles.materialIcon, styles.SVG, 'noselect')}>{co2_icon('#fff')}</em>;
    case 'air':
      return <em className={cx(styles.materialIcon, styles.SVG, 'noselect')}>{air_icon('#fff')}</em>;
  }

  return <em className={cx(styles.materialIcon, 'noselect')}>{iconName}</em>;
};

const getStyles = (size: number) => {
  return {
    icon: css`
      display: flex;
      align-items: center;
      justify-conent: center;
      height: 100%;
    `,
    materialIcon: css`
      display: inline-block;
      font-family: MaterialIcons;
      font-weight: normal;
      font-style: normal;
      font-size: ${size / 100}rem;
      text-align: center;
      letter-spacing: normal;
      text-transform: none;
      white-space: nowrap;
      word-wrap: normal;
      direction: ltr;
      font-feature-settings: 'liga';
      -moz-font-feature-settings: 'liga';
      -moz-osx-font-smoothing: grayscale;
    `,
    SVG: css`
      height: ${size / 100}rem;
      width: ${size / 100}rem;
    `,
  };
};
