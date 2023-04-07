import React from 'react';

import { ProjectService } from '../core/services/project.service';
import { SensorService } from '../core/services/sensor.service';
import { UserService } from '../core/services/user.service';
import { HtmlUtils } from '../core/utils/html-utils';
import { Project } from '../models/project/project';
import { Sensor } from '../models/project/sensor';
import { UserProject } from '../models/project/userProject';
import {
  ISensors_AccelerationContext,
  Sensors_AccelerationContext,
} from './bluetooth/thundersense2/sensors/acceleration.provider';
import { IUI_RgbLedContext, UI_RgbLedContext } from './bluetooth/thundersense2/ui/rgb-Led.provider';
import { IUserContext, UserContext } from './user.provider';

interface Properties {
  children?: any;
}

export interface AppState {
  cubeSide: number;
  projects: Project[];
  userProjects: UserProject[];
  selectedUserProjects: UserProject[];
  sensors: Sensor[];
  timerTime: number[];
  currentProject: Project | null;
}

export interface IAppContext {
  value: AppState;
  refreshProjects: () => void;
  refreshSensors: () => void;
  refreshAll: () => void;
}

export const AppContext = React.createContext<any>({});

export const AppContextProvider = (props: Properties) => {
  const [state, setState] = React.useState<AppState>({
    cubeSide: -1,
    projects: [],
    userProjects: [],
    selectedUserProjects: [],
    sensors: [],
    timerTime: [],
    currentProject: null,
  });

  const [cubeSide, setCubeSide] = React.useState<number>(-1);
  const [userProjects, setUserProjects] = React.useState<UserProject[]>([]);
  const [selectedUserProjects, setSelectedUserProjects] = React.useState<UserProject[]>([]);
  const [projects, setProjects] = React.useState<Project[]>([]);
  const [sensors, setSensorlist] = React.useState<Sensor[]>([]);
  const [currentProject, setCurrentProject] = React.useState<(Project | null)>();
  const [timerTime, setTimerTime] = React.useState<number[]>([]);

  const user = React.useContext<IUserContext>(UserContext);
  const rgbLeds = React.useContext<IUI_RgbLedContext>(UI_RgbLedContext);


  /**
   * Initialize app state
   */
  React.useEffect(() => {
    if (!user?.value) {
      return;
    }
    refreshAll();
  }, [user]);

  /**
   * Send color of the cubeside to the rbg provider
   */
  React.useEffect(() => {
    async function setCubeColor() {
      if (!rgbLeds) {
        return;
      }

      const selectedUserProject = selectedUserProjects.find((x) => x.cubeFace === cubeSide);
      if (!selectedUserProject) {
        return;
      }

      rgbLeds.setValue(selectedUserProject.color ?? '');
    }
    setCubeColor();
  }, [cubeSide, selectedUserProjects]);

  /**
   * Create single app state from all sub states
   */
  React.useEffect(() => {
    const newAppState: AppState = {
      cubeSide: cubeSide,
      selectedUserProjects: selectedUserProjects,
      userProjects: userProjects,
      projects: projects,
      sensors: sensors,
      timerTime: timerTime,
      currentProject: currentProject || null, 
    };
    setState(newAppState);
  }, [cubeSide, selectedUserProjects, projects, userProjects, sensors, timerTime, currentProject]);

  return (
    <AppContext.Provider
      value={
        {
          value: state,
          refreshProjects: refreshProjects,
          refreshSensors: refreshSensors,
          refreshAll: refreshAll,
        } as IAppContext
      }
    >
      <CubeSideCalculator cubeSide={cubeSide} updateCubeSide={setCubeSide} />
      {props.children}
    </AppContext.Provider>
  );

  function refreshProjects() {
    getUserProjects();
    getProjects();
  }

  function refreshSensors() {
    getSensors();
  }

  function refreshAll() {
    getUserProjects();
    getProjects();
    getSensors();
  }

  function getUserProjects() {
    if (!user?.value) {
      console.error('User is was not initialized for AppContextProvider.getUserProjects()!');
      return;
    }

    UserService.getUserProjects(user?.value)
      .then((userProjects) => {
        setUserProjects(userProjects);

        // Calculate those that are selected by the user
        const selectedUserProjects = userProjects.filter((x) => x.selected == true);
        setSelectedUserProjects(selectedUserProjects);
      })
      .catch((err) => console.error(err));
  }

  function getProjects() {
    ProjectService.getProjects()
      .then((projects) => setProjects(projects))
      .catch((err) => console.error(err));
  }

  function getSensors() {
    SensorService.getSensors()
      .then((sensors) => setSensorlist(sensors))
      .catch((err) => console.error(err));
  }

  function getCurrentUserProject(){
    const currentUserProject = cubeSide >= 0 ? selectedUserProjects.find((x) => x.cubeFace === cubeSide) : undefined;
    const activeProjectId = currentUserProject?.projectId ?? -1;
    const selectedUserProjectIds = selectedUserProjects.filter((y) => y.selected == true).map((y) => y.projectId);
    const selectedProjects = projects.filter((x) => selectedUserProjectIds.includes(x.id));
    const cp = selectedProjects.filter((a) => a.id === activeProjectId);
    setCurrentProject(cp[0]);
  }
};

interface CubeSideCalculatorProperties {
  cubeSide: number;
  updateCubeSide: (value: number) => void;
}
const CubeSideCalculator = (props: CubeSideCalculatorProperties) => {
  const { cubeSide, updateCubeSide } = props;

  const [lastAcceleration, setLastAcceleration] = React.useState<number[]>([]);

  const accelerationData = React.useContext<ISensors_AccelerationContext>(Sensors_AccelerationContext);

  function calculateCurrenteCubeSite(acceleration: number[]) {
    if (acceleration.length < 3) {
      return;
    }

    const x = acceleration[0];
    const y = acceleration[1];
    const z = acceleration[2];

    const last_x = lastAcceleration[0];
    const last_y = lastAcceleration[1];
    const last_z = lastAcceleration[2];

    const maxDelta = 0.5;
    const anyDeltaTooHigh =
      Math.abs(last_x - x) > maxDelta || Math.abs(last_y - y) > maxDelta || Math.abs(last_z - z) > maxDelta;

    setLastAcceleration(acceleration);
    if (anyDeltaTooHigh) {
      return;
    }

    // Calculate current side
    let newCubeSide = cubeSide;
    if (z > 8 && z < 12) {
      newCubeSide = 0;
    } else if (z < -8 && z > -12) {
      newCubeSide = 2;
    } else if (x > 8 && x < 12) {
      newCubeSide = 1;
    } else if (x < -8 && x > -12) {
      newCubeSide = 3;
    } else if (y > 8 && y < 12) {
      newCubeSide = 4;
    } else if (y < -8 && y > -12) {
      newCubeSide = 5;
    }

    if (newCubeSide !== cubeSide) {
      updateCubeSide(newCubeSide);
    }
  }

  React.useEffect(() => {
    if (!accelerationData?.value) {
      return;
    }

    calculateCurrenteCubeSite(accelerationData.value.latestValue.value);
  }, [accelerationData]);

  return <div></div>;
};
