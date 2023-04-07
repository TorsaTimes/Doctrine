import React from 'react';
import { css, cx } from '@emotion/css';

interface Selectable {
  label: string;
  description?: string;
  value: any;
}

interface Props {
  value: Selectable[];
  onSelectionChanged: () => void;
}

export const Select = (props: Props) => {
  const styles = getStyles();

  return <div></div>;
};

const getStyles = () => {
  return {
    dummy: css``,
  };
};
