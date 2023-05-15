import { Component, OnInit, Output } from '@angular/core';
import { Cliente } from '../models/Cliente';
import { ClienteService } from '../cliente.service';
import { MatDialog } from '@angular/material/dialog';
import { DialogComponent } from 'src/app/shared/material/dialog/dialog.component';

@Component({
  selector: 'app-lista-clientes',
  templateUrl: './lista-clientes.component.html',
  styleUrls: ['./lista-clientes.component.scss']
})
export class ListaClientesComponent implements OnInit {
  @Output() msgComponent: string = 'Aqui está a lista de clientes cadastrados'

  columnsToDisplay = ['NOME', 'CPF', 'SEXO'];
  columnsToDisplayWithExpand = [...this.columnsToDisplay, 'expand'];
  expandedElement: any = null;
  clientes: [] = []

  constructor(
    private clienteService: ClienteService,
    private dialog: MatDialog
  ) {}

  ngOnInit(): void {
    this.list();
  }

  list() {
    return this.clienteService.list({page: String, size: String, direction: String})
      .subscribe({
        next: (res: any) => this.clientes = res.content,
        error: (err) => this.dialog.open(DialogComponent, {
          data: {
            title: 'Erro!',
            msg: err.error
          }
        })
      })
  }
}
