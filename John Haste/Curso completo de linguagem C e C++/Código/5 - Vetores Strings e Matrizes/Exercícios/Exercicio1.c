#include <stdio.h>
#include <stdlib.h>
#include <locale.h>

void main() {

    setlocale(LC_ALL, "");

    //Crie um algoritmo que leia 3 valores para um vetor de 3 posições
    //e depois calcule a média dos valores acessando o vetor.

    int vetor[3];

    for (int i = 0; i < 3; i++) {
        printf("Digite um número para a posição %d do vetor: ", i);
        scanf("%d", &vetor[i]);
    }

    int soma = 0;

    for (int i = 0; i < 3; i++) {
        soma += vetor[i];
    }

    printf("Média dos valores do vetor é: %d", (soma / 3));
}
