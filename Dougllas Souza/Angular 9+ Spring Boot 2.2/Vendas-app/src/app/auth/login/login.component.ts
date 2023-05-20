import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent {

  formUsuario: FormGroup = this.formBuilder.group({
    usuario: ['', [Validators.required]],
    senha: ['', [Validators.required]]
  })

  constructor(
    private formBuilder: FormBuilder,
    private router: Router
  ) {

  }

  onSubmit(){
    localStorage.setItem('USUARIO', '1');
    this.router.navigate(['']);
  }

}
