#include <stdio.h>
#include <stdlib.h>
#include <string>
#include <iostream>

using namespace std;

int main() {

    string palavra;

    cout << "Digite uma palavra: ";
    getline(cin, palavra);

    cout << palavra;

    return 0;

}
