#include <stdio.h>
#include <stdlib.h>
#include <locale.h>

void main() {

    setlocale(LC_ALL, "");

    int a = 0;
    int b = 10;

    if (a < 10 && b > 0) {
        printf("a é menor que 10 e b é maior que 0");
    }

    if (a >= 0 || b <= 10) {
        printf("a é maior ou igual a 0 ou b é menor ou igual a 10, ou os dois");
    }
}
