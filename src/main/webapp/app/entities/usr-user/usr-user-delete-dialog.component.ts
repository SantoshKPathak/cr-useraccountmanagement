import { Component } from '@angular/core';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { JhiEventManager } from 'ng-jhipster';

import { IUsrUser } from 'app/shared/model/usr-user.model';
import { UsrUserService } from './usr-user.service';

@Component({
  templateUrl: './usr-user-delete-dialog.component.html',
})
export class UsrUserDeleteDialogComponent {
  usrUser?: IUsrUser;

  constructor(protected usrUserService: UsrUserService, public activeModal: NgbActiveModal, protected eventManager: JhiEventManager) {}

  cancel(): void {
    this.activeModal.dismiss();
  }

  confirmDelete(usrUid: number): void {
    this.usrUserService.delete(usrUid).subscribe(() => {
      this.eventManager.broadcast('usrUserListModification');
      this.activeModal.close();
    });
  }
}
