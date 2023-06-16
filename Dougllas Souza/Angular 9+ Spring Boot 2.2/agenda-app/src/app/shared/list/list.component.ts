import { Component, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';

import { Contato } from 'src/app/contato/models/Contato';
import { ContatoService } from 'src/app/core/entidades/contato/contato.service';
import { DialogComponent } from '../dialog/dialog.component';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-list',
  templateUrl: './list.component.html',
  styleUrls: ['./list.component.scss']
})
export class ListComponent implements OnInit {

  contatos: Contato[] = [];
  totalPaginas: number = 0;
  totalElementos: number = 0;

  colunas: string[] = ['nome', 'email', 'numero', 'favorito'];
  page = 0;
  size = 5;

  constructor(
    private service: ContatoService,
    private dialog: MatDialog,
    private router: Router,
    private route: ActivatedRoute
  ) {}

  ngOnInit(): void {
      this.list();
  }

  list() {
    this.service.list(this.page, this.size)
      .subscribe({
      next: (res: any) => {
        this.contatos = res.conteudo;
        this.totalElementos = res.totalElementos;
        this.totalPaginas = res.totalPaginas;
      },
      error: (err: any) => {
        if (err.status !== 0) {
          this.openDialog('Erro!', err.error)
        } else {
          this.openDialog('Erro!', "Servidor não disponível")
        }
      }
      }
    );
  }

  update(id: string) {
    this.router.navigate([`contato/edit/${id}`]);
  }

  delete(id: string) {
    this.service.delete(id)
      .subscribe({
        next: () => {
          this.openDialog('Sucesso!', 'Contato deletado com sucesso.');
          this.list();
        },
        error: (err: any) => this.openDialog('Erro!', 'Erro ao deletar o contato.')
      })
  }

  setFavorite(id: string, favorite: boolean) {
    this.service.setFavorite(!favorite, id)
      .subscribe({
        next: (res: any) => {
          this.list()
        },
        error: (err: any) => this.openDialog("Erro", err.error)
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

  onPage(event: any) {
    this.page = event.pageIndex;
    this.size = event.pageSize;
    this.list();
  }
}
