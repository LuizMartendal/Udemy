#include <stdio.h>
#include <stdlib.h>
#include <locale.h>

void main() {

    setlocale(LC_ALL, "");

    float nota1, nota2, nota3;

    printf("Digite a nota 1: ");
    scanf("%f", &nota1);

    printf("Digite a nota 2: ");
    scanf("%f", &nota2);

    printf("Digite a nota 3: ");
    scanf("%f", &nota3);

    float media = (nota1 + nota2 + nota3) / 3;

    if (media > 7) {
        printf("Aprovado!");
    } else {
        printf("Reprovado!");
    }
}
