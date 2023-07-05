#include <stdio.h>
#include <stdlib.h>
#include <locale.h>

int calcular(int valor1, int valor2, char operador) {
    switch (operador) {
        case '+':
            return valor1 + valor2;
        case '-':
            return valor1 - valor2;
        case '*':
            return valor1 * valor2;
        case '/':
            return valor1 / valor2;
        default:
            return -1;
    }
}

int main() {
    setlocale(LC_ALL, "");

    int valor1, valor2;
    char operador;

    printf("Digite o valor 1: ");
    scanf("%d", &valor1);

    printf("Digite o valor 2: ");
    scanf("%d", &valor2);

    printf("Digite o operador: ");
    getchar();
    scanf("%c", &operador);

    printf("Resultado de %d %c %d = %d", valor1, operador, valor2, calcular(valor1, valor2, operador));
}


