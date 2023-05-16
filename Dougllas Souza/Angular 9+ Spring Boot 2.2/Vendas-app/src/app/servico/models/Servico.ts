import { Cliente } from "src/app/cliente/models/Cliente";

export class Servico {

  servico: string;
  valor: number;
  cliente: string;

  constructor(servico: string, valor: number, cliente: string) {
    this.servico = servico;
    this.valor = valor;
    this.cliente = cliente;
  }
}
