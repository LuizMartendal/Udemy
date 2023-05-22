import { Injectable } from '@angular/core';
import { ActivatedRouteSnapshot, CanActivateChild, Router, RouterStateSnapshot, UrlTree } from '@angular/router';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AuthGuard {

  constructor(
    private router: Router
  ) {

  }

  canActivate(
    childRoute: ActivatedRouteSnapshot,
    state: RouterStateSnapshot): Observable<boolean
    | UrlTree>
    | Promise<boolean
    | UrlTree>
    | boolean
    | UrlTree {
      if (!localStorage.getItem('USUARIO')) {
        this.router.navigate(['/auth']);
        return false;
      }
    return true;
  }

}
