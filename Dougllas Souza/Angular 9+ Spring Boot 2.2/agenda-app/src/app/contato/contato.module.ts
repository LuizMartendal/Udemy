import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { ContatoRoutingModule } from './contato-routing.module';
import { NewContatoComponent } from './new-contato/new-contato.component';
import { SharedModule } from '../shared/shared.module';


@NgModule({
  declarations: [
    NewContatoComponent
  ],
  imports: [
    CommonModule,
    ContatoRoutingModule,
    SharedModule
  ],
  exports: [
    SharedModule
  ]
})
export class ContatoModule { }
