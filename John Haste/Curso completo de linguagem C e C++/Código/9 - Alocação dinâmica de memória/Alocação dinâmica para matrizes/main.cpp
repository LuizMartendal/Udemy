#include <stdio.h>
#include <stdlib.h>
#include <new>
#include <iostream>
#include <string>

using namespace std;

int main() {
    int linhas, colunas;

    cout << "Digite a quantidade de linhas: ";
    cin >> linhas;

    cout << "Digite a quantidade de colunas: ";
    cin >> colunas;

    int **matrizes;

    matrizes = new int*[linhas];

    for (int i = 0; i < linhas; i++) {
        matrizes[i] = new int[colunas];
    }

    for (int i = 0; i < linhas; i++) {
        for (int j = 0; j < colunas; j++) {
             matrizes[i][j] = j;
        }
    }

    for (int i = 0; i < linhas; i++) {
        for (int j = 0; j < colunas; j++) {
            cout << matrizes[i][j];
        }
        cout << "\n";
    }


    return 0;
}
