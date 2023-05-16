import { environment } from '../../../environments/environment';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Cliente } from '../models/Cliente';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ClienteService {

  URL: string = environment.URL;

  constructor(
    private http: HttpClient
  ) { }

  salvar(cliente: Cliente): Observable<Cliente> {
    return this.http.post<Cliente>(`${this.URL}/cliente`, cliente);
  }

  update(cliente: Cliente): Observable<Cliente> {
    return this.http.put<Cliente>(`${this.URL}/cliente/${cliente.getId()}`, cliente);
  }

  list(params: any) {
    return this.http.get(`${this.URL}/cliente`);
  }

  getById(id: string) {
    return this.http.get(`${this.URL}/cliente/${id}`);
  }

  delete(id: string) {
    return this.http.delete(`${this.URL}/cliente/${id}`);
  }
}
