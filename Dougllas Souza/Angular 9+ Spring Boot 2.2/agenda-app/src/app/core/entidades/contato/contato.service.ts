import { HttpClient, HttpParams, HttpParamsOptions } from '@angular/common/http';
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

  list(page: number, size: number): Observable<Contato[]> {
    let params: HttpParams = new HttpParams();
    params = params.append('page', page);
    params = params.append('size', size);

    return this.http.get<Contato[]>(`${this.API_URL}/api/contatos`, {params: params});
  }

  getById(id: string): Observable<Contato> {
    return this.http.get<Contato>(`${this.API_URL}/api/contatos/${id}`);
  }

  delete(id: string) {
    return this.http.delete(`${this.API_URL}/api/contatos/${id}`);
  }

  setFavorite(favorite: boolean, id: string) {
    let pathParams: HttpParams = new HttpParams();
    pathParams = pathParams.append('favorito', favorite);
    return this.http.patch(`${this.API_URL}/api/contatos/${id}/favorito`, pathParams);
  }
}

