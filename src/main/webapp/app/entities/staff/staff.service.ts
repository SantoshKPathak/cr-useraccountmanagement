import { Injectable } from '@angular/core';
import { HttpClient, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';
import * as moment from 'moment';

import { DATE_FORMAT } from 'app/shared/constants/input.constants';
import { SERVER_API_URL } from 'app/app.constants';
import { createRequestOption } from 'app/shared/util/request-util';
import { IStaff } from 'app/shared/model/staff.model';

type EntityResponseType = HttpResponse<IStaff>;
type EntityArrayResponseType = HttpResponse<IStaff[]>;

@Injectable({ providedIn: 'root' })
export class StaffService {
  public resourceUrl = SERVER_API_URL + 'api/staff';

  constructor(protected http: HttpClient) {}

  create(staff: IStaff): Observable<EntityResponseType> {
    const copy = this.convertDateFromClient(staff);
    return this.http
      .post<IStaff>(this.resourceUrl, copy, { observe: 'response' })
      .pipe(map((res: EntityResponseType) => this.convertDateFromServer(res)));
  }

  update(staff: IStaff): Observable<EntityResponseType> {
    const copy = this.convertDateFromClient(staff);
    return this.http
      .put<IStaff>(this.resourceUrl, copy, { observe: 'response' })
      .pipe(map((res: EntityResponseType) => this.convertDateFromServer(res)));
  }

  find(uid: number): Observable<EntityResponseType> {
    return this.http
      .get<IStaff>(`${this.resourceUrl}/${uid}`, { observe: 'response' })
      .pipe(map((res: EntityResponseType) => this.convertDateFromServer(res)));
  }

  query(req?: any): Observable<EntityArrayResponseType> {
    const options = createRequestOption(req);
    return this.http
      .get<IStaff[]>(this.resourceUrl, { params: options, observe: 'response' })
      .pipe(map((res: EntityArrayResponseType) => this.convertDateArrayFromServer(res)));
  }

  delete(uid: number): Observable<HttpResponse<{}>> {
    return this.http.delete(`${this.resourceUrl}/${uid}`, { observe: 'response' });
  }

  protected convertDateFromClient(staff: IStaff): IStaff {
    const copy: IStaff = Object.assign({}, staff, {
      createDate: staff.createDate && staff.createDate.isValid() ? staff.createDate.format(DATE_FORMAT) : undefined,
      lastUpdateDate: staff.lastUpdateDate && staff.lastUpdateDate.isValid() ? staff.lastUpdateDate.format(DATE_FORMAT) : undefined,
    });
    return copy;
  }

  protected convertDateFromServer(res: EntityResponseType): EntityResponseType {
    if (res.body) {
      res.body.createDate = res.body.createDate ? moment(res.body.createDate) : undefined;
      res.body.lastUpdateDate = res.body.lastUpdateDate ? moment(res.body.lastUpdateDate) : undefined;
    }
    return res;
  }

  protected convertDateArrayFromServer(res: EntityArrayResponseType): EntityArrayResponseType {
    if (res.body) {
      res.body.forEach((staff: IStaff) => {
        staff.createDate = staff.createDate ? moment(staff.createDate) : undefined;
        staff.lastUpdateDate = staff.lastUpdateDate ? moment(staff.lastUpdateDate) : undefined;
      });
    }
    return res;
  }
}
