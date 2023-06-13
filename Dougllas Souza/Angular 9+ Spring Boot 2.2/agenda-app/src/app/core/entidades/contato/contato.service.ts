import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Contato } from 'src/app/contato/models/Contato';
import { environment } from 'src/environments/environment.development';

@Injectable({
  providedIn: 'root'
})
export class ContatoService {

  API_URL = environment.API_URL;

  constructor(
    private http: HttpClient
  ) { }

  create(contato: Contato): Observable<Contato> {
    return this.http.post(`${this.API_URL}/api/contatos`, contato);
  }

  update(contato: Contato, id: string): Observable<Contato> {
    return this.http.put<Contato>(`${this.API_URL}/api/contatos/${id}`, contato);
  }

  list(): Observable<Contato[]> {
    return this.http.get<Contato[]>(`${this.API_URL}/api/contatos`);
  }

  getById(id: string): Observable<Contato> {
    return this.http.get<Contato>(`${this.API_URL}/api/contatos/${id}`);
  }

  delete(id: string) {
    return this.http.delete(`${this.API_URL}/api/contatos/${id}`);
  }

  setFavorite(favorite: boolean, id: string) {
    return this.http.patch(`${this.API_URL}/api/contatos/${id}/favorito`, {favorito: favorite});
  }
}
