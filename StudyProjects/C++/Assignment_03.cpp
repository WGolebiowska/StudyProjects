#include <iostream>
using namespace std;


/*
==========Assignment No. 3==========

Design and implement class Person with name, surname, age and address fields. Address should be an dynamic Address class object. Address class should have city, zipcode, street and street number fields. 

Both classes should have default constructor and second constructor for initializing objects with given values of for all fields. Also they should have << operator.

One of these classes must have copy constructor, = operator and destructor.

Testing code is given (in main).

*/

class Address{
    private:

        string _city;
        string _zipcode;
        string _street;
        int _number;

    public:

        Address():_city("-"), _zipcode("-"), _street("-"), _number(0){};
        Address(const string &a1, const string &a2, const string &a3, const int &a4):_city(a1), _zipcode(a2), _street(a3), _number(a4){};
    
        friend ostream& operator << (ostream&, const Address&);
};

class Person{
    private:

        string _name;
        string _surname;
        int _age;
        Address *_address;

    public:

        Person():_name("-"), _surname("-"), _age(0), _address(new Address){};
        Person(const string &a1, const string &a2, const int &a3, const Address &a4):_name(a1), _surname(a2), _age(a3), _address(new Address(a4)){};
        Person(const Person &r):_name(r._name), _surname(r._surname), _age(r._age), _address(r._address){};
        ~Person(){delete _address;};

        Person& operator = (const Person &r){
            _name = r._name;
            _surname = r._surname;
            _age = r._age;
            *_address = *r._address;

            return *this;
        }

        friend ostream& operator << (ostream&, const Person&);
};

ostream& operator << (ostream &os, const Address &address){
    return os << address._city << ", " << address._zipcode << ", " << address._street << " " << address._number << endl;
}

ostream& operator << (ostream &os, const Person &person){
    return os << person._name << " " << person._surname << ", " << person._age << " lat, " << *person._address << endl;
}

int main(){

    Address* pointer = new Address("Krakow", "42-100", "Waszyngtona", 73); 
    cout << *pointer << '\n'; 

    Address a1(*pointer); 
    delete pointer; 
    const Address* pointer1 = new Address("Warszawa", "00-950", "Mysliwiecka", 357); 
    cout << a1 << '\n'; 
    cout << *pointer1 << '\n';

    Address a2; 
    cout << a2 << '\n'; 

    a2 = a1; 
    cout << a2 << '\n'; 

    Person o("Jan", "Kowalski", 25, *pointer1); 
    delete pointer1; 
    cout << o << '\n';

    Person o1(o); 
    cout << o1 << '\n'; 

    Person o2; 
    cout << o2 << '\n';

    o2 = o1; 
    cout << o2 << '\n';

    return 0;
}