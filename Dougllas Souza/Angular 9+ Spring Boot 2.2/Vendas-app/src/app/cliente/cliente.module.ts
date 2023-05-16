import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';

import { ClienteRoutingModule } from './cliente-routing.module';
import { ClienteComponent } from './header/cliente.component';
import { CadastroComponent } from './cadastro/cadastro.component';
import { SharedModule } from '../shared/shared.module';
import { ListaClientesComponent } from './lista-clientes/lista-clientes.component';


@NgModule({
  declarations: [
    ClienteComponent,
    ListaClientesComponent,
    CadastroComponent
  ],
  imports: [
    CommonModule,
    ClienteRoutingModule,
    SharedModule,
    FormsModule,
    ReactiveFormsModule
  ],
  exports: [
    ClienteComponent
  ]
})
export class ClienteModule { }
