#include <stdio.h>
#include <stdlib.h>
#include <locale.h>

void main() {

    setlocale(LC_ALL, "");

    //Crie um algoritmo que leia 3 valores e informe se eles s�o iguais entre si para formar um tri�ngulo equil�tero

    int valor1, valor2, valor3;

    printf("Digite o valor 1: ");
    scanf("%d", valor1);

    printf("Digite o valor 2: ");
    scanf("%d", valor2);

    printf("Digite o valor 3: ");
    scanf("%d", valor3);

    if (valor1 == valor2 && valor2 == valor3) {
        printf("Todos os valores s�o iguais");
    }
}
