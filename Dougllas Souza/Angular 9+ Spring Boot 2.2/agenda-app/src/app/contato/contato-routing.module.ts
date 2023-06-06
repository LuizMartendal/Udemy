import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { NewContatoComponent } from './new-contato/new-contato.component';

const routes: Routes = [
  {
    path: '', redirectTo: 'new', pathMatch: 'full'
  },
  {
    path: 'new', component: NewContatoComponent
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class ContatoRoutingModule { }
