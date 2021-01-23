import { Component, OnInit, OnDestroy } from '@angular/core';
import { Observable } from 'rxjs';

import { LoginModalService } from 'app/core/login/login-modal.service';
import { AccountService } from 'app/core/auth/account.service';
import { Account } from 'app/core/user/account.model';
import { IUsrUser, UsrUser } from 'app/shared/model/usr-user.model';
import { FormBuilder, Validators } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { StaffService } from 'app/entities/staff/staff.service';
import { UsrUserService } from 'app/entities/usr-user/usr-user.service';
import { HttpResponse } from '@angular/common/http';

@Component({
  selector: 'jhi-home',
  templateUrl: './home.component.html',
  styleUrls: ['home.scss'],
})
export class HomeComponent implements OnInit, OnDestroy {
  account: Account | null = null;
  //  authSubscription?: Subscription;
  isSaving = false;

  userAccountForm = this.fb.group({
    usrId: [null, [Validators.required]],
  });

  constructor(
    private accountService: AccountService,
    private loginModalService: LoginModalService,
    protected usrUserService: UsrUserService,
    protected staffService: StaffService,
    protected activatedRoute: ActivatedRoute,
    private fb: FormBuilder
  ) {}

  ngOnInit(): void {
    //  this.authSubscription = this.accountService.getAuthenticationState().subscribe(account => (this.account = account));
  }

  isAuthenticated(): boolean {
    return this.accountService.isAuthenticated();
  }

  login(): void {
    this.loginModalService.open();
  }

  activate(): void {
    this.isSaving = true;
    const usrUser = this.createFromForm();
    if (usrUser.usrId !== undefined) {
      console.log('submitted userId:' + usrUser.usrId);
      this.subscribeToSaveResponse(this.usrUserService.activateAccount(usrUser));
    }
  }

  private createFromForm(): IUsrUser {
    return {
      ...new UsrUser(),
      usrId: this.userAccountForm.get(['usrId'])!.value.toUpperCase(),
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
    //  this.onReset();
  }

  protected onSaveError(): void {
    this.isSaving = false;
  }

  onReset(): void {
    this.userAccountForm.reset();
  }

  ngOnDestroy(): void {
    // if (this.authSubscription) {
    //   this.authSubscription.unsubscribe();
    // }
  }
}
