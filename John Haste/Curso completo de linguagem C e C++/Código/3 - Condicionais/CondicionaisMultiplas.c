#include <stdio.h>
#include <stdlib.h>
#include <locale.h>

void main() {

    setlocale(LC_ALL, "");

    int a = 0;
    int b = 10;

    if (a < 10 && b > 0) {
        printf("a � menor que 10 e b � maior que 0");
    }

    if (a >= 0 || b <= 10) {
        printf("a � maior ou igual a 0 ou b � menor ou igual a 10, ou os dois");
    }
}
