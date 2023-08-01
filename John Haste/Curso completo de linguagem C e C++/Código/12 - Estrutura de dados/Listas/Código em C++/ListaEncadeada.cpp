#include <stdio.h>
#include <stdlib.h>
#include <locale.h>
#include <string>
#include <new>
#include <iostream>

using namespace std;

struct Person {
    string name;
    int age;
    int cpf;
};

struct Node {
    struct Person *person;
    struct Node *nextNode;
};

struct LinkedList {
    struct Node *first;
    struct Node *last;
    int quantity;
};

void clearScreen() {
    system("CLS");
}

Person* createAPerson() {
    Person *person = new Person;

    cout << "Insert the name: ";
    cin >> person->name;

    cout << "Insert the age: ";
    cin >> person->age;

    cout << "Insert the CPF: ";
    cin >> person->cpf;

    return person;
}

Node* createANode() {
    Node *node = new Node;
    node->person = createAPerson();
    node->nextNode = NULL;
    return node;
}

void insertBeginning(LinkedList *&linkedList) {
    Node *node = createANode();
    if (linkedList->quantity == 0) {
        linkedList->first = node;
        linkedList->last = node;
    } else {
        Node *n = linkedList->first;
        linkedList->first = node;
        linkedList->first->nextNode = n;
    }
    linkedList->quantity = linkedList->quantity + 1;
}

void insertEnd(LinkedList *&linkedList) {
    Node *node = createANode();
    if (linkedList->quantity == 0) {
        insertBeginning(linkedList);
    } else {
        linkedList->last->nextNode = node;
        linkedList->last = node;
    }
    linkedList->quantity = linkedList->quantity + 1;
}

void insertAnywhere(LinkedList *linkedList, int position) {
    int index;

    Node *nodeToInsert = createANode();

    Node *node = linkedList->first;
    while (node != NULL) {
        if (index + 1 == position) {
            if (node->nextNode != NULL) {
                nodeToInsert->nextNode = node->nextNode;
            }
            node->nextNode = nodeToInsert;
            return;
        }
        node = node->nextNode;
        index++;
    }
    cout << "Posição não encontrada";
}

void removeBeginning(LinkedList *linkedList) {
    if (linkedList->quantity == 1) {
        linkedList = new LinkedList;
    } else {
        linkedList->first = linkedList->first->nextNode;
        linkedList->quantity = linkedList->quantity - 1;
    }
}

void removeEnd(LinkedList *linkedList) {
    if (linkedList->quantity == 1) {
        removeBeginning(linkedList);
    } else {
        Node *node = linkedList->first;
        while (node->nextNode != linkedList->last) {
            node = node->nextNode;
        }
        node->nextNode = NULL;
        linkedList->last = node;
        linkedList->quantity = linkedList->quantity - 1;
    }
}

void removeAnywhere(LinkedList *linkedList, int position) {

}

void searchByCPF(LinkedList *linkedList, int cpf) {
    if (linkedList->quantity == 0) {
        cout << "Lista vazia.";
    } else {
        Node *node = linkedList->first;
        while (node != NULL) {
            if (node->person->cpf == cpf) {
                cout << "Name: " << node->person->name << "\n";
                cout << "Age: " << node->person->age << "\n";
                cout << "CPF: " << node->person->cpf << "\n";
                return;
            }
            node = node->nextNode;
        }
        cout << "Não encontrado.";
    }
}

void print(LinkedList *linkedList) {
    if (linkedList->quantity == 0) {
        cout << "Lista vazia.";
    } else {
        Node *node = linkedList->first;
        while (node != NULL) {
            cout << "Name: " << node->person->name << "\n";
            cout << "Age: " << node->person->age << "\n";
            cout << "CPF: " << node->person->cpf << "\n";
            node = node->nextNode;
        }
    }
}

int main() {

    setlocale(LC_ALL, "");

    LinkedList *linkedList = new LinkedList;

    int functionSelected = 0;

    do {
        cout << "Select the function \n";
        cout << "0 - Close program \n";
        cout << "1 - Insert a node at the beginning of the list \n";
        cout << "2 - Insert a node at the end of the list \n";
        cout << "3 - Insert a node at the position n of the list \n";
        cout << "4 - Remove a node at the beginning of the list \n";
        cout << "5 - Remove a node at the end of the list \n";
        cout << "6 - Remove a node at the position n of the list \n";
        cout << "7 - Search a node by CPF \n";
        cout << "8 - Print the list \n";

        cout << "Choose a number and press ENTER: ";
        cin >> functionSelected;

        clearScreen();

        switch (functionSelected) {
            case 0:
                cout << "Finished program!";
                break;
            case 1:
                insertBeginning(linkedList);
                break;
            case 2:
                insertEnd(linkedList);
                break;
            case 3:
                int positionToInsert;
                cout << "Entre com a posição: ";
                cin >> positionToInsert;
                insertAnywhere(linkedList, positionToInsert);
                break;
            case 4:
                removeBeginning(linkedList);
                break;
            case 5:
                removeEnd(linkedList);
                break;
            case 6:
                int positionToRemove;
                cout << "Entre com a posição: ";
                cin >> positionToRemove;
                removeAnywhere(linkedList, positionToRemove);
                break;
            case 7:
                int cpf;
                cout << "Insert the CPF: ";
                cin >> cpf;
                searchByCPF(linkedList, cpf);
                break;
            case 8:
                print(linkedList);
                break;
            default:
                cout << "Invalid Function!";
        }

        cout << "\n";
        system("pause");
        clearScreen();
    } while (functionSelected != 0);

    return 0;

}
