import { Component, Inject, Output } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Cliente } from '../models/Cliente';
import { ClienteService } from '../cliente.service';
import { MatDialog } from '@angular/material/dialog';
import { DialogComponent } from 'src/app/shared/material/dialog/dialog.component';
import { Router } from '@angular/router';

@Component({
  selector: 'app-cadastro',
  templateUrl: './cadastro.component.html',
  styleUrls: ['./cadastro.component.scss']
})
export class CadastroComponent {

  @Output() msgComponent: string = 'Aqui você pode cadastrar um cliente';

  public formCliente: FormGroup = this.formBuilder.group({
    nome: ['', [Validators.required]],
    cpf: ['', [Validators.required, Validators.maxLength(11), Validators.minLength(11)]],
    sexo: [0, [Validators.required]]
  });

  constructor(
    private formBuilder: FormBuilder,
    private clienteService: ClienteService,
    private dialog: MatDialog,
    private router: Router
  ) {}

  onSubmit() {
    let cliente = new Cliente(this.formCliente.value.nome,
                              this.formCliente.value.cpf,
                              this.formCliente.value.sexo);
    this.formCliente.reset();
    this.formCliente.get('sexo')?.setValue(0)
    this.clienteService
      .salvar(cliente)
      .subscribe({
        next: () => {
          this.dialog.open(DialogComponent, {
            data: {
              title: "Sucesso!",
              msg: 'Cliente criado com sucesso!'
            }
          });
          this.router.navigate(['./clientes'])
        },
        error: (err) => {
          this.dialog.open(DialogComponent, {
            data: {
              title: 'Erro!',
              msg: err.error.errors
            }
          });
        }
      });
    this.formCliente.enable();
  }
}

