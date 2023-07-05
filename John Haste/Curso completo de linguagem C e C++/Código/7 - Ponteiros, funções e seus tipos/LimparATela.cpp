#include <stdio.h>
#include <stdlib.h>
#include <locale>

void limparTela() {
    system("CLS");
}

int main() {
    setlocale(LC_ALL, "");

    printf("Aperte enter para limpar a tela.");
    scanf("%d");
    limparTela();
    return 0;
}
