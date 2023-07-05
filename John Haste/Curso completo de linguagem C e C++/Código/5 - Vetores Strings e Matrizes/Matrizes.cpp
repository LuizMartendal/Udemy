#include <stdio.h>
#include <stdlib.h>
#include <string>
#include <iostream>

using namespace std;

int main() {

    int matriz[2][2];

    matriz[0][0] = 0;
    matriz[0][1] = 1;
    matriz[1][0] = 2;
    matriz[1][1] = 3;

    for (int i = 0; i < 2; i++) {
            printf("Matriz %d = ", i);
        for (int j = 0; j < 2; j++) {
            cout << matriz[i][j];
        }
        cout << "\n";
    }

    return 0;

}
