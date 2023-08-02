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

struct StaticList {
    Person *people;
    int sizeList;
    int length;
};

StaticList* createAStaticList() {
    StaticList *staticList = new StaticList;
    staticList->length = 10;
    staticList->people = new Person[staticList->length];
    return staticList;
}

Person createAPerson() {
    Person *person = new Person;

    cout << "Insert the name: ";
    cin >> person->name;

    cout << "Insert the age: ";
    cin >> person->age;

    cout << "Insert the CPF: ";
    cin >> person->cpf;

    return *person;
}

void clearScreen() {
    system("CLS");
}

void resizeList(StaticList *staticList) {
    staticList->length = staticList->length * 2;

    StaticList *newList = new StaticList;
    newList->length = staticList->length;
    newList->people = new Person[newList->length];
    newList->sizeList = staticList->sizeList;

    for (int i = 0; i < staticList->sizeList; i++) {
        newList->people[i] = staticList->people[i];
    }

    staticList = newList;
}

void insertBeginning(StaticList *staticList) {
    if (staticList->sizeList != 0) {
        if (staticList->sizeList == staticList->length) {
            resizeList(staticList);
        }
        for (int i = staticList->sizeList; i > 0; i--) {
            staticList->people[i] = staticList->people[i - 1];
        }
    }

    staticList->people[0] = createAPerson();
    staticList->sizeList = staticList->sizeList + 1;
}

void insertEnd(StaticList *staticList) {
    if (staticList->sizeList == 0) {
        insertBeginning(staticList);
    } else {
        if (staticList->sizeList == staticList->length) {
            resizeList(staticList);
        }
        staticList->people[staticList->sizeList] = createAPerson();
        staticList->sizeList = staticList->sizeList + 1;
    }
}

void insertAnywhere(StaticList *staticList) {
    if (staticList->sizeList == 0) {
        insertBeginning(staticList);
    } else {
        if (staticList->sizeList + 1 == staticList->length) {
            resizeList(staticList);
        }
        int index = -1;

        while (index < 0 || index > staticList->sizeList) {
            cout << "Choose the index of the list: ";
            cin >> index;
        }

        for (int i = staticList->sizeList + 1; i > index; i--) {
            staticList->people[i] = staticList->people[i - 1];
        }

        staticList->people[index] = createAPerson();
        staticList->sizeList = staticList->sizeList + 1;
    }
}

void removeBeginning(StaticList *staticList) {
    if (staticList->sizeList > 0) {
        for (int i = 0; i < staticList->sizeList; i++) {
            staticList->people[i] = staticList->people[i + 1];
        }
        staticList->sizeList -= 1;
    } else {
        cout << "Lista vazia!";
    }
}

void removeEnd(StaticList *staticList) {
    if (staticList->sizeList > 0) {
        staticList->sizeList -= 1;
    } else {
        cout << "Lista vazia!";
    }
}

void removeAnywhere(StaticList *staticList) {
    if (staticList->sizeList > 0) {
        int index = -1;

        while (index < 0 || index >= staticList->sizeList) {
            cout << "Choose the index of the list: ";
            cin >> index;
        }

        for (int i = staticList->sizeList - 1; i > index; i--) {
            staticList->people[i - 1] =staticList->people[i];
        }

        staticList->sizeList -= 1;
    } else {
        cout << "Lista vazia!";
    }
}

void searchByCPF(StaticList *staticList) {
    if (staticList->sizeList > 0) {
        int cpf;
        cout << "Insert the CPF: ";
        cin >> cpf;

        bool found = false;

        for (int i = 0; i < staticList->sizeList; i++) {
            if (staticList->people[i].cpf == cpf) {
                cout << "Name: " << staticList->people[i].name << "\n";
                cout << "Age: " << staticList->people[i].age << "\n";
                cout << "CPF: " << staticList->people[i].cpf << "\n";
                found = true;
            }
        }

        if (!found) {
            cout << "Não encontrado!";
        }
    } else {
        cout << "Lista vazia!";
    }
}

void print(StaticList *staticList) {
    if (staticList->sizeList > 0) {
        for (int i = 0; i < staticList->sizeList; i++) {
            cout << "Name: " << staticList->people[i].name << "\n";
            cout << "Age: " << staticList->people[i].age << "\n";
            cout << "CPF: " << staticList->people[i].cpf << "\n";
        }
    } else {
        cout << "Lista vazia!";
    }
}

int main() {

    setlocale(LC_ALL, "");

    StaticList *staticList = createAStaticList();

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
                insertBeginning(staticList);
                break;
            case 2:
                insertEnd(staticList);
                break;
            case 3:
                insertAnywhere(staticList);
                break;
            case 4:
                removeBeginning(staticList);
                break;
            case 5:
                removeEnd(staticList);
                break;
            case 6:
                removeAnywhere(staticList);
                break;
            case 7:
                searchByCPF(staticList);
                break;
            case 8:
                print(staticList);
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
