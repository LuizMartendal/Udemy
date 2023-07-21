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
void shellSort(vector<int> *vetor);

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
                shellSort(&vetor);
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

void shellSort(vector<int> *vetor) {
    int n = vetor->size();

    for (int gap = n / 2; gap > 0; gap /= 2) {
        for (int i = gap; i < n; i++) {
            int aux = vetor->at(i);
            int j;
            for (j = i; j >= gap && vetor->at(j - gap) > aux; j -= gap) {
                vetor->at(j) = vetor->at(j - gap);
            }
            vetor->at(j) = aux;
        }
    }
}
