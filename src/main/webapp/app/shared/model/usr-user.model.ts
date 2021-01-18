import { Moment } from 'moment';

export interface IUsrUser {
  id?: number;
  usrUid?: number;
  usrStfUid?: number;
  usrId?: string;
  usrAccountStatus?: string;
  usrDateAccountExpiration?: Moment;
  usrAccountLockedYN?: string;
  usrRecordStatus?: string;
  usrDatePasswordExpiration?: Moment;
  usrUserType?: string;
  usrRecordStatusDate?: Moment;
  usrCreateDate?: Moment;
  usrUsrUidCreatedBy?: number;
  usrUsrUidUpdatedBy?: number;
  usrLastUpdateDate?: Moment;
  staffId?: number;
}

export class UsrUser implements IUsrUser {
  constructor(
    public id?: number,
    public usrUid?: number,
    public usrStfUid?: number,
    public usrId?: string,
    public usrAccountStatus?: string,
    public usrDateAccountExpiration?: Moment,
    public usrAccountLockedYN?: string,
    public usrRecordStatus?: string,
    public usrDatePasswordExpiration?: Moment,
    public usrUserType?: string,
    public usrRecordStatusDate?: Moment,
    public usrCreateDate?: Moment,
    public usrUsrUidCreatedBy?: number,
    public usrUsrUidUpdatedBy?: number,
    public usrLastUpdateDate?: Moment,
    public staffId?: number
  ) {}
}
