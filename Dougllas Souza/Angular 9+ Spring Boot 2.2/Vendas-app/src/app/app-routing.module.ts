import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './home/home.component';

const routes: Routes = [
  {
    path: '', redirectTo: 'home', pathMatch: 'full'
  },
  {
    path: 'home', component: HomeComponent
  },
  {
    path: 'cliente',
    loadChildren: () => import('../app/cliente/cliente.module').then(c => c.ClienteModule)
  },
  {
    path: 'servico',
    loadChildren: () => import('./servico/servico.module').then(m => m.ServicoModule)
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
