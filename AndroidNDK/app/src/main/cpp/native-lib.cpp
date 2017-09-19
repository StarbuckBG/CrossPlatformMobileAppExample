#include <jni.h>
#include <string>
#include "Person.hpp"
#include "Manager.hpp"
#include "Student.hpp"

const char *describePerson(Person *pPerson);

using namespace std;


extern "C"
JNIEXPORT jstring JNICALL
Java_com_rapid_androidndktest_MainActivity_stringFromJNI(
        JNIEnv *env,
        jobject /* this */) {
    std::string hello = "Hello from C++";
    return env->NewStringUTF(hello.c_str());
}

const char *describePerson(Person *pPerson) {
    const map<string, string> data = pPerson->dictionaryData();
    string result = "{";
    for (auto const &entry : data) {
        result += '"' + entry.first + '"';
        result += ":\"" + entry.second + "\",";
    }
    result  += '}';
    return result.c_str();
}

extern "C"
JNIEXPORT jstring JNICALL
Java_com_rapid_androidndktest_MainActivity_getPeople(
        JNIEnv *env,
        jobject /* this */) {
    Student *student1 = new Student("Ivan", "1232132", 14, 4.92, 7, "8556544");
    Student *student2 = new Student("Petar", "123211231", 16, 5.89, 9, "8192379132133");
    Worker *worker1 = new Worker("Geоrgi", "unknown", 31, 4.23, 0.78, 6);
    Worker *worker2 = new Worker("Todor", "182937221", 29, 6.19, 0.98, 7);
    Worker *worker3 = new Worker("Stefan", "91623187312", 26, 5.2, 0.83, 4);
    Manager *manager = new Manager("Gergana", "123761823", 31, 14.3, 0.99, 9,
                                   {worker1, worker2, worker3});
    std::vector<Person *> persons = vector<Person*>();
    persons.push_back(worker1);

    string result = "[";
    for (vector<Person *>::iterator it = persons.begin(); it != persons.end(); it++) {
        result += describePerson(*it) + ',';
    }
    result += ']';
    return env->NewStringUTF(result.c_str());
}
