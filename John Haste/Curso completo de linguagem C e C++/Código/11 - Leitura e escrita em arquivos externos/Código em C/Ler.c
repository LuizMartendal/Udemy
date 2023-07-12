#include <stdio.h>
#include <stdlib.h>
#include <string.h>

void main() {
    char palavraContida[255];

    FILE *file;

    file = fopen("Test.txt", "r");

    if (file) {
        int c;
        int index;

        printf("O que está escrito no arquivo: \n");

        while ((c = getc(file)) != EOF) {
            printf("%c", c);
            palavraContida[index] = c;
            index++;
        }
    } else {
        printf("Arquivo nao encontrado!");
    }

    fclose(file);

    printf("\nO que está na variável: \n");
    for (int i = 0; i < strlen(palavraContida) - 2; i++) {
        printf("%c", palavraContida[i]);
    }
}
