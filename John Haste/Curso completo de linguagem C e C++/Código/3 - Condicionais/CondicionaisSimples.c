#include <stdio.h>
#include <stdlib.h>
#include <locale.h>

void main() {

    setlocale(LC_ALL, "");

    int a;
    printf("Entre com o valor: ");
    scanf("%d", &a);

    if (a % 2 == 0) {
        printf("O número %d é par.", a);
    } else {
        printf("O número %d é ímpar", a);
    }
}
