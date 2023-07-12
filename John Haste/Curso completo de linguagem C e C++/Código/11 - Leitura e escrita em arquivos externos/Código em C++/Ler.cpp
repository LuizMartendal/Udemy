#include <stdio.h>
#include <stdlib.h>
#include <iostream>
#include <fstream>
#include <string>

using namespace std;

int main() {
    ifstream input("TesteEmCPP.txt");

    string textoLido;

    for (string line; getline(input, line);) {
        textoLido += line;
    }

    cout << textoLido;

    return 0;
}

