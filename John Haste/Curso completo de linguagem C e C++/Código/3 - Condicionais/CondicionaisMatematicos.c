#include <stdio.h>
#include <stdlib.h>
#include <locale.h>

void main() {

    setlocale(LC_ALL, "");

    printf("Digite um n�mero: ");
    int numero;
    scanf("%d", &numero);

    if (numero > 0) {
        printf("O n�mero � positivo");
    } else if (numero < 0) {
        printf("O n�mero � negativo");
    } else {
        printf("O n�mero � 0");
    }
}
