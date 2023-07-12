#include <stdio.h>
#include <stdlib.h>
#include <locale>
#include <iostream>
#include <string>
#include <new>

using namespace std;

struct Fruta {
    string nome;
    string cor;
};

int main() {
    setlocale(LC_ALL, "");

    Fruta *fruta1 = new Fruta;

    fruta1->nome = "Banana";
    fruta1->cor = "Amarelo";

    cout << "Nome da fruta: " << fruta1->nome << ", Cor da fruta: " << fruta1->cor;

    Fruta *frutas = new Fruta[3];

    frutas[0].nome = "Abacaxi";
    frutas[0].cor = "Amarelo?";

    frutas[1].nome = "Maça";
    frutas[1].cor = "Vermelho";

    frutas[2].nome = "Melancia";
    frutas[2].cor = "Verde";

    printf("\n");

    for (int i = 0; i < 3; i++) {
        cout << "Nome da fruta: " << frutas[i].nome << ", Cor da fruta: " << frutas[i].cor;
        printf("\n");
    }
    return 0;
}

