import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Contato } from '../models/Contato';
import { ContatoService } from 'src/app/core/entidades/contato/contato.service';
import { ActivatedRoute, Router } from '@angular/router';
import { MatDialog, MatDialogModule } from '@angular/material/dialog';
import { DialogComponent } from 'src/app/shared/dialog/dialog.component';
import { MatButtonModule } from '@angular/material/button';

@Component({
  selector: 'app-new-contato',
  templateUrl: './new-contato.component.html',
  styleUrls: ['./new-contato.component.scss'],
})
export class NewContatoComponent implements OnInit {

  contato: Contato = {};

  formContato: FormGroup = this.formBuilder.group({
    nome: [null, Validators.required],
    email: [null, [Validators.compose([Validators.email, Validators.required])]],
    numero: [null, [Validators.compose([Validators.minLength(10), Validators.maxLength(13), Validators.required])]]
  });

  constructor(
    private formBuilder: FormBuilder,
    private service: ContatoService,
    private router: Router,
    private dialog: MatDialog,
    private route: ActivatedRoute
  ) {}

  ngOnInit(): void {
    let id: any;
    this.route.params.subscribe((res: any) => id = res.id);

    if (id) {
      this.service.getById(id)
        .subscribe({
          next: (res: any) => {
            this.contato = res;
            this.patchForm();
          },
          error: (err: any) => this.openDialog('Erro!', err.error)
        }
      );
    }
  }

  patchForm() {
    if (this.contato) {
      this.formContato.patchValue({
        nome: this.contato.nome,
        email: this.contato.email,
        numero: this.contato.numero
      });
    }
  }

  submit() {
    if (this.formContato.valid) {
      const formValues = this.formContato.value;
      this.contato.nome = formValues.nome;
      this.contato.email = formValues.email;
      this.contato.numero = formValues.numero;

      if (this.contato.id != null) {
        this.update(this.contato, this.contato.id);
      } else {
        this.create(this.contato);
      }
    }
  }

  create(contato: Contato) {
    this.service.create(contato)
      .subscribe({
        next: (res: any) => {
          this.openDialog("Sucesso!", "Contato " + this.contato.nome + " criado com sucesso!");
          this.router.navigate(['/']);
        },
        error: (err: any) => this.openDialog("Erro!", err.error)
      }
    );
  }

  update(contato: Contato, id: any) {
    this.service.update(contato, id)
      .subscribe({
        next: (res: any) => {
          this.openDialog("Sucesso!", "Contato " + this.contato.nome + " atualizado com sucesso!");
        },
        error: (err: any) => this.openDialog("Erro!", err.error)
      }
    );
  }

  openDialog(title: string, message: string) {
   this.dialog.open(DialogComponent, {
    data: {
      title: title,
      message: message
    },
    height: '250px',
    width: '250px'
   })
  }
}
