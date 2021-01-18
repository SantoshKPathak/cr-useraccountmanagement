import { ComponentFixture, TestBed, fakeAsync, tick } from '@angular/core/testing';
import { HttpResponse } from '@angular/common/http';
import { FormBuilder } from '@angular/forms';
import { of } from 'rxjs';

import { UserAccountManagementTestModule } from '../../../test.module';
import { UsrUserUpdateComponent } from 'app/entities/usr-user/usr-user-update.component';
import { UsrUserService } from 'app/entities/usr-user/usr-user.service';
import { UsrUser } from 'app/shared/model/usr-user.model';

describe('Component Tests', () => {
  describe('UsrUser Management Update Component', () => {
    let comp: UsrUserUpdateComponent;
    let fixture: ComponentFixture<UsrUserUpdateComponent>;
    let service: UsrUserService;

    beforeEach(() => {
      TestBed.configureTestingModule({
        imports: [UserAccountManagementTestModule],
        declarations: [UsrUserUpdateComponent],
        providers: [FormBuilder],
      })
        .overrideTemplate(UsrUserUpdateComponent, '')
        .compileComponents();

      fixture = TestBed.createComponent(UsrUserUpdateComponent);
      comp = fixture.componentInstance;
      service = fixture.debugElement.injector.get(UsrUserService);
    });

    describe('save', () => {
      it('Should call update service on save for existing entity', fakeAsync(() => {
        // GIVEN
        const entity = new UsrUser(123);
        spyOn(service, 'update').and.returnValue(of(new HttpResponse({ body: entity })));
        comp.updateForm(entity);
        // WHEN
        comp.save();
        tick(); // simulate async

        // THEN
        expect(service.update).toHaveBeenCalledWith(entity);
        expect(comp.isSaving).toEqual(false);
      }));

      it('Should call create service on save for new entity', fakeAsync(() => {
        // GIVEN
        const entity = new UsrUser();
        spyOn(service, 'create').and.returnValue(of(new HttpResponse({ body: entity })));
        comp.updateForm(entity);
        // WHEN
        comp.save();
        tick(); // simulate async

        // THEN
        expect(service.create).toHaveBeenCalledWith(entity);
        expect(comp.isSaving).toEqual(false);
      }));
    });
  });
});
