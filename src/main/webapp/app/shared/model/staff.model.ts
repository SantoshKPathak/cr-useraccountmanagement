import { Moment } from 'moment';
import { IUsrUser } from 'app/shared/model/usr-user.model';

export interface IStaff {
  uid?: number;
  status?: string;
  nameKey?: string;
  firstName?: string;
  middleName?: string;
  lastName?: string;
  usrUidCreatedBy?: number;
  createDate?: Moment;
  usrUidUpdatedBy?: number;
  lastUpdateDate?: Moment;
  users?: IUsrUser[];
}

export class Staff implements IStaff {
  constructor(
    public uid?: number,
    public status?: string,
    public nameKey?: string,
    public firstName?: string,
    public middleName?: string,
    public lastName?: string,
    public usrUidCreatedBy?: number,
    public createDate?: Moment,
    public usrUidUpdatedBy?: number,
    public lastUpdateDate?: Moment,
    public users?: IUsrUser[]
  ) {}
}
