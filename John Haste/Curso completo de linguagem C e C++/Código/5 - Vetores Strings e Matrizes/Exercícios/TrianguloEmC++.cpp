#include <stdio.h>
#include <stdlib.h>
#include <iostream>
#include <locale.h>

using namespace std;

int main() {
    setlocale(LC_ALL, "");

    int tamanho = 0;
    cout << "Digite o tamanho do triângulo: ";

    cin >> tamanho;

    int numero = 0;

    for (int i = 0; i < tamanho; i++) {
        cout << "\n";
        for (int j = 0; j < i + 1; j++) {
            if (numero < 10) {
                printf("   %d", numero);
            } else if (numero < 100) {
                printf("  %d", numero);
            } else {
                printf(" %d", numero);
            }
            numero++;
        }
    }

    return 0;
}
