#include <stdio.h>
#include <stdlib.h>
#include <locale.h>

void main() {

    setlocale(LC_ALL, "");

    int valor1, valor2, valor3;

    printf("Digite os 3 valores: ");
    scanf("%d %d %d", &valor1, &valor2, &valor3);

    printf("%d X %d X %d = %d", valor1, valor2, valor3, (valor1 * valor2 * valor3));

}
