#include <stdio.h>
#include <stdlib.h>
#include <locale.h>

void main() {

    setlocale(LC_ALL, "");

    //Ler dois valores e depois criar um menu com 4 op��es:
    //1 - somar, 2 - subtrair, 3 - multiplicar, 4 - dividir
    //depois mostre o resultado da opera��o escolhida

    float valor1, valor2;

    printf("Digite o valor 1: ");
    scanf("%f", &valor1);

    printf("Digite o valor 2: ");
    scanf("%f", &valor2);

    printf("Escolha uma das op��es a seguir para realizar a opera��o desejada:");
    printf("\n1 - Somar");
    printf("\n2 - Subtrair");
    printf("\n3 - Multiplicar");
    printf("\n4 - Dividir");

    printf("\nOp��o: ");
    int opcao;
    scanf("%d", &opcao);

    switch (opcao) {
        case 1:
            printf("%f + %f = %f", valor1, valor2, (valor1 + valor2));
            break;
        case 2:
            printf("%f - %f = %f", valor1, valor2, (valor1 - valor2));
            break;
        case 3:
            printf("%f * %f = %f", valor1, valor2, (valor1 * valor2));
            break;
        case 4:
            printf("%f / %f = %f", valor1, valor2, (valor1 / valor2));
            break;
        default:
            printf("Op��o inv�lida");
    }
}
