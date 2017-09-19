//
//  TestClass.m
//  ProgrammingLanguages
//
//  Created by Martin Kuvandzhiev on 9/12/17.
//  Copyright © 2017 Rapid Development Crew. All rights reserved.
//

#import "DataProvider.h"

#include "Person.hpp"
#include "Student.hpp"
#include "Worker.hpp"
#include "Manager.hpp"

@implementation DataProvider


- (void) testFunction {
    Person * person = new Person("Name", "123456", 21);
    NSLog(@"%@", [NSString stringWithFormat:@"%s", person->description().c_str()]);
}

- (id) init {
    self = [super init];
    self.objects = [self getObjects];
    return self;
}


- (std::vector<Person*>) getObjects {
    Student * student1 = new Student("Ivan Stefanov Dimitrov", "1232132", 14, 4.92, 7, "8556544");
    Student * student2 = new Student("Petar Georgiev Petrov", "123211231", 16, 5.89, 9, "8192379132133");
    Worker * worker1 = new Worker("Georgi Vladev Vladev", "unknown", 31, 4.23, 0.78, 6);
    Worker * worker2 = new Worker("Todor Ivanov Gospodinov", "182937221", 29, 6.19, 0.98, 7);
    Worker * worker3 = new Worker("Stefan Ivanov Gospodinov", "91623187312", 26, 5.2, 0.83, 4);
    Manager * manager = new Manager("Gergana Dimitrova Petkova", "123761823", 31, 14.3, 0.99, 9, {worker1, worker2, worker3});
  
    std::vector<Person*> persons = {student1, student2, worker1, worker2, worker3, manager};
    return persons;
}


@end

