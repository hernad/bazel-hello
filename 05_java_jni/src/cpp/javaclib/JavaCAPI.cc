#include "JavaCAPI.h"
#include <jni.h>


typedef int (*calc_cb) (int); 
typedef jstring (*getName_cb) (void);
typedef void (*logme_cb) (jstring);

calc_cb calc_cb_func = 0;
getName_cb getName_cb_func = 0;
logme_cb logme_cb_func = 0;

int value = 10;
JavaCAPI* m = new JavaCAPI();

// Java Callback Registration

extern "C" void reg_calc_cb(calc_cb func) {
    printf("C set reg_calc_cb - attach java callback\n");
    calc_cb_func = func;
}

extern "C" void reg_getName_cb(getName_cb func) {
    printf("C set reg_getName_cb - attach java callback\n");
    getName_cb_func = func;
}

extern "C" void reg_logme_cb(logme_cb func) {
    printf("C set reg_logme_cb - attach java callback\n");
    logme_cb_func = func;
}

// Native library classname
char *classname = (char *)"ba/out/JavaLib";
//char *classname = (char *)"ba/out/run/Run";

JavaCAPI::JavaCAPI() {
    create_vm(classname);
}

JavaCAPI::JavaCAPI(const JavaCAPI& orig) {
}

JavaCAPI::~JavaCAPI() {
    // clean up Java objects and JVM
    if ( jvm ) {
        printf("Closing JVM()\n");
        jvm->DestroyJavaVM();
    }
}

int JavaCAPI::calc(int value) {
    return ::calc(value);
}

const char* JavaCAPI::getName(void) {
    return ::getName();
}

void JavaCAPI::logme(char* msg) {
    ::logme(msg);
}

void JavaCAPI::callme(callback func) {
    if ( func ) {
        func( ++value );
    }
}

// C API

extern "C" int calc(int value) {
    printf("C calc(value=%d), java classname=%s\n",value, classname);
    
    create_vm( classname );
    
    if ( calc_cb_func ) {
        return calc_cb_func(value);
    }
    return -1;
}

extern "C" const char* getName(void) {
    printf("C getName() ; java classname=%s\n", classname);
    
    create_vm(classname);
    
    if ( getName_cb_func ) {
        jstring jstr = getName_cb_func();
        return strdup( (char*)jstr );
    }
    return NULL;
}

extern "C" void logme(char* msg) {

    printf("C logme; msg=%s; java classname=%s\n", msg, classname);
    create_vm(classname);
    
    if ( logme_cb_func ) {
        jstring jstr = (jstring)msg;
        printf("logme_cb_func jstring %s\n", msg);
        logme_cb_func( jstr );
    } else
       printf("C LOGME [no java callback]: %s\n\n", msg);
}

extern "C" void callme(callback func) { 
    printf("=========C start callback =========\n");
    return m->callme(func);
}

