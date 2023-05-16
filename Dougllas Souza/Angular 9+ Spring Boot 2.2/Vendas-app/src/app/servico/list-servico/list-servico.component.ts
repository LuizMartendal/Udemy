import { animate, state, style, transition, trigger } from '@angular/animations';
import { Component, OnInit, Output } from '@angular/core';
import { ServicoService } from '../service/servico.service';

@Component({
  selector: 'app-list-servico',
  templateUrl: './list-servico.component.html',
  styleUrls: ['./list-servico.component.scss'],
  animations: [
    trigger('detailExpand', [
      state('collapsed', style({height: '0px', minHeight: '0'})),
      state('expanded', style({height: '*'})),
      transition('expanded <=> collapsed', animate('225ms cubic-bezier(0.4, 0.0, 0.2, 1)')),
    ]),
  ],
})
export class ListServicoComponent implements OnInit {

  @Output() msgComponent: string = 'Aqui estão os serviços cadastrados';
  @Output() component: string = 'Serviço';

  columnsToDisplay = ['Cliente', 'Valor (R$)', 'Data de cadastro'];
  columns = ['cliente', 'valor', 'dataCadastro', 'servico']
  columnsToDisplayWithExpand = [...this.columns, 'servico'];
  expandedElement: ServicoInterface | undefined;

  servicos = [];

  isLoading: boolean = false;

  constructor(
    private servicoService: ServicoService
  ) {}

  ngOnInit(): void {
    this.list();
  }

  list() {
    /*return this.servicoService.list(null)
      .subscribe({
        next: (res: any) => this.servicos = res.content
      })*/
  }
}

export interface ServicoInterface {
  servico: string;
  valor: number;
  cliente: any;
  dataCadastro: any
}
