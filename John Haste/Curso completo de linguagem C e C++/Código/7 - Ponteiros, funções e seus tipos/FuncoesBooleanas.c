#include <stdio.h>
#include <stdlib.h>
#include <locale.h>
#include <stdbool.h>

bool ehPrimo(int numero) {
    for (int i = 2; i < numero; i++) {
        if (numero % i == 0) {
            return false;
        }
    }
    return true;
}

int proximoNumeroPrimo(int numero) {
    while (!ehPrimo(numero)) {
        numero++;
    }
    return numero;
}

int main() {

    setlocale(LC_ALL, "");

    printf("Entre com um n�mero e vamos te mostrar um n�mero primo a partir dele (pode ser ele mesmo): ");
    int numero;
    scanf("%d", &numero);

    numero = proximoNumeroPrimo(numero);

    printf("Pr�ximo n�mero primo: %d", numero);
}
