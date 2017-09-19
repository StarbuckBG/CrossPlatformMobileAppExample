//
//  Worker.hpp
//  ProgrammingLanguages
//
//  Created by Martin Kuvandzhiev on 9/11/17.
//  Copyright © 2017 Rapid Development Crew. All rights reserved.
//

#ifndef Worker_hpp
#define Worker_hpp

#include <stdio.h>
#include "Person.hpp"

class Worker:public Person {
public:
    float pricePerHour;
    float productivityCoef;
    int workExperience;
    
    Worker(std::string name, std::string id, int age, float pricePerHour, float productivityCoef, int workExperience);
    Worker(const Worker &worker);
    Worker& operator=(const Worker &worker);
    std::map<std::string, std::string> dictionaryData() override;
};

#endif /* Worker_hpp */
