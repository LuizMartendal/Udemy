#include <stdio.h>
#include <stdlib.h>
#include <locale>
#include <new>

int main() {
    setlocale(LC_ALL, "");

    int tamanho;

    printf("Digite o tamanho do vetor: ");
    scanf("%d", &tamanho);

    //Criando um ponteiro que recebe um novo vetor vazio
    int *vetor = new int[tamanho];

    for (int i = 0; i < tamanho; i++) {
        vetor[i] = i * 10;
    }

    for (int i = 0; i < tamanho; i++) {
        printf("Valor do vetor na posição %d: %d \n", i, vetor[i]);
    }

    return 0;
}
