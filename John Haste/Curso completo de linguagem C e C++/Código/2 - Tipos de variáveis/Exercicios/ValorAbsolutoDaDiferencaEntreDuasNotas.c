#include <stdio.h>
#include <stdlib.h>
#include <locale.h>

void main() {

    setlocale(LC_ALL, "");

    //Crie um algoritmo que leia 2 notas e mostre o valor absoluto da diferença entre elas

    float nota1, nota2;

    printf("Digite a nota 1: ");
    scanf("%f", &nota1);

    printf("Digite a nota 2: ");
    scanf("%f", &nota2);

    printf("Valor absoluto da diferença entre a nota 1 (%f) e nota 2 (%f): %d", nota1, nota2, abs(nota1 - nota2));
}
