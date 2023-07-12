#include <stdio.h>
#include <stdlib.h>
#include <iostream>
#include <string>
#include <new>
#include <locale>

using namespace std;

int buscaSimples(int vetor[], int valorProcurado) {
    int posicao = -1;
    for (int i = 0; i < sizeof(vetor); i++) {
        if (vetor[i] == valorProcurado) {
            posicao = i;
        }
    }
    return posicao;
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

    int vetor[10] = {50, 49, 31, 11, 6, 98, 97 ,55, 73, 22};
    int valorProcurado;
    int posicao;

    imprimeVetor(vetor);

    printf("\nQual valor você deseja procurar?\n");
    printf("Valor: ");
    scanf("%d", &valorProcurado);

    posicao = buscaSimples(vetor, valorProcurado);

    if (posicao != -1) {
        cout << "Valor encontrado na posição: " << posicao;
    } else {
        cout << "Valor não encontrado";
    }

    return 0;

}
