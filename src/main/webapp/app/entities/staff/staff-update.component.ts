import { Component, OnInit } from '@angular/core';
import { HttpResponse } from '@angular/common/http';
// eslint-disable-next-line @typescript-eslint/no-unused-vars
import { FormBuilder, Validators } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { Observable } from 'rxjs';

import { IStaff, Staff } from 'app/shared/model/staff.model';
import { StaffService } from './staff.service';

@Component({
  selector: 'jhi-staff-update',
  templateUrl: './staff-update.component.html',
})
export class StaffUpdateComponent implements OnInit {
  isSaving = false;
  createDateDp: any;
  lastUpdateDateDp: any;

  editForm = this.fb.group({
    uid: [null, [Validators.required]],
    status: [],
    nameKey: [],
    firstName: [],
    middleName: [],
    lastName: [],
    usrUidCreatedBy: [],
    createDate: [],
    usrUidUpdatedBy: [],
    lastUpdateDate: [],
  });

  constructor(protected staffService: StaffService, protected activatedRoute: ActivatedRoute, private fb: FormBuilder) {}

  ngOnInit(): void {
    this.activatedRoute.data.subscribe(({ staff }) => {
      this.updateForm(staff);
    });
  }

  updateForm(staff: IStaff): void {
    this.editForm.patchValue({
      uid: staff.uid,
      status: staff.status,
      nameKey: staff.nameKey,
      firstName: staff.firstName,
      middleName: staff.middleName,
      lastName: staff.lastName,
      usrUidCreatedBy: staff.usrUidCreatedBy,
      createDate: staff.createDate,
      usrUidUpdatedBy: staff.usrUidUpdatedBy,
      lastUpdateDate: staff.lastUpdateDate,
    });
  }

  previousState(): void {
    window.history.back();
  }

  save(): void {
    this.isSaving = true;
    const staff = this.createFromForm();
    if (staff.uid !== undefined) {
      this.subscribeToSaveResponse(this.staffService.update(staff));
    } else {
      this.subscribeToSaveResponse(this.staffService.create(staff));
    }
  }

  private createFromForm(): IStaff {
    return {
      ...new Staff(),
      uid: this.editForm.get(['uid'])!.value,
      status: this.editForm.get(['status'])!.value,
      nameKey: this.editForm.get(['nameKey'])!.value,
      firstName: this.editForm.get(['firstName'])!.value,
      middleName: this.editForm.get(['middleName'])!.value,
      lastName: this.editForm.get(['lastName'])!.value,
      usrUidCreatedBy: this.editForm.get(['usrUidCreatedBy'])!.value,
      createDate: this.editForm.get(['createDate'])!.value,
      usrUidUpdatedBy: this.editForm.get(['usrUidUpdatedBy'])!.value,
      lastUpdateDate: this.editForm.get(['lastUpdateDate'])!.value,
    };
  }

  protected subscribeToSaveResponse(result: Observable<HttpResponse<IStaff>>): void {
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
}
