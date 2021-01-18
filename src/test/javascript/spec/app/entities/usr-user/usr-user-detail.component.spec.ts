import { ComponentFixture, TestBed } from '@angular/core/testing';
import { ActivatedRoute } from '@angular/router';
import { of } from 'rxjs';

import { UserAccountManagementTestModule } from '../../../test.module';
import { UsrUserDetailComponent } from 'app/entities/usr-user/usr-user-detail.component';
import { UsrUser } from 'app/shared/model/usr-user.model';

describe('Component Tests', () => {
  describe('UsrUser Management Detail Component', () => {
    let comp: UsrUserDetailComponent;
    let fixture: ComponentFixture<UsrUserDetailComponent>;
    const route = ({ data: of({ usrUser: new UsrUser(123) }) } as any) as ActivatedRoute;

    beforeEach(() => {
      TestBed.configureTestingModule({
        imports: [UserAccountManagementTestModule],
        declarations: [UsrUserDetailComponent],
        providers: [{ provide: ActivatedRoute, useValue: route }],
      })
        .overrideTemplate(UsrUserDetailComponent, '')
        .compileComponents();
      fixture = TestBed.createComponent(UsrUserDetailComponent);
      comp = fixture.componentInstance;
    });

    describe('OnInit', () => {
      it('Should load usrUser on init', () => {
        // WHEN
        comp.ngOnInit();

        // THEN
        expect(comp.usrUser).toEqual(jasmine.objectContaining({ id: 123 }));
      });
    });
  });
});
