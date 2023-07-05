#include <stdio.h>
#include <stdlib.h>
#include <locale.h>

void main() {

    setlocale(LC_ALL, "");

    //Preencha uma matriz 2x2 lendo valores do usuário
    //e depois troque os valores entre a primeira e segunda linha

    int matriz[2][2];

    for (int i = 0; i < 2; i++) {
        for (int j = 0; j < 2; j++) {
            printf("Digite um valor para a %d° linha da %d° coluna: ", (i + 1), (j + 1));
            scanf("%d", &matriz[i][j]);
        }
    }

    for (int i = 0; i < 2; i++) {
        for (int j = 0; j < 2; j++) {
            printf("Valor %d° linha da %d° coluna antes de inverter: %d \n", (i + 1), (j + 1), matriz[i][j]);
        }
    }

    int intermediador[2];
    intermediador[0] = matriz[0][0];
    intermediador[1] = matriz[0][1];

    matriz[0][0] = matriz[1][0];
    matriz[0][1] = matriz[1][1];

    matriz[1][0] = intermediador[0];
    matriz[1][1] = intermediador[1];

    for (int i = 0; i < 2; i++) {
        for (int j = 0; j < 2; j++) {
            printf("Valor %d° linha da %d° coluna depois de inverter: %d \n", (i + 1), (j + 1), matriz[i][j]);
        }
    }
}
