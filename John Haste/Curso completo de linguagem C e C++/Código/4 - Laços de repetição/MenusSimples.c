#include <stdio.h>
#include <stdlib.h>
#include <locale.h>

void main() {

    setlocale(LC_ALL, "");

    int opcao;

    do {

        printf("Escolha uma das op��es:");
        printf("\nOp��o 1");
        printf("\nOp��o 2");
        printf("\nOp��o 3");

        printf("\nOp��o: ");
        scanf("%d", &opcao);

        switch (opcao) {
            case 1:
                printf("Voc� escolheu a op��o 1");
                break;
            case 2:
                printf("Voc� escolheu a op��o 2");
                break;
            case 3:
                printf("Voc� escolheu a op��o 3");
                break;
            default:
                printf("Op��o errada. Tente novamente\n");
        }

    } while (opcao < 1 || opcao > 3);
}

