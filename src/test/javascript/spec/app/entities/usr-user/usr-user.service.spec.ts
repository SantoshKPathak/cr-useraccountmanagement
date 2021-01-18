import { TestBed, getTestBed } from '@angular/core/testing';
import { HttpClientTestingModule, HttpTestingController } from '@angular/common/http/testing';
import * as moment from 'moment';
import { DATE_FORMAT } from 'app/shared/constants/input.constants';
import { UsrUserService } from 'app/entities/usr-user/usr-user.service';
import { IUsrUser, UsrUser } from 'app/shared/model/usr-user.model';

describe('Service Tests', () => {
  describe('UsrUser Service', () => {
    let injector: TestBed;
    let service: UsrUserService;
    let httpMock: HttpTestingController;
    let elemDefault: IUsrUser;
    let expectedResult: IUsrUser | IUsrUser[] | boolean | null;
    let currentDate: moment.Moment;

    beforeEach(() => {
      TestBed.configureTestingModule({
        imports: [HttpClientTestingModule],
      });
      expectedResult = null;
      injector = getTestBed();
      service = injector.get(UsrUserService);
      httpMock = injector.get(HttpTestingController);
      currentDate = moment();

      elemDefault = new UsrUser(
        0,
        0,
        0,
        'AAAAAAA',
        'AAAAAAA',
        currentDate,
        'AAAAAAA',
        'AAAAAAA',
        currentDate,
        'AAAAAAA',
        currentDate,
        currentDate,
        0,
        0,
        currentDate
      );
    });

    describe('Service methods', () => {
      it('should find an element', () => {
        const returnedFromService = Object.assign(
          {
            usrDateAccountExpiration: currentDate.format(DATE_FORMAT),
            usrDatePasswordExpiration: currentDate.format(DATE_FORMAT),
            usrRecordStatusDate: currentDate.format(DATE_FORMAT),
            usrCreateDate: currentDate.format(DATE_FORMAT),
            usrLastUpdateDate: currentDate.format(DATE_FORMAT),
          },
          elemDefault
        );

        service.find(123).subscribe(resp => (expectedResult = resp.body));

        const req = httpMock.expectOne({ method: 'GET' });
        req.flush(returnedFromService);
        expect(expectedResult).toMatchObject(elemDefault);
      });

      it('should create a UsrUser', () => {
        const returnedFromService = Object.assign(
          {
            id: 0,
            usrDateAccountExpiration: currentDate.format(DATE_FORMAT),
            usrDatePasswordExpiration: currentDate.format(DATE_FORMAT),
            usrRecordStatusDate: currentDate.format(DATE_FORMAT),
            usrCreateDate: currentDate.format(DATE_FORMAT),
            usrLastUpdateDate: currentDate.format(DATE_FORMAT),
          },
          elemDefault
        );

        const expected = Object.assign(
          {
            usrDateAccountExpiration: currentDate,
            usrDatePasswordExpiration: currentDate,
            usrRecordStatusDate: currentDate,
            usrCreateDate: currentDate,
            usrLastUpdateDate: currentDate,
          },
          returnedFromService
        );

        service.create(new UsrUser()).subscribe(resp => (expectedResult = resp.body));

        const req = httpMock.expectOne({ method: 'POST' });
        req.flush(returnedFromService);
        expect(expectedResult).toMatchObject(expected);
      });

      it('should update a UsrUser', () => {
        const returnedFromService = Object.assign(
          {
            usrUid: 1,
            usrStfUid: 1,
            usrId: 'BBBBBB',
            usrAccountStatus: 'BBBBBB',
            usrDateAccountExpiration: currentDate.format(DATE_FORMAT),
            usrAccountLockedYN: 'BBBBBB',
            usrRecordStatus: 'BBBBBB',
            usrDatePasswordExpiration: currentDate.format(DATE_FORMAT),
            usrUserType: 'BBBBBB',
            usrRecordStatusDate: currentDate.format(DATE_FORMAT),
            usrCreateDate: currentDate.format(DATE_FORMAT),
            usrUsrUidCreatedBy: 1,
            usrUsrUidUpdatedBy: 1,
            usrLastUpdateDate: currentDate.format(DATE_FORMAT),
          },
          elemDefault
        );

        const expected = Object.assign(
          {
            usrDateAccountExpiration: currentDate,
            usrDatePasswordExpiration: currentDate,
            usrRecordStatusDate: currentDate,
            usrCreateDate: currentDate,
            usrLastUpdateDate: currentDate,
          },
          returnedFromService
        );

        service.update(expected).subscribe(resp => (expectedResult = resp.body));

        const req = httpMock.expectOne({ method: 'PUT' });
        req.flush(returnedFromService);
        expect(expectedResult).toMatchObject(expected);
      });

      it('should return a list of UsrUser', () => {
        const returnedFromService = Object.assign(
          {
            usrUid: 1,
            usrStfUid: 1,
            usrId: 'BBBBBB',
            usrAccountStatus: 'BBBBBB',
            usrDateAccountExpiration: currentDate.format(DATE_FORMAT),
            usrAccountLockedYN: 'BBBBBB',
            usrRecordStatus: 'BBBBBB',
            usrDatePasswordExpiration: currentDate.format(DATE_FORMAT),
            usrUserType: 'BBBBBB',
            usrRecordStatusDate: currentDate.format(DATE_FORMAT),
            usrCreateDate: currentDate.format(DATE_FORMAT),
            usrUsrUidCreatedBy: 1,
            usrUsrUidUpdatedBy: 1,
            usrLastUpdateDate: currentDate.format(DATE_FORMAT),
          },
          elemDefault
        );

        const expected = Object.assign(
          {
            usrDateAccountExpiration: currentDate,
            usrDatePasswordExpiration: currentDate,
            usrRecordStatusDate: currentDate,
            usrCreateDate: currentDate,
            usrLastUpdateDate: currentDate,
          },
          returnedFromService
        );

        service.query().subscribe(resp => (expectedResult = resp.body));

        const req = httpMock.expectOne({ method: 'GET' });
        req.flush([returnedFromService]);
        httpMock.verify();
        expect(expectedResult).toContainEqual(expected);
      });

      it('should delete a UsrUser', () => {
        service.delete(123).subscribe(resp => (expectedResult = resp.ok));

        const req = httpMock.expectOne({ method: 'DELETE' });
        req.flush({ status: 200 });
        expect(expectedResult);
      });
    });

    afterEach(() => {
      httpMock.verify();
    });
  });
});
