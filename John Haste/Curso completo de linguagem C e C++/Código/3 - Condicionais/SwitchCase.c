#include <stdio.h>
#include <stdlib.h>
#include <locale.h>

void main() {

    setlocale(LC_ALL, "");

    int opcao;

    printf("Faça a sua escolha (1, 2, 3): ");
    scanf("%d", opcao);

    switch (opcao) {
        case 1:
            printf("Bom dia");
            break;
        case 2:
            printf("Boa tarde");
            break;
        case 3:
            printf("Boa noite");
            break;
        default:
            printf("Opção não implementada");
    }
}
