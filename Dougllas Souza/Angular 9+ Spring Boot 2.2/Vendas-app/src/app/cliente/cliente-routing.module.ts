import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ListaClientesComponent } from './lista-clientes/lista-clientes.component';
import { FormComponent } from './form/form.component';

const routes: Routes = [
  {
    path: '', redirectTo: 'clientes', pathMatch: 'full'
  },
  {
    path: 'cadastrar', component: FormComponent
  },
  {
    path: 'atualizar/:id', component: FormComponent
  },
  {
    path: 'clientes', component: ListaClientesComponent
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class ClienteRoutingModule { }
