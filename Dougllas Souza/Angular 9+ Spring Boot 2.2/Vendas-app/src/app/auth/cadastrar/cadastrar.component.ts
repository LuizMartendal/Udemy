import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-cadastrar',
  templateUrl: './cadastrar.component.html',
  styleUrls: ['./cadastrar.component.scss']
})
export class CadastrarComponent {

  firstFormUsuario: FormGroup = this.formBuilder.group({
    usuario: ['', [Validators.required]],
    senha: ['', [Validators.required]]
  });

  secondFormUsuario: FormGroup = this.formBuilder.group({
    nome: ['', [Validators.required]],
    email: [''],
    sexo: ['', [Validators.required]],
    dataNascimento: ['', [Validators.required]]
  });

  generos: string[] = ['MASCULINO', 'FEMININO', 'OUTRO'];

  constructor(
    private formBuilder: FormBuilder
  ) {

  }
}
