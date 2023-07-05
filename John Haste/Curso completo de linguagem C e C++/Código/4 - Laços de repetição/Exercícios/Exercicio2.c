#include <stdio.h>
#include <stdlib.h>

void main() {

    //Números pares de 10 a 20

    for (int i = 10; i <= 20; i++) {
        if (i % 2 == 0) {
            printf("%d ", i);
        }
    }
}

