import { Links } from "./clienteDTOList";

export interface ProdutoModelList {
  descricao: string,
  id: string,
  precoUnitario: number,
  _links: Links
}
