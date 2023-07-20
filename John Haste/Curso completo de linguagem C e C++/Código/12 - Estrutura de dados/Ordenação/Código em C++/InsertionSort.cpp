#include <stdio.h>
#include <stdlib.h>
#include <iostream>
#include <string>
#include <new>
#include <locale>

using namespace std;

void clearScreen();

void run();
int* prencherVetor(int tamanho);
void insertionSort(int *vetor, int tamanho);

int main() {

    setlocale(LC_ALL, "");

    run();

    return 0;

}

void clearScreen() {
    system("cls");
}

void imprimirVetor(int *vetor, int tamaho) {
    for (int i = 0; i < tamanho; i++) {
        cout << vetor[i] << " ";
    }
}

void run() {
    int tamanho;

    cout << "Digite o tamanho do vetor: ";
    cin >> tamanho;

    int *vetor = prencherVetor(tamanho);

    clearScreen();

    cout << "Vetor não ordenado: ";
    imprimirVetor(vetor, tamanho);

    insertionSort(vetor, tamanho);

    cout << "\nVetor ordenado: ";
    imprimirVetor(vetor, tamanho);

    cout << "\n";
    system("pause");
}

int* prencherVetor(int tamanho) {
    int *vetor = new int[tamanho];

    int index = 0;

    while (index != tamanho) {
        cout << "Digite um valor na posição " << index << " do vetor: ";
        cin >> vetor[index];
        index++;
    }

    return vetor;
}

void insertionSort(int *vetor, int tamanho) {
    if (tamanho > 1) {
        for (int i = 1; i < tamanho; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (vetor[j] > vetor[i]) {
                    int intermediador = vetor[j];
                    vetor[j] = vetor[i];
                    vetor[i] = intermediador;
                    cout << "\n";
                    imprimirVetor(vetor, tamanho);
                }
            }
        }
    }
}
