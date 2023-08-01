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

void clearScreen() {
    system("CLS");
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

void resizeList(Person *&people, int *quantity, int *length) {
    *length = *length * 2;
    Person *newPeople = new Person[*length];

    for (int i = 0; i < *quantity; i++) {
        newPeople[i] = people[i];
    }

    people = newPeople;
}

void insertBeginning(Person *&people, int *quantity, int *length) {
    if (*quantity != 0) {
        if (*quantity == *length) {
            resizeList(people, quantity, length);
            for (int i = *quantity; i > 0; i--) {
                people[i] = people[i - 1];
            }
        }
    }

    people[0] = createAPerson();
    *quantity = *quantity + 1;
}

void insertEnd(Person *&people, int *quantity, int *length) {
    if (*quantity == 0) {
        insertBeginning(people, quantity, length);
    } else {
        if (*quantity == *length) {
            resizeList(people, quantity, length);
        }
        people[*quantity] = createAPerson();
        *quantity = *quantity + 1;
    }
}

void insertAnywhere(Person *&people, int *quantity, int *length) {
    if (*quantity == 0) {
        insertBeginning(people, quantity, length);
    } else {
        if (*quantity == *length || *quantity + 1 == *length) {
            resizeList(people, quantity, length);
        }
        int index = -1;

        while (index < 0 || index > *quantity) {
            cout << "Choose the index of the list: ";
            cin >> index;
        }

        for (int i = *quantity + 1; i > index; i--) {
            people[i] = people[i - 1];
        }

        people[index] = createAPerson();
        *quantity = *quantity + 1;
    }
}

void removeBeginning(Person *&people, int *quantity) {
    if (quantity > 0) {
        for (int i = 0; i < *quantity; i++) {
            people[i] = people[i + 1];
        }
        *quantity -= 1;
    } else {
        cout << "Lista vazia!";
    }
}

void removeEnd(Person *&people, int *quantity, int length) {
    if (quantity > 0) {
        *quantity -= 1;
    } else {
        cout << "Lista vazia!";
    }
}

void removeAnywhere(Person *people, int *quantity, int length) {
    if (quantity > 0) {
        int index = -1;

        while (index < 0 || index >= *quantity) {
            cout << "Choose the index of the list: ";
            cin >> index;
        }

        for (int i = *quantity - 1; i > index; i--) {
            people[i - 1] = people[i];
        }

        *quantity -= 1;
    } else {
        cout << "Lista vazia!";
    }
}

void searchByCPF(Person *people, int quantity) {
    if (quantity > 0) {
        int cpf;
        cout << "Insert the CPF: ";
        cin >> cpf;

        bool found = false;

        for (int i = 0; i < quantity; i++) {
            if (people[i].cpf == cpf) {
                cout << "Name: " << people[i].name << "\n";
                cout << "Age: " << people[i].age << "\n";
                cout << "CPF: " << people[i].cpf << "\n";
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

void print(Person *people, int quantity) {
    if (quantity > 0) {
        for (int i = 0; i < quantity; i++) {
            cout << "Name: " << people[i].name << "\n";
            cout << "Age: " << people[i].age << "\n";
            cout << "CPF: " << people[i].cpf << "\n";
        }
    } else {
        cout << "Lista vazia!";
    }
}

int main() {

    setlocale(LC_ALL, "");

    int length = 1;
    Person *people = new Person[length];
    int quantityElements = 0;

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
                insertBeginning(people, &quantityElements, &length);
                break;
            case 2:
                insertEnd(people, &quantityElements, &length);
                break;
            case 3:
                insertAnywhere(people, &quantityElements, &length);
                break;
            case 4:
                removeBeginning(people, &quantityElements);
                break;
            case 5:
                removeEnd(people, &quantityElements, length);
                break;
            case 6:
                removeAnywhere(people, &quantityElements, length);
                break;
            case 7:
                searchByCPF(people, quantityElements);
                break;
            case 8:
                print(people,quantityElements);
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
