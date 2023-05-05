import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { User } from 'src/app/core/models/user';
import { AuthService } from 'src/app/core/services/auth.service';

@Component({
  selector: 'app-sign',
  templateUrl: './sign.component.html',
  styleUrls: ['./sign.component.scss']
})
export class SignComponent {

  public formAuth: FormGroup = this.formBuilder.group({
    email: ['', [Validators.required, Validators.email]],
    senha: ['', [Validators.required]]
  })

  public msgErr: string = '';

  constructor(
    private formBuilder: FormBuilder,
    private service: AuthService,
    private router: Router
  ) { }

  submitForm() {
    if (this.formAuth.valid) {
      this.service.sign(new User(this.formAuth.value.email, this.formAuth.value.senha))
        .subscribe({
          next: (res) => {
            localStorage.setItem('accessToken', res.token);
            return this.router.navigate(['admin']);
          },
          error: (err) => {
            this.msgErr = err

            setTimeout(() => {
              this.msgErr = '';
            }, 5000);
          }
        });
    }
  }
}
