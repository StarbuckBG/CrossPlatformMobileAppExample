//
//  TestClass.h
//  ProgrammingLanguages
//
//  Created by Martin Kuvandzhiev on 9/12/17.
//  Copyright © 2017 Rapid Development Crew. All rights reserved.
//

#import <Foundation/Foundation.h>

#include "Person.hpp"
#include "Student.hpp"
#include "Worker.hpp"
#include "Manager.hpp"


@interface DataProvider : NSObject

- (std::vector<Person*>) getObjects;

@property std::vector<Person*> objects;

@end
