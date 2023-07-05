#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>
#include <locale.h>

void main() {

    setlocale(LC_ALL, "");

    bool a = false, b = true;

    if (a) {
        printf("a é verdadeiro");
    } else {
        printf("a é falso");
    }

    if (!b) {
        printf("b é falso")
    } else {
        printf("b é verdadeiro");
    }
}
