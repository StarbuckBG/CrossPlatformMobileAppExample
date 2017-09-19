//
//  Manager.hpp
//  ProgrammingLanguages
//
//  Created by Martin Kuvandzhiev on 9/11/17.
//  Copyright © 2017 Rapid Development Crew. All rights reserved.
//

#ifndef Manager_hpp
#define Manager_hpp

#include <stdio.h>
#include <iostream>
#include "Worker.hpp"

class Manager:public Worker {
public:
    std::vector<Worker*> workers;
    Manager(std::string name, std::string id, int age, float pricePerHour, float productivityCoef, int workExperience, std::vector<Worker*> workers);
    Manager(const Manager &manager);
    Manager& operator=(const Manager &manager);
    std::map<std::string, std::string> dictionaryData() override;
};
#endif /* Manager_hpp */

