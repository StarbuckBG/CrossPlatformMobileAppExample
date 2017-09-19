//
//  Manager.cpp
//  ProgrammingLanguages
//
//  Created by Martin Kuvandzhiev on 9/11/17.
//  Copyright © 2017 Rapid Development Crew. All rights reserved.
//

#include "Manager.hpp"
#include "to_string.cpp"

Manager::Manager(std::string name, std::string id, int age, float pricePerHour, float productivityCoef, int workExperience, std::vector<Worker*>workers) : Worker(name, id, age, pricePerHour, productivityCoef, workExperience) {
    this->workers = workers;
}

std::map<std::string, std::string> Manager::dictionaryData() {
    std::map<std::string, std::string> dataDict;
    dataDict = Worker::dictionaryData();
    
    for (int i = 0; i < this->workers.size(); i++) {
        dataDict["Worker" + to_string(i)] = this->workers[i]->name;
    }
    return dataDict;
}
