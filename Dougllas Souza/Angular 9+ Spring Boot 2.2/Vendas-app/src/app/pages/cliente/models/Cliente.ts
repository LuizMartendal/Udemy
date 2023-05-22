export class Cliente {

  private id : string = '';
  private nome: string;
  private cpf: string;
  private sexo: number;

  constructor(nome: string, cpf: string, sexo: number) {
    this.nome = nome;
    this.cpf = cpf;
    this.sexo = sexo;
  }

  getId() {
    return this.id;
  }

  setId(id: string) {
    this.id = id;
  }

  getNome() {
    return this.nome;
  }

  setNome(nome: string) {
    this.nome = nome;
  }

  getCpf() {
    return this.cpf;
  }

  setCpf(cpf: string) {
    this.cpf = cpf;
  }

  getSexo() {
    return this.sexo;
  }

  setSexo(sexo: number) {
    this.sexo = sexo;
  }
}
