#include <stdio.h>
#include <stdlib.h>
#include <iostream>
#include <string>
#include <new>
#include <locale>

using namespace std;

void clearScreen() {
    system("cls");
}

void pressAButtonToContinue() {
    system("pause");
    clearScreen();
}

struct Fila {
    int tamanho;
    int limite;
    int inicio;
    int *vetor;
};

Fila novaFila(int limite) {
    Fila fila;

    fila.tamanho = 0;
    fila.limite = limite;
    fila.inicio = 0;
    fila.vetor = new int[limite];

    return fila;
}

int getTamanho(Fila fila) {
    return fila.tamanho;
}

int getLimite(Fila fila) {
    return fila.limite;
}

bool isVazia(Fila fila) {
    if (fila.tamanho == 0) {
        return true;
    }
    return false;
}

bool isFull(Fila fila) {
    if (fila.tamanho == fila.limite) {
        return true;
    }
    return false;
}

void enfileirar(Fila *fila, int valor) {
    if (fila->tamanho == fila->limite) {
        cout << "Fila está cheia.";
        pressAButtonToContinue();
    } else {
        int posicao = (fila->inicio + fila->tamanho) % fila->limite;
        fila->vetor[posicao] = valor;
        fila->tamanho += 1;
    }
}

int desenfileirar(Fila *fila) {
    int valor;
    valor = fila->vetor[fila->inicio];

    int posicao = (fila->inicio + 1) % fila->limite;
    fila->inicio = posicao;
    fila->tamanho -= 1;

    return valor;
}

int get(Fila fila) {
    return fila.vetor[fila.inicio];
}

void imprimirFila(Fila fila) {
    for (int i = 0; i < fila.tamanho; i++) {
        int pos = (i + fila.inicio) % fila.limite;
        cout << fila.vetor[pos] << " ";
    }
    cout << "\n";
}

int main() {

    setlocale(LC_ALL, "");

    int tamanhoDaFila;

    cout << "Digite o tamanho da fila: ";
    scanf("%d", &tamanhoDaFila);

    while (tamanhoDaFila <= 0) {
        clearScreen();
        cout << "Tamanho inválido. Digite valores maiores que 0";
        cout << "Digite o tamanho da fila: ";
        scanf("%d", &tamanhoDaFila);
    }

    clearScreen();

    Fila fila = novaFila(tamanhoDaFila);

    int escolha;

    do {
        imprimirFila(fila);
        cout << "Escolha alguma função para a fila: \n";
        cout << "0 - Enfileirar um elemento;\n" << "1 - Desenfileirar;\n" << "2 - Ver primeiro elemento;\n" << "3 - Tamanho da fila\n" << "4 - Quantos elementos enfileirados;\n" << "5 - Está vazia;\n" << "6 - Limpar tela;\n" << "7 - Encerrar programa;\n" << "Opção: ";
        scanf("%d", &escolha);

        switch (escolha) {
            case 0:
                clearScreen();
                int valor;
                cout << "Qual valor você quer adicionar? ";
                scanf("%d", &valor);
                enfileirar(&fila, valor);
                clearScreen();
                break;
            case 1:
                clearScreen();
                if (isVazia(fila)) {
                    cout << "A fila está vazia.\n";
                } else {
                    cout << "Elemento desenfileirado: " << desenfileirar(&fila) << "\n";
                }
                pressAButtonToContinue();
                break;
            case 2:
                clearScreen();
                if (isVazia(fila)) {
                    cout << "A fila está vazia.\n";
                } else {
                    cout << "Último elemento enfileirado: " << get(fila) << "\n";
                }
                pressAButtonToContinue();
                break;
            case 3:
                clearScreen();
                cout << "Tamanho da fila: " << getLimite(fila) << "\n";
                pressAButtonToContinue();
                break;
            case 4:
                clearScreen();
                cout << getTamanho(fila) << " elementos enfileirados\n";
                pressAButtonToContinue();
                break;
            case 5:
                clearScreen();
                cout << "Está vazia: " << isVazia(fila) << "\n";
                pressAButtonToContinue();
                break;
            case 6:
                clearScreen();
                break;
            case 7:
                cout << "Programa encerrado!";
                break;
            default:
                cout << "Opção inválida";
        }
    } while (escolha != 7);


    return 0;

}
