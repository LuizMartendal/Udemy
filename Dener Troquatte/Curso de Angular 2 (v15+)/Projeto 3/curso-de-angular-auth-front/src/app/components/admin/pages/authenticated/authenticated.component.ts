import { Component, OnChanges, OnInit, SimpleChanges } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { AuthService } from 'src/app/core/services/auth.service';

@Component({
  selector: 'app-authenticated',
  templateUrl: './authenticated.component.html',
  styleUrls: ['./authenticated.component.scss']
})
export class AuthenticatedComponent implements OnInit {

  public contagem: number = 5;

  constructor(
    private authService: AuthService,
    private router: Router,
    private route: ActivatedRoute
  ) {}

  ngOnInit(): void {
    setInterval(() => {
      this.contagem--
      if (this.contagem === 0) {
        this.router.navigate(['home'], { relativeTo: this.route });
      }
    }, 1000);
  }

  logout() {
    this.authService.logout();
  }
}
