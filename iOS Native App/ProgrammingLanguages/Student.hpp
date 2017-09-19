//
//  Student.hpp
//  ProgrammingLanguages
//
//  Created by Martin Kuvandzhiev on 9/11/17.
//  Copyright © 2017 Rapid Development Crew. All rights reserved.
//

#ifndef Student_hpp
#define Student_hpp

#include <stdio.h>
#include "Person.hpp"

class Student:public Person{
public:
    float averageMark;
    int grade;
    std::string studentId;
    
    Student(std::string name, std::string personId, int age, float averageMark, int grade, std::string studentId);
    Student(const Student &student);
    Student& operator=(const Student &student);
    std::map<std::string, std::string> dictionaryData() override;
};

#endif /* Student_hpp */

