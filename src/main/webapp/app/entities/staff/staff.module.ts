import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';

import { UserAccountManagementSharedModule } from 'app/shared/shared.module';
import { StaffComponent } from './staff.component';
import { StaffDetailComponent } from './staff-detail.component';
import { StaffUpdateComponent } from './staff-update.component';
import { StaffDeleteDialogComponent } from './staff-delete-dialog.component';
import { staffRoute } from './staff.route';

@NgModule({
  imports: [UserAccountManagementSharedModule, RouterModule.forChild(staffRoute)],
  declarations: [StaffComponent, StaffDetailComponent, StaffUpdateComponent, StaffDeleteDialogComponent],
  entryComponents: [StaffDeleteDialogComponent],
})
export class UserAccountManagementStaffModule {}
