import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';
import { environment } from 'src/environments/environment';
import { ObservablePageObject } from './modules/home/model/ObservablePageObject';
import { ProdutoModelList } from './modules/home/model/ProdutoModelList';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {

  public produtos: ProdutoModelList[] | undefined;

  constructor(private http: HttpClient) { }

  mostrar() {
    this.http.get<ObservablePageObject<{produtoModelList: ProdutoModelList[]}>>(environment.urlBackend + '/api/produto').subscribe({
      next: (res) => this.produtos = res._embedded.produtoModelList,
      error: (err) => console.log(err)
    });
    this.produtos?.forEach(produto => {
      console.log(this.http.get(produto._links.self.href + ''));
    })
  }
}
