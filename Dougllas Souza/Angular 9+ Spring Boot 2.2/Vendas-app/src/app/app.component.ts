import { Component, OnChanges, OnInit, SimpleChanges } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent implements OnInit {

  usuario: any;

  constructor(
    private router: Router
  ) {}

  ngOnInit(): void {
    if (localStorage.getItem('USUARIO')) {
      this.usuario = '1';
    } else {
      this.usuario = null;
    }
  }

  logout() {
    localStorage.removeItem('USUARIO');
  }
}
