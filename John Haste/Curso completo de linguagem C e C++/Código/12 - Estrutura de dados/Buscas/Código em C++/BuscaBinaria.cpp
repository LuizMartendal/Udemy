#include <stdio.h>
#include <stdlib.h>
#include <iostream>
#include <string>
#include <new>
#include <locale>

using namespace std;

int buscar(int vetor[], int valorProcurado, int inicio, int fim) {
    if (inicio <= fim) {
        int meio = (inicio + fim) / 2;
        if (vetor[meio] == valorProcurado) {
            return meio;
        } else {
            if (valorProcurado > vetor[meio]) {
                return buscar(vetor, valorProcurado, meio + 1, fim);
            } else {
                return buscar(vetor, valorProcurado, inicio, meio - 1);
            }
        }
    }
    return -1;
}

int buscaBinaria(int vetor[], int valorProcurado) {
    int inicio = 0;
    int fim = sizeof(vetor) - 1;

    return buscar(vetor, valorProcurado, inicio, fim);
}

void imprimeVetor(int vetor[]) {
    for (int i = 0; i < sizeof(vetor); i++) {
        if (i == 0) {
            cout << vetor[i];
        } else {
            cout << " " << vetor[i];
        }
    }
}

int main() {

    setlocale(LC_ALL, "");

    int vetor[10] = {10, 20, 30, 40, 50, 60, 70 ,80, 90, 100};
    int valorProcurado;
    int posicao;

    imprimeVetor(vetor);

    printf("\nQual valor você deseja procurar?\n");
    printf("Valor: ");
    scanf("%d", &valorProcurado);

    posicao = buscaBinaria(vetor, valorProcurado);

    if (posicao != -1) {
        cout << "Valor encontrado na posição: " << posicao;
    } else {
        cout << "Valor não encontrado";
    }

    return 0;

}
