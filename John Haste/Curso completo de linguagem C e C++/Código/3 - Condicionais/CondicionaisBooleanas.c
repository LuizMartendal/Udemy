#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>
#include <locale.h>

void main() {

    setlocale(LC_ALL, "");

    bool a = false, b = true;

    if (a) {
        printf("a � verdadeiro");
    } else {
        printf("a � falso");
    }

    if (!b) {
        printf("b � falso")
    } else {
        printf("b � verdadeiro");
    }
}
