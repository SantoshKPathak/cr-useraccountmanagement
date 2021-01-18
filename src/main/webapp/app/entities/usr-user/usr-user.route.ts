import { Injectable } from '@angular/core';
import { HttpResponse } from '@angular/common/http';
import { Resolve, ActivatedRouteSnapshot, Routes, Router } from '@angular/router';
import { Observable, of, EMPTY } from 'rxjs';
import { flatMap } from 'rxjs/operators';

import { Authority } from 'app/shared/constants/authority.constants';
import { UserRouteAccessService } from 'app/core/auth/user-route-access-service';
import { IUsrUser, UsrUser } from 'app/shared/model/usr-user.model';
import { UsrUserService } from './usr-user.service';
import { UsrUserComponent } from './usr-user.component';
import { UsrUserDetailComponent } from './usr-user-detail.component';
import { UsrUserUpdateComponent } from './usr-user-update.component';

@Injectable({ providedIn: 'root' })
export class UsrUserResolve implements Resolve<IUsrUser> {
  constructor(private service: UsrUserService, private router: Router) {}

  resolve(route: ActivatedRouteSnapshot): Observable<IUsrUser> | Observable<never> {
    const usrUid = route.params['usrUid'];
    if (usrUid) {
      return this.service.find(usrUid).pipe(
        flatMap((usrUser: HttpResponse<UsrUser>) => {
          if (usrUser.body) {
            return of(usrUser.body);
          } else {
            this.router.navigate(['404']);
            return EMPTY;
          }
        })
      );
    }
    return of(new UsrUser());
  }
}

export const usrUserRoute: Routes = [
  {
    path: '',
    component: UsrUserComponent,
    data: {
      authorities: [Authority.USER],
      pageTitle: 'User Account',
    },
    canActivate: [UserRouteAccessService],
  },
  {
    path: ':usrUid/view',
    component: UsrUserDetailComponent,
    resolve: {
      usrUser: UsrUserResolve,
    },
    data: {
      authorities: [Authority.USER],
      pageTitle: 'User Account',
    },
    canActivate: [UserRouteAccessService],
  },
  {
    path: 'new',
    component: UsrUserUpdateComponent,
    resolve: {
      usrUser: UsrUserResolve,
    },
    data: {
      authorities: [Authority.USER],
      pageTitle: 'User Account',
    },
    canActivate: [UserRouteAccessService],
  },
  {
    path: ':usrUid/edit',
    component: UsrUserUpdateComponent,
    resolve: {
      usrUser: UsrUserResolve,
    },
    data: {
      authorities: [Authority.USER],
      pageTitle: 'User Account',
    },
    canActivate: [UserRouteAccessService],
  },
];
