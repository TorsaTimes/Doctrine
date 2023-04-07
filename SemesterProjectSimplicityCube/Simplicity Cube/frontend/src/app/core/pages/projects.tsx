import React from 'react';
import { css, cx } from '@emotion/css';
import { ProjectList } from '../content/project-list';

interface Props {}

export const Projects = (props: Props) => {
  const styles = getStyles();

  return (
    <div className={styles.container}>
      <div className={styles.content}>
        <h2>Active Projects</h2>
        <ProjectList></ProjectList>
      </div>
    </div>
  );
};

const getStyles = () => {
  return {
    container: css`
      width: 100%;
      flex: 1;
      padding-bottom: 0.6rem;
      background: #202226;
      color: white;
    `,

    content: css`
      display: flex;
      flex-direction: column;
      padding: 0.12rem;

      h2 {
        margin-bottom: 0.12rem;
      }
    `,
  };
};
