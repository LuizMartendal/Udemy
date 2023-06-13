import { Component, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';

import { Contato } from 'src/app/contato/models/Contato';
import { ContatoService } from 'src/app/core/entidades/contato/contato.service';
import { DialogComponent } from '../dialog/dialog.component';

@Component({
  selector: 'app-list',
  templateUrl: './list.component.html',
  styleUrls: ['./list.component.scss']
})
export class ListComponent implements OnInit {

  contatos: Contato[] = [];

  colunas: string[] = ['nome', 'email', 'numero', 'favorito'];

  constructor(
    private service: ContatoService,
    private dialog: MatDialog
  ) {}

  ngOnInit(): void {
      this.list();
  }

  list() {
    this.service.list()
      .subscribe({
      next: (res: any) => {
        this.contatos = res.content
      },
      error: (err: any) => this.openDialog('Erro!', err.error)
      }
    );
  }

  openDialog(title: string, message: string) {
    this.dialog.open(DialogComponent, {
      data: {
        title: title,
        message: message
      }
    })
  }
}
