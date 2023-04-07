import React from 'react';
import styled from 'styled-components';
import { css, cx } from '@emotion/css';

import { IUserContext, UserContext } from '../../provider/user.provider';
import { AppContext, IAppContext } from '../../provider/app-context.provider';

import { UserService } from '../services/user.service';

import { Icon } from './../../components/Icon/icon';
import { IconName } from '../../components/Icon/types';

import { CubeSide, CubicSide } from '../../models/project/types';

enum Color {
  RED = '#f00',
  GREEN = '#0f0',
  BLUE = '#00f',
  YELLOW = '#ff0',
  PURPLE = '#6600ff',
  CYAN = '#0ff',
  PINK = '#ff00ff',
  BLACK = '#000',
}
enum CubeSideIcon {
  ONE = 'looks_one',
  TWO = 'looks_two',
  THREE = 'looks_3',
  FOUR = 'looks_4',
  FIVE = 'looks_5',
  SIX = 'looks_6',
}

const colors: Color[] = [Color.RED, Color.GREEN, Color.BLUE, Color.YELLOW, Color.PURPLE, Color.CYAN, Color.PINK];

interface ProjectColorMapping {
  projectId: number;
  color: Color | string;
}

interface ProjectCubeSideMapping {
  projectId: number;
  cubeSide: CubeSide;
}

interface CubeSideIconMapping {
  side: CubeSide;
  icon: IconName;
}
const cubeSideIconMapping: CubeSideIconMapping[] = [
  { side: CubicSide.BOTTOM, icon: CubeSideIcon.ONE },
  { side: CubicSide.LEFT, icon: CubeSideIcon.TWO },
  { side: CubicSide.TOP, icon: CubeSideIcon.THREE },
  { side: CubicSide.RIGHT, icon: CubeSideIcon.FOUR },
  { side: CubicSide.FRONT, icon: CubeSideIcon.FIVE },
  { side: CubicSide.BACK, icon: CubeSideIcon.SIX },
];

interface Props {}

export const ProjectList = (props: Props) => {
  const user = React.useContext<IUserContext>(UserContext);
  const app = React.useContext<IAppContext>(AppContext);

  const projects = app?.value?.projects ?? [];
  const userProjects = app?.value?.userProjects ?? [];
  const selectedUserProjects = app?.value?.selectedUserProjects ?? [];

  const projectColors: ProjectColorMapping[] = userProjects.map((_) => {
    return { projectId: _.projectId, color: _.color ?? Color.BLACK };
  });
  const projectCubeSides: ProjectCubeSideMapping[] = userProjects.map((_) => {
    return { projectId: _.projectId, cubeSide: _.cubeFace ?? -1 };
  });

  const styles = getStyles();
  const cubeSideColors = assignCubeSideColors();

  const cubeSideSelection = (projectId: number) => {
    const projectCubeSide = projectCubeSides.find((x) => x.projectId === projectId)?.cubeSide ?? -1;
    const sideNumberIcon = cubeSideIconMapping.find((x) => x.side === projectCubeSide);

    const createCubeSideCell = (side: CubicSide) => {
      const mapping = cubeSideIconMapping.find((x) => x.side === side);
      if (!mapping) {
        return <td></td>;
      }

      return (
        <td
          style={{ color: cubeSideColors[side] }}
          className={styles.cubeSideCell}
          onClick={() => {
            changeProjectCubeSide(projectId, side);
          }}
        >
          <Icon iconName={mapping.icon} size={36}></Icon>
        </td>
      );
    };

    return (
      <Navbar_Dropdown className={cx(styles.navItemContent, 'noselect', styles.navItemInActive)}>
        <span>
          {projectCubeSide >= 0 && sideNumberIcon !== undefined && (
            <Icon size={36} iconName={sideNumberIcon.icon}></Icon>
          )}
        </span>
        <Navbar_DropdownContent style={{ background: '#141619', left: 0 }}>
          <table>
            <thead></thead>
            <tbody>
              <tr>
                <td></td>
                {createCubeSideCell(CubicSide.BACK)}
                <td></td>
                <td></td>
              </tr>
              <tr>
                {createCubeSideCell(CubicSide.LEFT)}
                {createCubeSideCell(CubicSide.BOTTOM)}
                {createCubeSideCell(CubicSide.RIGHT)}
                {createCubeSideCell(CubicSide.TOP)}
              </tr>
              <tr>
                <td></td>
                {createCubeSideCell(CubicSide.FRONT)}
                <td></td>
                <td></td>
              </tr>
            </tbody>
          </table>
        </Navbar_DropdownContent>
      </Navbar_Dropdown>
    );
  };
  const colorSelection = (projectId: number) => {
    return (
      <Navbar_Dropdown
        style={{
          background: projectColors.find((pc) => pc.projectId === projectId)?.color ?? Color.BLACK,
        }}
        className={cx(styles.navItemContent, 'noselect', styles.navItemInActive)}
      >
        <div className={styles.dropdownContainer}>
          <span className={styles.dropwownContainerContent}></span>
        </div>
        <Navbar_DropdownContent style={{ right: 0 }}>
          {colors
            .filter((color) => projectColors.find((pc) => pc.projectId === projectId)?.color !== color ?? false)
            .map((color) => {
              const selected = false;
              return (
                <div
                  onClick={() => {
                    changeProjectColor(projectId, color);
                  }}
                  key={color}
                  style={{ background: color }}
                  className={cx(styles.dropdownItem, selected ? styles.dropdownItemSelected : '')}
                ></div>
              );
            })}
        </Navbar_DropdownContent>
      </Navbar_Dropdown>
    );
  };

  return (
    <div>
      <h4>
        {selectedUserProjects.length}/{6} selected
      </h4>
      <ul className={cx(styles.projectList)}>
        {projects.map((project) => (
          <li key={`project-${project.id}`} className={cx(styles.projectItem, 'noselect')}>
            <div className={styles.projectCubeSide}>{cubeSideSelection(project.id)}</div>
            <div
              onClick={() => toggleProjectSelection(project.id)}
              className={cx(
                styles.projectInfo,
                selectedUserProjects.find((x) => x.projectId === project.id)
                  ? styles.projectActive
                  : styles.projectInactive
              )}
            >
              <div className={styles.projectTitle}>{project.name}</div>
              <div className={styles.description}>{project.description}</div>
            </div>
            <div className={styles.projectSettings}>{colorSelection(project.id)}</div>
          </li>
        ))}
      </ul>
    </div>
  );

  function assignCubeSideColors() {
    const assignedCubeSideColors = ['#fff', '#fff', '#fff', '#fff', '#fff', '#fff'];
    const selectedProjectColors = projectColors.filter(
      (x) => selectedUserProjects.find((y) => y.projectId === x.projectId) !== undefined
    );

    for (let i = 0; i < selectedProjectColors.length; ++i) {
      const selectedProjectColor = selectedProjectColors[i];

      const cubeSideProjects = projectCubeSides.filter((x) => x.projectId === selectedProjectColor.projectId);
      if (cubeSideProjects.length === 0) {
        continue;
      }
      const cubeSideProject = cubeSideProjects[0];
      assignedCubeSideColors[cubeSideProject.cubeSide] = selectedProjectColor.color;
    }

    return assignedCubeSideColors;
  }

  function toggleProjectSelection(projectId: number) {
    const isSelected = selectedUserProjects.find((x) => x.projectId === projectId) !== undefined;

    if (isSelected == true) {
      selectProject(projectId, false, () => {
        app.refreshProjects();
      });
    } else if (selectedUserProjects.length < 6) {
      selectProject(projectId, true, () => {
        app.refreshProjects();
      });
    }
  }

  function changeProjectColor(projectId: number, color: string) {
    updateUserProjectColor(projectId, color, () => {
      app.refreshProjects();
    });
  }

  function changeProjectCubeSide(projectId: number, cubeSide: CubeSide) {
    updateUserProjectCubeSide(projectId, cubeSide, () => {
      app.refreshProjects();
    });
  }

  /** REST-API calls */

  function selectProject(projectId: number, selected: boolean, successCallback: () => any) {
    UserService.postUserProjectSelected(user.value, projectId, selected)
      .then(() => {
        successCallback();
      })
      .catch((err) => console.error(err));
  }

  function updateUserProjectColor(projectId: number, color: string, successCallback: () => any) {
    UserService.postUserProjectColor(user.value, projectId, color)
      .then(() => {
        successCallback();
      })
      .catch((err) => console.error(err));
  }

  function updateUserProjectCubeSide(projectId: number, cubeSide: CubeSide, successCallback: () => any) {
    UserService.postUserProjectCubeSide(user.value, projectId, cubeSide)
      .then(() => {
        successCallback();
      })
      .catch((err) => console.error(err));
  }

  function setProjectActive(projectId: number, successCallback: () => any) {
    UserService.postUserProjectActive(user.value, projectId)
      .then(() => {
        successCallback();
      })
      .catch((err) => console.error(err));
  }
};

const getStyles = () => {
  return {
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
    projectSettings: css`
      display: flex;
      flex-direction: column;
      justify-content: center;
      align-items: center;

      border-left: 0.01rem solid #444;
      width: 0.48rem;
    `,
    projectCubeSide: css`
      display: flex;
      flex-direction: column;
      justify-content: center;
      align-items: center;

      border-right: 0.01rem solid #444;
      width: 0.48rem;
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

    dropdownContainer: css`
      display: flex;
      height: calc(100% + 0.02rem);
    `,
    dropwownContainerContent: css`
      margin: auto;
    `,
    dropdownItem: css`
      display: flex;
      justify-content: space-between;
      text-align: center;
      align-items: center;
      background: #202226;
      border-left: 0.02rem solid #444;
      line-height: 1;
      padding: 0.08rem;
      cursor: pointer;
      height: 0.24rem;
    `,
    dropdownItemSelected: css`
      border-left: 0.02rem solid #444;
    `,
    navItemContent: css`
      display: flex;
      color: white;
      cursor: pointer;
      padding: 0;
      transition: 0.5s;

      width: 0.36rem;
      height: 0.36rem;

      &:hover {
        border: 0.01rem solid purple;
      }
    `,
    navItemInActive: css`
      border: 0.01rem solid #444;
    `,
    navItemActive: css`
      border: 0.01rem solid #444;
    `,

    cubeSideCell: css`
      background: #202226;
      &:hover {
        background: #444;
      }
    `,
  };
};

const Navbar_DropdownContent = styled.div`
  display: none;
  position: absolute;
  min-width: 1.6rem;
  z-index: 2000;
  border: 0.02rem solid #aaa;
`;
const Navbar_Dropdown = styled.div`
  display: block;
  position: relative;
  &:hover ${Navbar_DropdownContent} {
    display: block;
  }
`;
