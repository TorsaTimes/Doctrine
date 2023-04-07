export interface UserProject {
  id?: number;
  userId: number;
  projectId: number;
  color?: string;
  cubeFace?: number;
  active?: boolean;
  selected?: boolean;
}