#include <stdio.h>
#include <stdlib.h>
#include <time.h>

void main() {

    srand((unsigned)time(NULL));

    int valor = rand();

    printf("Valor aleat�rio: %d", valor);
}
