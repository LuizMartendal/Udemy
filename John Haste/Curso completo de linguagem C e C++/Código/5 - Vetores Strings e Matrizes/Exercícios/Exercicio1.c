#include <stdio.h>
#include <stdlib.h>
#include <locale.h>

void main() {

    setlocale(LC_ALL, "");

    //Crie um algoritmo que leia 3 valores para um vetor de 3 posi��es
    //e depois calcule a m�dia dos valores acessando o vetor.

    int vetor[3];

    for (int i = 0; i < 3; i++) {
        printf("Digite um n�mero para a posi��o %d do vetor: ", i);
        scanf("%d", &vetor[i]);
    }

    int soma = 0;

    for (int i = 0; i < 3; i++) {
        soma += vetor[i];
    }

    printf("M�dia dos valores do vetor �: %d", (soma / 3));
}
