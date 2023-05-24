import { Component, OnInit, Output } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { MatDialog } from '@angular/material/dialog';
import { ActivatedRoute } from '@angular/router';
import { UsuarioService } from 'src/app/core/entidades/usuario/usuario.service';
import { DialogComponent } from 'src/app/shared/material/dialog/dialog.component';

@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.scss']
})
export class UserComponent implements OnInit {

  @Output() component = 'Usuário';
  @Output() msgComponent = 'Aqui você pode atualizar e vizualizar os seus dados';

  sexo: string[] = ['MASCULINO', 'FEMININO', 'OUTRO'];

  formUsuario: FormGroup = this.formBuilder.group({
    nome: ['', [Validators.required]],
    senha: ['', [Validators.required]],
    dataNascimento: ['', [Validators.required]],
    sexo: ['', Validators.required]
  });

  usuario: any;

  constructor(
    private formBuilder: FormBuilder,
    private activatedRoute: ActivatedRoute,
    private usuarioService: UsuarioService,
    private dialog: MatDialog
  ) {}

  ngOnInit(): void {
    let id: any;
    this.activatedRoute
      .params
      .subscribe((res: any) => id = res.id
    );

    this.usuarioService.getById(id)
      .subscribe((res: any) => {
        console.log(res);
        this.usuario = res;
    });
  }

  onSubmit() {
    this.usuario.nome = this.formUsuario.get('nome')?.value;
    this.usuario.senha = this.formUsuario.get('senha')?.value;
    this.usuario.dataNascimento = this.formUsuario.get('dataNascimento')?.value;
    this.usuario.sexo = this.formUsuario.get('sexo')?.value;

    console.log(this.usuario);


    this.usuarioService.update(this.usuario)
      .subscribe({
        next: () => {
          this.dialog.open(DialogComponent, {
            data: {
              title: 'Sucesso!!',
              msg: 'Atualizado com sucesso!'
            }
          });
        },
        error: (err) => {
          this.dialog.open(DialogComponent, {
            data: {
              title: 'Erro!!',
              msg: err
            }
          });
          console.log(err);

        }
      });
  }

}
