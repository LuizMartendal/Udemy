import { Component, OnInit, Output } from '@angular/core';

import { ClienteService } from '../service/cliente.service';
import { MatDialog } from '@angular/material/dialog';
import { DialogComponent } from 'src/app/shared/material/dialog/dialog.component';
import { animate, state, style, transition, trigger } from '@angular/animations';

@Component({
  selector: 'app-lista-clientes',
  templateUrl: './lista-clientes.component.html',
  styleUrls: ['./lista-clientes.component.scss'],
  animations: [
    trigger('detailExpand', [
      state('collapsed', style({height: '0px', minHeight: '0'})),
      state('expanded', style({height: '*'})),
      transition('expanded <=> collapsed', animate('225ms cubic-bezier(0.4, 0.0, 0.2, 1)')),
    ]),
  ],
})
export class ListaClientesComponent implements OnInit {

  @Output() msgComponent: string = 'Aqui está a lista de clientes cadastrados';
  @Output() component: string = 'Cliente';

  displayedColumns: string[] = ['nome', 'cpf', 'sexo', 'dataCadastro', 'editar'];
  clientes = [];

  isLoading: boolean = false;

  constructor(
    private clienteService: ClienteService,
    private dialog: MatDialog
  ) { }

  ngOnInit(): void {
    this.list();
  }

  list() {
    this.isLoading = true;
    return this.clienteService.list({page: String, size: String, direction: String})
      .subscribe({
        next: (res: any) => {
          this.clientes = res.content;
          this.isLoading = false;
        },
        error: (err) => this.dialog.open(DialogComponent, {
          data: {
            title: 'Erro!',
            msg: err.error
          }
        })
      });
  }

  del(id: string) {
    this.clienteService.delete(id)
      .subscribe();
    this.list();
    location.reload();
  }
}
