#include <stdio.h>
#include <stdlib.h>
#include <locale.h>

void main() {

    //Para usar acentos
    setlocale(LC_ALL, "");

    //Crie um algoritmo que leia 2 notas e mostre a média entre elas.

    float nota1 = 0.0, nota2 = 0.0;

    printf("Entre com a nota 1: ");
    scanf("%f", &nota1);

    printf("Entre com a nota 2: ");
    scanf("%f", &nota2);

    printf("Média das notas: %f", (nota1 + nota2) / 2);
}
