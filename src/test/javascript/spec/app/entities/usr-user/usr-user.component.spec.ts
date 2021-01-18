import { ComponentFixture, TestBed } from '@angular/core/testing';
import { of } from 'rxjs';
import { HttpHeaders, HttpResponse } from '@angular/common/http';

import { UserAccountManagementTestModule } from '../../../test.module';
import { UsrUserComponent } from 'app/entities/usr-user/usr-user.component';
import { UsrUserService } from 'app/entities/usr-user/usr-user.service';
import { UsrUser } from 'app/shared/model/usr-user.model';

describe('Component Tests', () => {
  describe('UsrUser Management Component', () => {
    let comp: UsrUserComponent;
    let fixture: ComponentFixture<UsrUserComponent>;
    let service: UsrUserService;

    beforeEach(() => {
      TestBed.configureTestingModule({
        imports: [UserAccountManagementTestModule],
        declarations: [UsrUserComponent],
      })
        .overrideTemplate(UsrUserComponent, '')
        .compileComponents();

      fixture = TestBed.createComponent(UsrUserComponent);
      comp = fixture.componentInstance;
      service = fixture.debugElement.injector.get(UsrUserService);
    });

    it('Should call load all on init', () => {
      // GIVEN
      const headers = new HttpHeaders().append('link', 'link;link');
      spyOn(service, 'query').and.returnValue(
        of(
          new HttpResponse({
            body: [new UsrUser(123)],
            headers,
          })
        )
      );

      // WHEN
      comp.ngOnInit();

      // THEN
      expect(service.query).toHaveBeenCalled();
      expect(comp.usrUsers && comp.usrUsers[0]).toEqual(jasmine.objectContaining({ id: 123 }));
    });
  });
});
