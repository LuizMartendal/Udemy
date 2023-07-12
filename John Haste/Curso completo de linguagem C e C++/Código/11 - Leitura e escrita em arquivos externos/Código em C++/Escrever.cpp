#include <stdio.h>
#include <string.h>
#include <fstream>

int main() {
    //Cria o objeto de arquivo
    std::ofstream arquivoDeSaida;

    //Abre o arquivo ou cria caso não exista
    arquivoDeSaida.open("TesteEmCPP.txt", std::ios_base::app);

    //Escreve algo
    arquivoDeSaida << "Teste de escrita em arquivos usando C++";

    //Fecha o arquivo
    arquivoDeSaida.close();

    return 0;
}
