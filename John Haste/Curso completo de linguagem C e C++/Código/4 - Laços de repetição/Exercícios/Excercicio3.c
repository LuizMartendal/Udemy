#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>
#include <locale.h>

void main() {

    setlocale(LC_ALL, "");

    //Verifica se um n�mero � primo

    printf("Entre com um n�mero: ");
    int numero;
    scanf("%d", &numero);

    bool ehPrimo = false;

    if (numero > 1) {
            ehPrimo = true;
        for (int i = 2; i < numero; i++) {
            if (numero % i == 0) {
                ehPrimo = false;
            }
        }
    }

    if (ehPrimo) {
        printf("� primo");
    } else {
        printf("N�o � primo");
    }
}

