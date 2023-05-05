import { Injectable } from '@angular/core';
import { User } from '../models/user';
import { Observable, catchError, map, throwError } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';

import { JwtHelperService } from '@auth0/angular-jwt';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  private url: string = 'http://localhost:3000';

  constructor(
    private http: HttpClient,
    private router: Router
  ) { }

  sign(user: User): Observable<any> {
    return this.http.post(`${this.url}/sign`, user)
    .pipe(
      map((data) => {
        return data;
      }),
      catchError((err) => {
        if (err.status == 500) {
          return throwError(() => err.error.message);
        }
        return throwError(() => 'Há um problema com o servidor. Tente novamente mais tarde')
      })
    );
  }

  logout() {
    localStorage.removeItem('accessToken');
    return this.router.navigate(['']);
  }

  isAutenticated() {
    const token = localStorage.getItem('accessToken');

    if (token == null) {
      return false;
    }

    const jwpHelper = new JwtHelperService();
    return !jwpHelper.isTokenExpired(token);
  }
}
