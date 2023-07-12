#include <stdio.h>
#include <stdlib.h>
#include <string.h>

void main() {
    FILE *file;

    file = fopen("Test.txt", "w+");

    if (file) {
        fprintf(file, "");
    } else {
        printf("Arquivo nao encontrado!");
    }

    fclose(file);
}
