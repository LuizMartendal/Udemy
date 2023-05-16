import { Component, OnInit, Output } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ClienteService } from 'src/app/cliente/service/cliente.service';
import { Servico } from '../models/Servico';
import { ServicoService } from '../service/servico.service';
import { MatDialog } from '@angular/material/dialog';
import { DialogComponent } from 'src/app/shared/material/dialog/dialog.component';

@Component({
  selector: 'app-form',
  templateUrl: './form.component.html',
  styleUrls: ['./form.component.scss']
})
export class FormComponent implements OnInit {

  @Output() msgComponent: string = 'Aqui você pode cadastrar um serviço';
  @Output() component: string = 'Serviço';

  formServico: FormGroup = this.formBuilder.group({
    servico: ['', [Validators.required]],
    valor: ['', [Validators.required]],
    cliente: [null, [Validators.required]]
  });

  clientes: any[] = [];

  constructor(
    private clienteService: ClienteService,
    private formBuilder: FormBuilder,
    private servicoService: ServicoService,
    private dialog: MatDialog
  ) {}

  ngOnInit(): void {
    this.clienteService.list(null)
      .subscribe( (res: any) => {
        this.clientes = res.content;
      });
  }

  onSumit() {
    let servico = new Servico(this.formServico.get('servico')?.value,
                              this.formServico.get('valor')?.value,
                              this.formServico.get('cliente')?.value);
    return this.servicoService.create(servico)
      .subscribe({
        next: () => {
          this.dialog.open(DialogComponent, {
            data: {
              title: 'Sucesso',
              msg: 'Serviço criado com sucesso!'
            }
          })
        },
        error: (err) => this.dialog.open(DialogComponent, {
          data: {
            title: 'Erro',
            msg: err.error ? err.error : 'Há algum problema no servidor. Tente novamente mais tarde...'
          }
        })
      });
  }

}
