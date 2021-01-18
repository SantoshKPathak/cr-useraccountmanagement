import { Component, OnInit } from '@angular/core';
import { HttpResponse } from '@angular/common/http';
// eslint-disable-next-line @typescript-eslint/no-unused-vars
import { FormBuilder, Validators } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { Observable } from 'rxjs';

import { IUsrUser, UsrUser } from 'app/shared/model/usr-user.model';
import { UsrUserService } from './usr-user.service';
import { IStaff } from 'app/shared/model/staff.model';
import { StaffService } from 'app/entities/staff/staff.service';

@Component({
  selector: 'jhi-usr-user-update',
  templateUrl: './usr-user-update.component.html',
})
export class UsrUserUpdateComponent implements OnInit {
  isSaving = false;
  staff: IStaff[] = [];
  usrDateAccountExpirationDp: any;
  usrDatePasswordExpirationDp: any;
  usrRecordStatusDateDp: any;
  usrCreateDateDp: any;
  usrLastUpdateDateDp: any;

  editForm = this.fb.group({
    usrUid: [null, [Validators.required]],
    usrStfUid: [],
    usrId: [null, [Validators.maxLength(32)]],
    usrAccountStatus: [null, [Validators.maxLength(1)]],
    usrDateAccountExpiration: [],
    usrAccountLockedYN: [null, [Validators.maxLength(1)]],
    usrRecordStatus: [null, [Validators.maxLength(1)]],
    usrDatePasswordExpiration: [],
    usrUserType: [null, [Validators.maxLength(1)]],
    usrRecordStatusDate: [],
    usrCreateDate: [],
    usrUsrUidCreatedBy: [],
    usrUsrUidUpdatedBy: [],
    usrLastUpdateDate: [],
    // staffId: [],
  });

  constructor(
    protected usrUserService: UsrUserService,
    protected staffService: StaffService,
    protected activatedRoute: ActivatedRoute,
    private fb: FormBuilder
  ) {}

  ngOnInit(): void {
    this.activatedRoute.data.subscribe(({ usrUser }) => {
      this.updateForm(usrUser);

      //  this.staffService.query().subscribe((res: HttpResponse<IStaff[]>) => (this.staff = res.body || []));
    });
  }

  updateForm(usrUser: IUsrUser): void {
    this.editForm.patchValue({
      usrUid: usrUser.usrUid,
      usrStfUid: usrUser.usrStfUid,
      usrId: usrUser.usrId,
      usrAccountStatus: usrUser.usrAccountStatus,
      usrDateAccountExpiration: usrUser.usrDateAccountExpiration,
      usrAccountLockedYN: usrUser.usrAccountLockedYN,
      usrRecordStatus: usrUser.usrRecordStatus,
      usrDatePasswordExpiration: usrUser.usrDatePasswordExpiration,
      usrUserType: usrUser.usrUserType,
      usrRecordStatusDate: usrUser.usrRecordStatusDate,
      usrCreateDate: usrUser.usrCreateDate,
      usrUsrUidCreatedBy: usrUser.usrUsrUidCreatedBy,
      usrUsrUidUpdatedBy: usrUser.usrUsrUidUpdatedBy,
      usrLastUpdateDate: usrUser.usrLastUpdateDate,
      //  staffId: usrUser.staffId,
    });
  }

  previousState(): void {
    window.history.back();
  }

  save(): void {
    this.isSaving = true;
    const usrUser = this.createFromForm();
    if (usrUser.usrUid !== undefined) {
      this.subscribeToSaveResponse(this.usrUserService.update(usrUser));
    } else {
      this.subscribeToSaveResponse(this.usrUserService.create(usrUser));
    }
  }

  private createFromForm(): IUsrUser {
    return {
      ...new UsrUser(),
      usrUid: this.editForm.get(['usrUid'])!.value,
      usrStfUid: this.editForm.get(['usrStfUid'])!.value,
      usrId: this.editForm.get(['usrId'])!.value,
      usrAccountStatus: this.editForm.get(['usrAccountStatus'])!.value,
      usrDateAccountExpiration: this.editForm.get(['usrDateAccountExpiration'])!.value,
      usrAccountLockedYN: this.editForm.get(['usrAccountLockedYN'])!.value,
      usrRecordStatus: this.editForm.get(['usrRecordStatus'])!.value,
      usrDatePasswordExpiration: this.editForm.get(['usrDatePasswordExpiration'])!.value,
      usrUserType: this.editForm.get(['usrUserType'])!.value,
      usrRecordStatusDate: this.editForm.get(['usrRecordStatusDate'])!.value,
      usrCreateDate: this.editForm.get(['usrCreateDate'])!.value,
      usrUsrUidCreatedBy: this.editForm.get(['usrUsrUidCreatedBy'])!.value,
      usrUsrUidUpdatedBy: this.editForm.get(['usrUsrUidUpdatedBy'])!.value,
      usrLastUpdateDate: this.editForm.get(['usrLastUpdateDate'])!.value,
      // staffId: this.editForm.get(['staffId'])!.value,
    };
  }

  protected subscribeToSaveResponse(result: Observable<HttpResponse<IUsrUser>>): void {
    result.subscribe(
      () => this.onSaveSuccess(),
      () => this.onSaveError()
    );
  }

  protected onSaveSuccess(): void {
    this.isSaving = false;
    this.previousState();
  }

  protected onSaveError(): void {
    this.isSaving = false;
  }

  trackById(index: number, item: IStaff): any {
    return item.uid;
  }
}
