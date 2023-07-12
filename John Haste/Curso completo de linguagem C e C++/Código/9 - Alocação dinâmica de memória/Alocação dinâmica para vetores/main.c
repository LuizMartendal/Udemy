#include <stdio.h>
#include <stdlib.h>
#include <locale.h>

int* alocaVetor(int tamanho) {
    int *ponteiro;

    ponteiro = (int*) malloc(tamanho * sizeof(int));

    return ponteiro;
}

void main() {
    setlocale(LC_ALL, "");

    int *vetor, tamanho;

    printf("Digite um tamanho: ");
    scanf("%d", &tamanho);

    //Vetor vai receber um endereço de memória com o vetor que foi alocado
    //ponteiro = EDEREÇO_DE_MEMORIA ou PONTEIRO
    //*ponteiro = VALOR
    vetor = alocaVetor(tamanho);

    for (int i = 0; i < tamanho; i++) {
        vetor[i] = i * 10;
    }

    for (int i = 0; i < tamanho; i++) {
        printf("Valor do vetor na posição %d: %d \n", i, vetor[i]);
    }

    //Libera a memória após usar o vetor
    free(vetor);

    for (int i = 0; i < tamanho; i++) {
        printf("Valor do vetor na posição %d depois de liberar a memória: %d \n", i, vetor[i]);
    }
}
