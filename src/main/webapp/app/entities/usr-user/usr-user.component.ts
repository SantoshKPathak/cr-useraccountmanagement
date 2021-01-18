import { Component, OnInit, OnDestroy } from '@angular/core';
import { HttpResponse } from '@angular/common/http';
import { Subscription } from 'rxjs';
import { JhiEventManager } from 'ng-jhipster';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';

import { IUsrUser } from 'app/shared/model/usr-user.model';
import { UsrUserService } from './usr-user.service';
import { UsrUserDeleteDialogComponent } from './usr-user-delete-dialog.component';

@Component({
  selector: 'jhi-usr-user',
  templateUrl: './usr-user.component.html',
})
export class UsrUserComponent implements OnInit, OnDestroy {
  usrUsers?: IUsrUser[];
  eventSubscriber?: Subscription;

  constructor(protected usrUserService: UsrUserService, protected eventManager: JhiEventManager, protected modalService: NgbModal) {}

  loadAll(): void {
    this.usrUserService.query().subscribe((res: HttpResponse<IUsrUser[]>) => (this.usrUsers = res.body || []));
  }

  ngOnInit(): void {
    this.loadAll();
    this.registerChangeInUsrUsers();
  }

  ngOnDestroy(): void {
    if (this.eventSubscriber) {
      this.eventManager.destroy(this.eventSubscriber);
    }
  }

  trackId(index: number, item: IUsrUser): number {
    // eslint-disable-next-line @typescript-eslint/no-unnecessary-type-assertion
    return item.usrUid!;
  }

  registerChangeInUsrUsers(): void {
    this.eventSubscriber = this.eventManager.subscribe('usrUserListModification', () => this.loadAll());
  }

  delete(usrUser: IUsrUser): void {
    const modalRef = this.modalService.open(UsrUserDeleteDialogComponent, { size: 'lg', backdrop: 'static' });
    modalRef.componentInstance.usrUser = usrUser;
  }
}
