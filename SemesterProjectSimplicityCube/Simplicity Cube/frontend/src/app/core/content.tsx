import React from 'react';
import { css, cx } from '@emotion/css';

interface Props {
  className?: any;
  children?: any;
}

export const Content: React.FunctionComponent<Props> = (props: Props): JSX.Element => {
  const { className, children } = props;

  const styles = getStyles();

  return (
    <main className={cx(styles.content, className ?? '')}>
      <section className={styles.mainContent}>{children}</section>
    </main>
  );
};
const getStyles = () => {
  return {
    content: css`
      display: flex;
      flex-direction: column;
      width: 100%;
      background: #202226;
      color: white;
      flex: 1;
      overflow: auto;
    `,
    mainContent: css`
      display: flex;
      width: 100%;
      flex: 1;
    `,
  };
};
