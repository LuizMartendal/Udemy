#include <stdio.h>
#include <stdlib.h>
#include <locale.h>

void main() {

    setlocale(LC_ALL, "");

    //Criando vetor
    int vetor[11];

    //Adicionando elementos no vetor
    for (int i = 0; i <= 10; i++) {
        vetor[i] = i;
    }

    //Imprimindo os elementos em ordem decrescente
    for (int i = 10; i >= 0; i--) {
        printf("Elemento da posição %d: %d \n", i, vetor[i]);
    }
}
