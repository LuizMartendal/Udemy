#include <stdio.h>
#include <stdlib.h>
#include <locale.h>

void main() {

    setlocale(LC_ALL, "");

    char letra;

    printf("Digite algo: ");
    fflush(stdin);
    scanf("%c", &letra);

    printf("O c�digo de %c � %d", letra, letra);
}
