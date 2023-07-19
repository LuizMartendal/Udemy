#include <stdio.h>
#include <stdlib.h>
#include <iostream>
#include <string>
#include <new>
#include <locale>

#define TAM 10

using namespace std;

void clearScreen();

void run();
int* prencherVetor(int tamanho);
void bubbleSort(int *vetor);

int main() {

    setlocale(LC_ALL, "");

    run();

    return 0;

}

void clearScreen() {
    system("cls");
}

void run() {
    int *vetor = prencherVetor(TAM);

    clearScreen();

    cout << "Vetor não ordenado: ";

    for (int i = 0; i < sizeof(vetor) / sizeof(int); i++) {
        cout << vetor[i] << " ";
    }

    bubbleSort(vetor);

    cout << "\nVetor ordenado: ";
    for (int i = 0; i < sizeof(vetor) / sizeof(int); i++) {
        cout << vetor[i] << " ";
    }

    system("pause");
}

int* prencherVetor(int tamanho) {
    int *vetor = new int[tamanho];

    cout << sizeof(vetor) / sizeof(int);

    int index = 0;

    while (index != TAM) {
        cout << "Digite um valor na posição " << index << " do vetor: ";
        cin >> vetor[index];
        index++;
    }

    return vetor;
}

void bubbleSort(int *vetor) {

}

