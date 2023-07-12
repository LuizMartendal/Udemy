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

    //Vetor vai receber um endere�o de mem�ria com o vetor que foi alocado
    //ponteiro = EDERE�O_DE_MEMORIA ou PONTEIRO
    //*ponteiro = VALOR
    vetor = alocaVetor(tamanho);

    for (int i = 0; i < tamanho; i++) {
        vetor[i] = i * 10;
    }

    for (int i = 0; i < tamanho; i++) {
        printf("Valor do vetor na posi��o %d: %d \n", i, vetor[i]);
    }

    //Libera a mem�ria ap�s usar o vetor
    free(vetor);

    for (int i = 0; i < tamanho; i++) {
        printf("Valor do vetor na posi��o %d depois de liberar a mem�ria: %d \n", i, vetor[i]);
    }
}
