import { JhiAlertService } from 'ng-jhipster';
import { HttpInterceptor, HttpRequest, HttpResponse, HttpHandler, HttpEvent } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { tap } from 'rxjs/operators';

@Injectable()
export class NotificationInterceptor implements HttpInterceptor {
  constructor(private alertService: JhiAlertService) {}

  intercept(request: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
    return next.handle(request).pipe(
      tap((event: HttpEvent<any>) => {
        if (event instanceof HttpResponse) {
          let alert: string | null = null;
          let alertError: string | null = null;
          event.headers.keys().forEach(entry => {
            // console.log('NotificationInterceptor::' + entry);
            if (entry.toLowerCase().endsWith('app-alert')) {
              alert = event.headers.get(entry);
              //  console.log('NotificationInterceptor app-alert::' + alert);
            }
            // if (entry.toLowerCase().endsWith('app-params')) {
            //   // alert = event.headers.get(entry);
            //   console.log('NotificationInterceptor app-params::' + event.headers.get(entry));
            // }
            if (entry.toLowerCase().endsWith('app-error')) {
              alertError = event.headers.get(entry);
              // console.log('NotificationInterceptor app-error::' + alertError);
            }
          });

          if (alertError) {
            this.alertService.error(alertError);
          } else if (alert) {
            this.alertService.success(alert);
          }
        }
      })
    );
  }
}
