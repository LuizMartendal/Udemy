#include <stdio.h>
#include <stdlib.h>
#include <locale.h>

void main() {

    setlocale(LC_ALL, "");

    //Vari�vel
    char palavra[10];

    //Instru��o
    printf("Digite uma palavra: ");


    //Limpa o Buffer
    setbuf(stdin, 0);

    //L� a String
    fgets(palavra, 255, stdin);

    //Limpa as casas n�o utilizadas
    palavra[strlen(palavra) - 1] = '\0';

    //Imprime na tela
    printf("Palavra digitada: %s", palavra);
}
