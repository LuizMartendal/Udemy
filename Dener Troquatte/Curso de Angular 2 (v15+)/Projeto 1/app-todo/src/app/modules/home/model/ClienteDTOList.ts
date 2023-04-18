import { RouterLinkWithHref } from "@angular/router";

export interface ClienteDTOList {
  cpf: string,
  id: string,
  nome: string,
  _links: Links
}

export interface Links {
  self: RouterLinkWithHref
}
