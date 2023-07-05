#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>
#include <locale.h>

void main() {

    setlocale(LC_ALL, "");

    //Verifica se um número é primo

    printf("Entre com um número: ");
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
        printf("É primo");
    } else {
        printf("Não é primo");
    }
}

