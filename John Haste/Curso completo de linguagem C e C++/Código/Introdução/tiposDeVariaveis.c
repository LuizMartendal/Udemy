#include <stdio.h>
#include <stdlib.h>
#include <locale.h>

void main() {
    //Permite usar acentos
    setlocale(LC_ALL, "");

    //Imprime Ol�
    printf("Ol� \n");

    //Lendo e imprimindo valores inteiros
    int a = 5;
    printf("O valor de a padr�o: %d", a);
    printf("\nEscolha um novo valor para a: ");
    scanf("%d", &a);
    printf("Valor de a atual: %d", a);

    //Lendo e imprimindo valores float
    float b = 5;
    printf("\nN�mero de b por padr�o: %f", b);
    printf("\nEscolha um novo valor para b: ");
    scanf("%f", &b);
    printf("Valor de b atual: %f", b);

    //Lendo e imprimindo letra
    char letra = 'L';
    printf("\nA letra por padr�o ser�: %c", letra);
    printf("\nEntre com uma nova letra: ");
    fflush(stdin);
    scanf("%c", &letra);
    printf("Letra atual: %c", letra);
}
