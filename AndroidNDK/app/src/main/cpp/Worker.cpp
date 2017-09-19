//
//  Worker.cpp
//  ProgrammingLanguages
//
//  Created by Martin Kuvandzhiev on 9/11/17.
//  Copyright © 2017 Rapid Development Crew. All rights reserved.
//

#include "Worker.hpp"
#include "to_string.cpp"


Worker::Worker(std::string name, std::string id, int age, float pricePerHour, float productivityCoef, int workExperience):Person(name, id, age){
    this->pricePerHour = pricePerHour;
    this->productivityCoef = productivityCoef;
    this->workExperience = workExperience;
}

Worker::Worker(const Worker &worker): Worker(worker.name, worker.personalId, worker.age, worker.pricePerHour, worker.productivityCoef, worker.workExperience){
    
}

Worker& Worker::operator=(const Worker &worker) {
    this->name = worker.name;
    this->personalId = worker.personalId;
    this->age = worker.age;
    this->pricePerHour = worker.pricePerHour;
    this->productivityCoef = worker.productivityCoef;
    this->workExperience = worker.workExperience;
    return * this;
}

std::map<std::string, std::string> Worker::dictionaryData() {
    std::map<std::string, std::string> dataDict;
    dataDict = Person::dictionaryData();
    dataDict["Price per Hour"] = to_string(this->pricePerHour);
    dataDict["Productivity coefficent"] = to_string(this->productivityCoef);
    dataDict["Work Experience"] = to_string(this->workExperience);
    
    return dataDict;
}
