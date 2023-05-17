import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Servico } from '../models/Servico';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class ServicoService {

  private URL: string = environment.URL;

  constructor(
    private http: HttpClient
  ) { }

  list(params: any) {
    return this.http.get<Servico[]>(`${this.URL}/servico`, params);
  }

  getById(id: string) {
    return this.http.get<Servico>(`${this.URL}/servico/${id}`);
  }

  create(servico: any) {
    return this.http.post(`${this.URL}/servico`, servico);
  }

  update(servico: any, id: string) {
    return this.http.put(`${this.URL}/servico/${id}`, servico);
  }

  delete(id: string) {
    return this.http.delete(`${this.URL}/servico/${id}`);
  }
}
