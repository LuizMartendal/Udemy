#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>
#include <iostream>
#include <string>

using namespace std;

int main() {

    //Definindo variáveis
    int a;
    float b;
    char c;
    bool d;

    //Passando valores
    a = 10;
    b = 2.8;
    c = 'x';
    d = false;

    //Imprimindo os valores
    printf("int = %d", a);
    printf("\nfloat = %.2f", b); //%.(número de casas decimais)f
    printf("\nchar = %c", c);
    printf("\nbool = %d", d); //0 = false e 1 = true

    //Imprimindo usando o std
    cout << "Hello World";

    //Lendo valores
    scanf("%d", &a);

    //Lendo com o std
    cin >> a;

    getchar(); //Limpa o buffer para ler um próximo char
    //ou
    fflush(stdin);

    return 0;
}
