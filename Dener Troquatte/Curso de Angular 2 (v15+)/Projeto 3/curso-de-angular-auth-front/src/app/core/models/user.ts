export class User {

  constructor(
    private email: string,
    private senha: string
  ) {}

  public getEmail() {
    return this.email;
  }

  public setEmail(email: string) {
    this.email = email
  }

  public getSenha() {
    return this.senha;
  }

  public setSenha(senha: string) {
    this.senha = senha;
  }
}
