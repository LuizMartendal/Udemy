#include <stdio.h>
#include <stdlib.h>
#include <iostream>
#include <string>
#include <new>
#include <locale>
#include <vector>

using namespace std;

void clearScreen();

void run();
void adicionarElemento(vector<int> *vetor);
void mergeSort(vector<int> *arr, int left, int right);
void merge(vector<int> *arr, int left, int mid, int right);

int main() {

    setlocale(LC_ALL, "");

    run();

    return 0;

}

void clearScreen() {
    system("cls");
}

void imprimeVetor(vector<int> vetor) {
    for (int i = 0; i < vetor.size(); i++) {
        cout << vetor.at(i) << " ";
    }
}

void run() {
    vector<int> vetor;
    adicionarElemento(&vetor);

    clearScreen();

    int opcao = 0;

    do {
        cout << "0 - Encerrar";
        cout << "\n1 - Adicionar mais algum número";
        cout << "\n2 - Mostrar vetor";
        cout << "\n3 - Ordenar vetor";

        cout << "\nOpção: ";
        cin >> opcao;

        clearScreen();

        switch (opcao) {
            case 0: return;
            case 1:
                adicionarElemento(&vetor);
                break;
            case 2:
                imprimeVetor(vetor);
                cout << "\n";
                system("pause");
                break;
            case 3:
                mergeSort(&vetor, 0, vetor.size() - 1);
                break;
            default: cout << "Valor inválido!";
        }

        clearScreen();
    } while (opcao != 0);

    system("pause");
}

void adicionarElemento(vector<int> *vetor) {
    cout << "Valor: ";
    int valor;
    cin >> valor;
    vetor->push_back(valor);
}

void merge(vector<int> *arr, int left, int mid, int right) {
    int left_size = mid - left + 1;
    int right_size = right - mid;

    // Criação de vetores temporários para armazenar os subvetores da esquerda e da direita
    vector<int> left_arr(left_size);
    vector<int> right_arr(right_size);

    // Copiando os elementos para os vetores temporários
    for (int i = 0; i < left_size; i++)
        left_arr[i] = arr->at(left + i);
    for (int j = 0; j < right_size; j++)
        right_arr[j] = arr->at(mid + 1 + j);

    // Mesclando os dois vetores temporários de volta ao vetor original
    int i = 0; // Índice para percorrer o vetor da esquerda
    int j = 0; // Índice para percorrer o vetor da direita
    int k = left; // Índice para percorrer o vetor original

    while (i < left_size && j < right_size) {
        if (left_arr[i] <= right_arr[j]) {
            arr->at(k) = left_arr[i];
            i++;
        } else {
            arr->at(k) = right_arr[j];
            j++;
        }
        k++;
    }

    // Copiando os elementos restantes do vetor da esquerda, se houver algum
    while (i < left_size) {
        arr->at(k) = left_arr[i];
        i++;
        k++;
    }

    // Copiando os elementos restantes do vetor da direita, se houver algum
    while (j < right_size) {
        arr->at(k) = right_arr[j];
        j++;
        k++;
    }
}

void mergeSort(vector<int> *arr, int left, int right) {
    if (left >= right) {
        return; // Condição de parada da recursão
    }

    int mid = left + (right - left) / 2; // Encontra o meio do vetor

    // Ordena recursivamente a primeira metade do vetor
    mergeSort(arr, left, mid);

    // Ordena recursivamente a segunda metade do vetor
    mergeSort(arr, mid + 1, right);

    // Une as duas metades ordenadas
    merge(arr, left, mid, right);
}
