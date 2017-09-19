//
//  Student.cpp
//  ProgrammingLanguages
//
//  Created by Martin Kuvandzhiev on 9/11/17.
//  Copyright © 2017 Rapid Development Crew. All rights reserved.
//

#include "Student.hpp"


Student::Student(std::string name, std::string personId, int age, float averageMark, int grade, std::string studentId) : Person(name, personId, age), averageMark(averageMark), grade(grade), studentId(studentId){
    this->averageMark = averageMark;
    this->grade = grade;
    this->studentId = studentId;
}


Student::Student(const Student &student) : Student::Student(student.name, student.personalId, student.age, student.averageMark, student.grade, student.studentId) {
    
}


Student& Student::operator=(const Student &student) {
    this->name = student.name;
    this->personalId = student.personalId;
    this->age = student.age;
    this->averageMark = student.averageMark;
    this->grade = student.grade;
    this->studentId = student.studentId;
    return * this;
}

std::map<std::string, std::string> Student::dictionaryData() {
    std::map<std::string, std::string> dataDict;
    dataDict = Person::dictionaryData();
    dataDict["averageMark"] = std::to_string(this->averageMark);
    dataDict["grade"] = std::to_string(this->grade);
    dataDict["studentId"] = this->studentId;
    return dataDict;
}
