#include <stdio.h>
#include <stdlib.h>
#include <iostream>
#include <fstream>
#include <string>

using namespace std;

int main() {
    ofstream file("TesteEmCPP.txt");

    file << "";

    file.close();

    return 0;
}
