import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';

@NgModule({
  imports: [
    RouterModule.forChild([
      {
        path: 'staff',
        loadChildren: () => import('./staff/staff.module').then(m => m.UserAccountManagementStaffModule),
      },
      {
        path: 'usr-user',
        loadChildren: () => import('./usr-user/usr-user.module').then(m => m.UserAccountManagementUsrUserModule),
      },
      /* jhipster-needle-add-entity-route - JHipster will add entity modules routes here */
    ]),
  ],
})
export class UserAccountManagementEntityModule {}
