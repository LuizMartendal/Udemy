#include <stdio.h>
#include <stdlib.h>
#include <locale.h>

void main() {

    setlocale(LC_ALL, "");

    int opcao;

    do {

        printf("Escolha uma das opções:");
        printf("\nOpção 1");
        printf("\nOpção 2");
        printf("\nOpção 3");

        printf("\nOpção: ");
        scanf("%d", &opcao);

        switch (opcao) {
            case 1:
                printf("Você escolheu a opção 1");
                break;
            case 2:
                printf("Você escolheu a opção 2");
                break;
            case 3:
                printf("Você escolheu a opção 3");
                break;
            default:
                printf("Opção errada. Tente novamente\n");
        }

    } while (opcao < 1 || opcao > 3);
}

