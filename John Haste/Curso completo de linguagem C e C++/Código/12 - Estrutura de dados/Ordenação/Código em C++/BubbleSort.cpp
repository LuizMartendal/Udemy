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
void bubbleSort(int *vetor, int tamanho);

int main() {

    setlocale(LC_ALL, "");

    run();

    return 0;

}

void clearScreen() {
    system("cls");
}

void imprimirVetor(int *vetor, int tamanho) {
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

    cout << "Vetor n�o ordenado: ";
    imprimeVetor(vetor, tamanho);

    bubbleSort(vetor, tamanho);

    cout << "\nVetor ordenado: ";
    imprimirVetor(vetor, tamanho);

    cout << "\n";
    system("pause");
}

int* prencherVetor(int tamanho) {
    int *vetor = new int[tamanho];

    int index = 0;

    while (index != tamanho) {
        cout << "Digite um valor na posi��o " << index << " do vetor: ";
        cin >> vetor[index];
        index++;
    }

    return vetor;
}

void bubbleSort(int *vetor, int tamanho) {
    for (int i = 0; i < tamanho; i++) {
        for (int j = 0; j < tamanho - 1; j++) {
            if (vetor[j] > vetor[i]) {
                int intermediador = vetor[j];
                vetor[j] = vetor[i];
                vetor[i] = intermediador;
                imprimirVetor(vetor, tamanho);
            }
        }
    }
}

