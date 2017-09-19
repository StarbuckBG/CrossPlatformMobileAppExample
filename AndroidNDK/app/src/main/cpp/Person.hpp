//
//  Person.h
//  ProgrammingLanguages
//
//  Created by Martin Kuvandzhiev on 9/11/17.
//  Copyright © 2017 Rapid Development Crew. All rights reserved.
//


#ifndef Person_h
#define Person_h

#include <iostream>
#include <string>
#include <vector>
#include <map>


class Person {
public:
    std::string name;
    std::string personalId;
    int age;
    
    Person(std::string name, std::string id, int age);
    Person(const Person &person);
    Person& operator=(const Person &person);
    
    std::string description();
    virtual std::map<std::string, std::string> dictionaryData();
    
};

#endif /* Person_h */
