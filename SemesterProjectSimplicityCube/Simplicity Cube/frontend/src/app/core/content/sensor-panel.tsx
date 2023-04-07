import React from 'react';
import { css, cx } from '@emotion/css';

import { IconName } from '../../components/Icon/types';
import { Icon } from '../../components/Icon/icon';

type valueType = number | null;

export enum ValueQuality {
  Good,
  Mediocre,
  Bad,
  Unknown,
}

interface Properties {
  title: string;
  iconName: IconName;
  valuesPrefix?: string[];
  values: valueType[];
  unit: string;
  decimals?: number;
  valueQuality: ValueQuality;
}

export const SensorPanel = (props: Properties) => {
  const { iconName, title, values, valuesPrefix, unit, decimals, valueQuality } = props;
  const styles = getStyles();

  const displayValues = () => {
    const content: JSX.Element[] = [];
    for (let i = 0; i < values.length; ++i) {
      const val = toDisplayValue(values[i]);
      const prefix = valuesPrefix ? (valuesPrefix.length >= i ? valuesPrefix[i] + ': ' : '') : '';
      content.push(<div key={i}>{prefix + val + ' ' + unit}</div>);
    }
    return content;
  };

  let qualityStateClass: string;
  switch (valueQuality) {
    case ValueQuality.Bad:
      qualityStateClass = styles.badValue;
      break;
    case ValueQuality.Mediocre:
      qualityStateClass = styles.mediocreValue;
      break;
    case ValueQuality.Good:
      qualityStateClass = styles.goodValue;
      break;
    case ValueQuality.Unknown:
    default:
      qualityStateClass = styles.unknownValue;
      break;
  }

  return (
    <div className={cx(styles.container, qualityStateClass)}>
      <span className={styles.head}>
        <Icon iconName={iconName} size={36}></Icon>
        <span>{title}</span>
      </span>
      <span className={styles.content}>{displayValues()}</span>
    </div>
  );

  function toDisplayValue(value: number | null): string {
    if (value === null) {
      return '-';
    }
    const useDecimals = decimals ?? 0;
    return value.toFixed(useDecimals);
  }
};

const getStyles = () => {
  return {
    container: css`
      display: inline-flex;
      flex-direction: column;
      padding: 0.12rem;
      min-height: 1.2rem;
      width: 1.8rem;
    `,
    head: css`
      display: flex;
      flex-direction: row;
      justify-content: space-between;
      align-items: center;
      font-size: 0.18rem;
      white-space: nowrap;
    `,
    content: css`
      flex: 1;
      font-size: 0.24rem;
      display: flex;
      align-items: center;
      justify-content: center;
      flex-direction: column;
    `,

    unknownValue: css`
      background: purple;
      color: #eee;
    `,
    goodValue: css`
      background: #008a54;
      color: #eee;
    `,
    mediocreValue: css`
      background: darkorange;
      color: #eee;
    `,
    badValue: css`
      background: red;
      color: #eee;
    `,
  };
};
