#include <stdio.h>
#include <stdlib.h>
#include <locale.h>

void main() {

    setlocale(LC_ALL, "");

    int a;
    printf("Entre com o valor: ");
    scanf("%d", &a);

    if (a % 2 == 0) {
        printf("O n�mero %d � par.", a);
    } else {
        printf("O n�mero %d � �mpar", a);
    }
}
