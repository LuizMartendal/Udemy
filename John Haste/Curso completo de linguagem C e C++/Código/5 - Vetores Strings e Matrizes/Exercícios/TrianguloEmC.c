#include <stdio.h>
#include <stdlib.h>
#include <locale.h>

void main() {

    setlocale(LC_ALL, "");

    int tamanho;

    printf("Digite do tamanho do triangulo: ");
    scanf("%d", &tamanho);

    int numero = 0;

    for (int i = 0; i < tamanho; i++) {
        printf("\n");
        for (int j = 0; j < i + 1; j++) {
            if (numero < 10) {
                printf("   %d", numero);
            } else if (numero < 100) {
                printf("  %d", numero);
            } else {
                printf(" %d", numero);
            }
            numero += 1;
        }
    }

}
