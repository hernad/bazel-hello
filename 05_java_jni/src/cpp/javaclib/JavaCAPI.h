#ifndef JAVACAPI_C_H
#define JAVACAPI_C_H

#include "JNABootstrap.h"
#include <iostream>
#include <cstdlib>
#include <unistd.h>

using namespace std;

extern "C" int calc(int value);
extern "C" const char* getName(void);
extern "C" void logme(char* msg);

typedef void (*callback) (int); // for callback

class JavaCAPI {
public:
    JavaCAPI();
    JavaCAPI(const JavaCAPI& orig);
    virtual ~JavaCAPI();
    
    // API
    int calc(int value);
    const char* getName(void);
    void logme(char* msg);
    void callme(callback func);
private:
    
};

#endif /* JAVACAPI_C_H */
