export interface IDbQueryError {
  code: number;
  json: any;
}

export function okResponse(response: any) {
  response.status(200).json({});
}

export function handleError(response: any, error: IDbQueryError, funcName: string) {
  console.error(`[ERROR/${error.code}] ${funcName}:`, error.json);
  response.status(error.code).json(error.json);
}
