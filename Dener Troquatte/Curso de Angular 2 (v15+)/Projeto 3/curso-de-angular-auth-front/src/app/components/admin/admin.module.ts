import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { AdminRoutingModule } from './admin-routing.module';
import { AuthenticatedComponent } from './pages/authenticated/authenticated.component';
import { HomeComponent } from './pages/home/home.component';
import { HeaderComponent } from 'src/app/core/components/header/header.component';


@NgModule({
  declarations: [
    AuthenticatedComponent,
    HomeComponent,
    HeaderComponent
  ],
  imports: [
    CommonModule,
    AdminRoutingModule
  ]
})
export class AdminModule { }
