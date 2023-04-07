export interface DataPoint<T> {
  timestamp: Date;
  value: T;
}

export interface SensorReading<T> {
  latestValue: DataPoint<T>;
}
