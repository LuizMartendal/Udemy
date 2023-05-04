import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { SignComponent } from './pages/sign/sign.component';

const routes: Routes = [
  {
    path: '',
    component: SignComponent
  },
  {
    path: 'admin',
    loadChildren: () => import('../../../components/admin/admin.module').then(m => m.AdminModule)
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class AuthRoutingModule { }
