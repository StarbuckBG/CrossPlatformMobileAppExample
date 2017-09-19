//
//  Person.cpp
//  ProgrammingLanguages
//
//  Created by Martin Kuvandzhiev on 9/11/17.
//  Copyright © 2017 Rapid Development Crew. All rights reserved.
//

#include <stdio.h>
#include "Person.hpp"


Person::Person(std::string name, std::string id, int age){
    this->name = name;
    this->personalId = id;
    this->age = age;
}

Person::Person(const Person &person) {
    this->name = person.name;
    this->personalId = person.personalId;
    this->age = person.age;
}


Person& Person::operator=(const Person &person) {
    this->name = person.name;
    this->personalId = person.personalId;
    this->age = person.age;
    return *this;
}



std::string Person::description() {
    std::string descripton = this->name + " " + this->personalId + " " + std::to_string(this->age);
    return descripton;
}

std::map<std::string, std::string> Person::dictionaryData() {
    std::map<std::string, std::string> dataDict;
    dataDict["Name"] = this->name;
    dataDict["PersonalId"] = this->personalId;
    dataDict["age"] = std::to_string(this->age);
    return dataDict;
}

