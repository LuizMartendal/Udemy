#include <stdio.h>
#include <stdlib.h>

void main() {
    int linhas, colunas;
    int **matriz;

    printf("Digite a quantidade de linhas: ");
    scanf("%d", &linhas);

    printf("Digite a quantidade de colunas: ");
    scanf("%d", &colunas);

    //Alocando as colunas da matriz
    matriz = (int**) malloc(linhas * sizeof(int*));

    //Alocando as linhas da matriz
    for (int i = 0; i < linhas; i++) {
        matriz[i] = (int*) malloc(colunas * sizeof(int));
    }

    for (int i = 0; i < linhas; i++) {
        for (int j = 0; j < colunas; j++) {
            matriz[i][j] = i + j;
        }
    }

    for (int i = 0; i < linhas; i++) {
        for (int j = 0; j < colunas; j++) {
            printf("Valor da matriz na linhas %d e coluna %d: %d \n", i, j, matriz[i][j]);
        }
    }
}
