import { Cliente } from "src/app/cliente/models/Cliente";

export interface Servico {

  id: string;
  servico: string;
  descricao: string;
  valor: number;
  cliente: string;
  dataCadastro: string;
}
