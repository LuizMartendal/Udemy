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

struct Pilha {
    int topo;
    int tamanho;
    int *vetor;
};

Pilha novaPilha(int tamanho) {
    Pilha pilha;

    pilha.topo = -1;
    pilha.tamanho = tamanho;
    pilha.vetor = new int[tamanho];

    return pilha;
}

bool stackIsEmpty(Pilha pilha) {
    if (pilha.topo == -1) {
        return true;
    }
    return false;
}

bool stackIsFull(Pilha pilha) {
    if (pilha.tamanho == pilha.topo) {
        return true;
    }
    return false;
}

int stackSize(Pilha pilha) {
    return pilha.tamanho;
}

int stackSizeUsed(Pilha pilha) {
    return pilha.topo + 1;
}

void push(Pilha *pilha, int valor) {
    if ((pilha->tamanho - 1) == pilha->topo) {
        cout << "A pilha está cheia e não pode mais empilhar!\nDesempilhe um elemento para poder empilhar um novo elemento.\n";
        pressAButtonToContinue();
    } else {
        pilha->topo += 1;
        pilha->vetor[pilha->topo] = valor;
    }
}

int pop(Pilha *pilha) {
    if (stackIsEmpty(*pilha)) {
        cout << "Não há elementos para desempilhar.";
    } else {
        int valor;
        valor = pilha->vetor[pilha->topo];
        pilha->topo -= 1;
        return valor;
    }
}

int get(Pilha pilha) {
    if (stackIsEmpty(pilha)) {
        cout << "Não há elementos para desempilhar.";
    } else {
        int valor;
        valor = pilha.vetor[pilha.topo];
        return valor;
    }
    return 0;
}

int main() {

    setlocale(LC_ALL, "");

    int tamanhoDaPilha;

    cout << "Digite o tamanho da pilha: ";
    scanf("%d", &tamanhoDaPilha);

    while (tamanhoDaPilha <= 0) {
        clearScreen();
        cout << "Tamanho inválido. Digite valores maiores que 0";
        cout << "Digite o tamanho da pilha: ";
        scanf("%d", &tamanhoDaPilha);
    }

    clearScreen();

    Pilha pilha = novaPilha(tamanhoDaPilha);

    int escolha;

    do {
        cout << "Escolha alguma função para a pilha: \n";
        cout << "0 - Empilhar um elemento;\n" << "1 - Desempilhar;\n" << "2 - Ver último elemento;\n" << "3 - Tamanho da pilha\n" << "4 - Quantos elementos empilhados;\n" << "5 - Está vazia;\n" << "6 - Limpar tela;\n" << "7 - Encerrar programa;\n" << "Opção: ";
        scanf("%d", &escolha);

        switch (escolha) {
            case 0:
                clearScreen();
                int valor;
                cout << "Qual valor você quer adicionar? ";
                scanf("%d", &valor);
                push(&pilha, valor);
                clearScreen();
                break;
            case 1:
                clearScreen();
                if (stackIsEmpty(pilha)) {
                    cout << "A pilha está vazia.\n";
                } else {
                    cout << "Elemento desempilhado: " << pop(&pilha) << "\n";
                }
                pressAButtonToContinue();
                break;
            case 2:
                clearScreen();
                if (stackIsEmpty(pilha)) {
                    cout << "A pilha está vazia.\n";
                } else {
                    cout << "Último elemento empilhado: " << get(pilha) << "\n";
                }
                pressAButtonToContinue();
                break;
            case 3:
                clearScreen();
                cout << "Tamanho da pilha: " << stackSize(pilha) << "\n";
                pressAButtonToContinue();
                break;
            case 4:
                clearScreen();
                cout << stackSizeUsed(pilha) << " elementos empilhados\n";
                pressAButtonToContinue();
                break;
            case 5:
                clearScreen();
                cout << "Está vazia: " << stackIsEmpty(pilha) << "\n";
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
