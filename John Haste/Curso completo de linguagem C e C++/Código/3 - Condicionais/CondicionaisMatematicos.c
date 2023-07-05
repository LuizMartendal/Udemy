#include <stdio.h>
#include <stdlib.h>
#include <locale.h>

void main() {

    setlocale(LC_ALL, "");

    printf("Digite um número: ");
    int numero;
    scanf("%d", &numero);

    if (numero > 0) {
        printf("O número é positivo");
    } else if (numero < 0) {
        printf("O número é negativo");
    } else {
        printf("O número é 0");
    }
}
