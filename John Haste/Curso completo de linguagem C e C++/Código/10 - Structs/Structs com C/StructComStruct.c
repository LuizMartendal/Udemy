#include <stdio.h>
#include <stdlib.h>
#include <locale.h>

typedef struct Date {
    int dia;
    int mes;
    int ano;
}Date;

struct Aluno {
    int id;
    char nome[255];
    Date dataNascimento;
}Aluno;

void main() {
    setlocale(LC_ALL, "");

    struct Aluno aluno1;
    aluno1.id = 1;
    strcpy(aluno1.nome, "Luiz");
    aluno1.dataNascimento.ano = 2002;
    aluno1.dataNascimento.mes = 10;
    aluno1.dataNascimento.dia = 28;

    printf("Id: %d\nNome: %s\nData de nascimento: %d/%d/%d", aluno1.id, aluno1.nome, aluno1.dataNascimento.dia, aluno1.dataNascimento.mes, aluno1.dataNascimento.ano);
}
