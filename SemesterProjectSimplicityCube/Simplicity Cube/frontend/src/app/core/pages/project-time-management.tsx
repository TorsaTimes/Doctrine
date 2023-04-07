import React from 'react';
import { css, cx } from '@emotion/css';
import { AppContext, IAppContext } from '../../provider/app-context.provider';
import { Project } from 'app/models/project/project';

interface Props {}

export const ProjectTimeManagement = (props: Props) => {
  const app = React.useContext<IAppContext>(AppContext);
  
  const styles = getStyles();

  const projects = app?.value?.projects ?? [];
  const selectedUserProjects = app?.value?.selectedUserProjects ?? [];
  const cubeSide = app?.value?.cubeSide ?? -1;
  const currentProject = app?.value?.currentProject ?? null;

  const currentUserProject = cubeSide >= 0 ? selectedUserProjects.find((x) => x.cubeFace === cubeSide) : undefined;
  const activeProjectId = currentUserProject?.projectId ?? -1;

  const selectedUserProjectIds = selectedUserProjects.filter((y) => y.selected == true).map((y) => y.projectId);

  const selectedProjects = projects.filter((x) => selectedUserProjectIds.includes(x.id));

  const sorted = [
    ...selectedProjects.filter((a) => a.id === activeProjectId),
    ...selectedProjects.filter((a) => a.id !== activeProjectId),
  ];

  console.log(currentProject);
  
  return (
    <div className={styles.container}>
      <div className={styles.content}>
        <h2>Project Time Management</h2>
        <div>
          <ul className={cx(styles.projectList)}>
            {sorted.map((_, idx) => (
              <li key={`project-${_.id}`} className={cx(styles.projectItem, 'noselect')}>
                <div className={cx(styles.projectInfo, idx === 0 ? styles.projectActive : styles.projectInactive)}>
                  <div className={styles.projectTitle}>{_.name}</div>
                  <div className={styles.description}>{_.description}</div>
                </div>
                {<div className={styles.projectTime}>00:00:00</div>}
              </li>
            ))}
          </ul>
        </div>
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

    projectList: css`
      background: #141619;
      border: 0.01rem solid #444;
      list-style-type: none;

      li {
        border-bottom: 0.01rem solid #444;
      }
      li:last-child {
        border-bottom: 0;
      }
    `,
    projectItem: css`
      display: flex;
      justify-content: center;
      flex-direction: row;
    `,
    projectInfo: css`
      display: flex;
      flex-direction: column;
      cursor: pointer;

      flex: 1;
      padding: 0.12rem;
    `,
    projectTime: css`
      display: flex;
      flex-direction: column;
      justify-content: center;
      align-items: center;

      border-left: 0.01rem solid #444;
      width: 0.8rem;
    `,

    projectTitle: css`
      font-size: 14px;
    `,
    description: css`
      color: #ccc;
      font-size: 12px;
    `,
    projectActive: css`
      background: #008a54;
    `,
    projectInactive: css`
      background: #141619;
      &:hover {
        background: #343639;
      }
    `,
  };
};
