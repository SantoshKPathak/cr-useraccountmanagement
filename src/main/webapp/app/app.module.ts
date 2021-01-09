import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import './vendor';
import { UserAccountManagementSharedModule } from 'app/shared/shared.module';
import { UserAccountManagementCoreModule } from 'app/core/core.module';
import { UserAccountManagementAppRoutingModule } from './app-routing.module';
import { UserAccountManagementHomeModule } from './home/home.module';
import { UserAccountManagementEntityModule } from './entities/entity.module';
// jhipster-needle-angular-add-module-import JHipster will add new module here
import { MainComponent } from './layouts/main/main.component';
import { NavbarComponent } from './layouts/navbar/navbar.component';
import { FooterComponent } from './layouts/footer/footer.component';
import { PageRibbonComponent } from './layouts/profiles/page-ribbon.component';
import { ErrorComponent } from './layouts/error/error.component';

@NgModule({
  imports: [
    BrowserModule,
    UserAccountManagementSharedModule,
    UserAccountManagementCoreModule,
    UserAccountManagementHomeModule,
    // jhipster-needle-angular-add-module JHipster will add new module here
    UserAccountManagementEntityModule,
    UserAccountManagementAppRoutingModule,
  ],
  declarations: [MainComponent, NavbarComponent, ErrorComponent, PageRibbonComponent, FooterComponent],
  bootstrap: [MainComponent],
})
export class UserAccountManagementAppModule {}
