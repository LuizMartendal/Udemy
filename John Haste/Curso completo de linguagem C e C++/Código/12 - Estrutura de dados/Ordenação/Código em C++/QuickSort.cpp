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
void quickSort(int *vetor, int menor, int maior);
int particionar(int *vetor, int menor, int maior);
void trocar(int *vetor, int a, int b);

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

    quickSort(vetor, 0, tamanho - 1);

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

void trocar(int *vetor, int a, int b) {
    int aux = vetor[a];
    vetor[a] = vetor[b];
    vetor[b] = aux;
}

int particionar(int *vetor, int menor, int maior) {
    int pivo = vetor[maior];
    int i = menor - 1;

    for (int j = menor; j < maior; j++) {
        if (vetor[j] < pivo) {
            i++;
            trocar(vetor, i, j);
        }
    }

    trocar(vetor, i + 1, maior);

    return i + 1;
}

void quickSort(int *vetor, int menor, int maior) {
    if (menor < maior) {
        int pivo = particionar(vetor, menor, maior);
        quickSort(vetor, menor, pivo - 1);
        quickSort(vetor, pivo + 1, maior);
    }
}
