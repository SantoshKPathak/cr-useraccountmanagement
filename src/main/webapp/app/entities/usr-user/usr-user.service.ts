import { Injectable } from '@angular/core';
import { HttpClient, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';
import * as moment from 'moment';

import { DATE_FORMAT } from 'app/shared/constants/input.constants';
import { SERVER_API_URL } from 'app/app.constants';
import { createRequestOption } from 'app/shared/util/request-util';
import { IUsrUser } from 'app/shared/model/usr-user.model';

type EntityResponseType = HttpResponse<IUsrUser>;
type EntityArrayResponseType = HttpResponse<IUsrUser[]>;

@Injectable({ providedIn: 'root' })
export class UsrUserService {
  public resourceUrl = SERVER_API_URL + 'api/usr-users';
  public cr_resourceUrl = SERVER_API_URL + 'api/cr-user';

  constructor(protected http: HttpClient) {}

  create(usrUser: IUsrUser): Observable<EntityResponseType> {
    const copy = this.convertDateFromClient(usrUser);
    return this.http
      .post<IUsrUser>(this.resourceUrl, copy, { observe: 'response' })
      .pipe(map((res: EntityResponseType) => this.convertDateFromServer(res)));
  }

  update(usrUser: IUsrUser): Observable<EntityResponseType> {
    const copy = this.convertDateFromClient(usrUser);
    return this.http
      .put<IUsrUser>(this.resourceUrl, copy, { observe: 'response' })
      .pipe(map((res: EntityResponseType) => this.convertDateFromServer(res)));
  }

  activateAccount(usrUser: IUsrUser): Observable<EntityResponseType> {
    //  const copy = this.convertDateFromClient(usrUser);
    return this.http.put<IUsrUser>(`${this.cr_resourceUrl}/activate`, usrUser, { observe: 'response' });
    //  .pipe(map((res: EntityResponseType) => this.convertDateFromServer(res)));
  }

  find(usrUid: number): Observable<EntityResponseType> {
    return this.http
      .get<IUsrUser>(`${this.resourceUrl}/${usrUid}`, { observe: 'response' })
      .pipe(map((res: EntityResponseType) => this.convertDateFromServer(res)));
  }

  query(req?: any): Observable<EntityArrayResponseType> {
    const options = createRequestOption(req);
    return this.http
      .get<IUsrUser[]>(this.resourceUrl, { params: options, observe: 'response' })
      .pipe(map((res: EntityArrayResponseType) => this.convertDateArrayFromServer(res)));
  }

  delete(usrUid: number): Observable<HttpResponse<{}>> {
    return this.http.delete(`${this.resourceUrl}/${usrUid}`, { observe: 'response' });
  }

  protected convertDateFromClient(usrUser: IUsrUser): IUsrUser {
    const copy: IUsrUser = Object.assign({}, usrUser, {
      usrDateAccountExpiration:
        usrUser.usrDateAccountExpiration && usrUser.usrDateAccountExpiration.isValid()
          ? usrUser.usrDateAccountExpiration.format(DATE_FORMAT)
          : undefined,
      usrDatePasswordExpiration:
        usrUser.usrDatePasswordExpiration && usrUser.usrDatePasswordExpiration.isValid()
          ? usrUser.usrDatePasswordExpiration.format(DATE_FORMAT)
          : undefined,
      usrRecordStatusDate:
        usrUser.usrRecordStatusDate && usrUser.usrRecordStatusDate.isValid() ? usrUser.usrRecordStatusDate.format(DATE_FORMAT) : undefined,
      usrCreateDate: usrUser.usrCreateDate && usrUser.usrCreateDate.isValid() ? usrUser.usrCreateDate.format(DATE_FORMAT) : undefined,
      usrLastUpdateDate:
        usrUser.usrLastUpdateDate && usrUser.usrLastUpdateDate.isValid() ? usrUser.usrLastUpdateDate.format(DATE_FORMAT) : undefined,
    });
    return copy;
  }

  protected convertDateFromServer(res: EntityResponseType): EntityResponseType {
    if (res.body) {
      res.body.usrDateAccountExpiration = res.body.usrDateAccountExpiration ? moment(res.body.usrDateAccountExpiration) : undefined;
      res.body.usrDatePasswordExpiration = res.body.usrDatePasswordExpiration ? moment(res.body.usrDatePasswordExpiration) : undefined;
      res.body.usrRecordStatusDate = res.body.usrRecordStatusDate ? moment(res.body.usrRecordStatusDate) : undefined;
      res.body.usrCreateDate = res.body.usrCreateDate ? moment(res.body.usrCreateDate) : undefined;
      res.body.usrLastUpdateDate = res.body.usrLastUpdateDate ? moment(res.body.usrLastUpdateDate) : undefined;
    }
    return res;
  }

  protected convertDateArrayFromServer(res: EntityArrayResponseType): EntityArrayResponseType {
    if (res.body) {
      res.body.forEach((usrUser: IUsrUser) => {
        usrUser.usrDateAccountExpiration = usrUser.usrDateAccountExpiration ? moment(usrUser.usrDateAccountExpiration) : undefined;
        usrUser.usrDatePasswordExpiration = usrUser.usrDatePasswordExpiration ? moment(usrUser.usrDatePasswordExpiration) : undefined;
        usrUser.usrRecordStatusDate = usrUser.usrRecordStatusDate ? moment(usrUser.usrRecordStatusDate) : undefined;
        usrUser.usrCreateDate = usrUser.usrCreateDate ? moment(usrUser.usrCreateDate) : undefined;
        usrUser.usrLastUpdateDate = usrUser.usrLastUpdateDate ? moment(usrUser.usrLastUpdateDate) : undefined;
      });
    }
    return res;
  }
}
