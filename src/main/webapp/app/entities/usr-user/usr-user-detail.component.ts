import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

import { IUsrUser } from 'app/shared/model/usr-user.model';

@Component({
  selector: 'jhi-usr-user-detail',
  templateUrl: './usr-user-detail.component.html',
})
export class UsrUserDetailComponent implements OnInit {
  usrUser: IUsrUser | null = null;

  constructor(protected activatedRoute: ActivatedRoute) {}

  ngOnInit(): void {
    this.activatedRoute.data.subscribe(({ usrUser }) => (this.usrUser = usrUser));
  }

  previousState(): void {
    window.history.back();
  }
}
