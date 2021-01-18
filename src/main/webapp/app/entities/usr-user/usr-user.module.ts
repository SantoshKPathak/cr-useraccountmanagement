import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';

import { UserAccountManagementSharedModule } from 'app/shared/shared.module';
import { UsrUserComponent } from './usr-user.component';
import { UsrUserDetailComponent } from './usr-user-detail.component';
import { UsrUserUpdateComponent } from './usr-user-update.component';
import { UsrUserDeleteDialogComponent } from './usr-user-delete-dialog.component';
import { usrUserRoute } from './usr-user.route';

@NgModule({
  imports: [UserAccountManagementSharedModule, RouterModule.forChild(usrUserRoute)],
  declarations: [UsrUserComponent, UsrUserDetailComponent, UsrUserUpdateComponent, UsrUserDeleteDialogComponent],
  entryComponents: [UsrUserDeleteDialogComponent],
})
export class UserAccountManagementUsrUserModule {}
