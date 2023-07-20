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
void selectionSort(int *vetor, int tamanho);

int main() {

    setlocale(LC_ALL, "");

    run();

    return 0;

}

void clearScreen() {
    system("cls");
}

void imprimeVetor(int *vetor, int tamanho) {
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
    imprimeVetor(vetor, tamanho);

    selectionSort(vetor, tamanho);

    cout << "\nVetor ordenado: ";
    imprimeVetor(vetor, tamanho);

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

void selectionSort(int *vetor, int tamanho) {
    if (tamanho > 1) {
        for (int i = 0; i < tamanho; i++) {
            int posicaoDoMenorValor = i;
            for (int j = i + 1; j < tamanho; j++) {
                if (vetor[j] < vetor[posicaoDoMenorValor]) {
                    posicaoDoMenorValor = j;
                }
            }
            if (posicaoDoMenorValor != i) {
                int intermediador = vetor[i];
                vetor[i] = vetor[posicaoDoMenorValor];
                vetor[posicaoDoMenorValor] = intermediador;
                cout << "\n";
                imprimeVetor(vetor, tamanho);
            }
        }
    }
}
