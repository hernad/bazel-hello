
#ifndef JNABOOTSTRAP_H
#define JNABOOTSTRAP_H

#include <jni.h>
#include <string.h>
#include <stdio.h>
#include <stdlib.h>

//#include <iostream>

char* OPTION_CP = (char* )"-Djava.class.path=";

// Path to the Java API code, and the JNA layer for it
char* CUSTOM_LIB = (char* )"JAVA_CLASSES:JAVA_CLASSES_2";

// Paths to the JNA components
char* JNA_LIB = (char* )"JNA_DIR/jna-4.2.2.jar";
char* JNA_PLATFORM_LIB = (char* )"JNA_DIR/jna-platform-4.2.2.jar";

// Path to the native version of the library
char* CUSTOM_C_LIB = (char* )"CLIB";

// Path to parts of the standard Java installation
char* JAVA_LIB = (char* )"JDK_HOME/jre/lib";
char* JLI_LIB = (char* )"JDK_HOME/jre/lib/jli";
char* SERVER_LIB = (char* )"JDK_HOME/jre/lib/server";

char* SEP = (char* )":";

JavaVM *jvm;
JNIEnv *env;

jobject object = NULL;

void create_vm(char* classname) {
    
    if (jvm)
       return;

    JavaVMInitArgs vm_args;
    JavaVMOption* options = new JavaVMOption[1];
    
    const char* cPath = getenv("JAVA_HOME");

    // /usr/lib/jvm/java-1.8.0-openjdk
    printf("JAVA_HOME=%s\n", cPath);

    int length = strlen(cPath) + 100;
    
    options[0].optionString = new char[length];
    sprintf(options[0].optionString, "-Djava.class.path=%s:./libjava_lib.jar:.", cPath);
    
    printf("------ create_vm class: %s ----------\n", classname);


    vm_args.version = JNI_VERSION_1_6;
    vm_args.nOptions = 1;
    vm_args.options = options;
    vm_args.ignoreUnrecognized = false;
    
    printf("Creating the JVM with classpath=%s\n", options[0].optionString);
    int ret = JNI_CreateJavaVM(&jvm, (void**) &env, &vm_args);
    delete options;
    if (ret == -5) {
        //jint JNI_GetCreatedJavaVMs(JavaVM **vmBuf, jsize bufLen, jsize *nVMs);
        // vmBuf: pointer to the buffer where the VM structures will be placed.
        // bufLen: the length of the buffer.
        // nVMs: a pointer to an integer.

        jsize bufLen = 1;
        jsize nVMs;
        JNI_GetCreatedJavaVMs( &jvm, bufLen, &nVMs);
        printf("bufLen=%d, nVMS=%d\n", bufLen, nVMs);
        if (nVMs == 1) {
           ret = jvm->GetEnv((void**) &env, JNI_VERSION_1_6);
        }
    }

    if ( ret < 0 ) {
        // https://stackoverflow.com/questions/43810827/return-code-of-jni-createjavavm
        // #define JNI_EEXIST       (-5)              /* VM already created */
        printf( "--Unable to Launch JVM %d\n", ret );
        return;
    } else {
        printf("java vm created :)\n");
    }

    printf("Looking for %s\n", classname);
    jclass cls = env->FindClass(classname);
    if ( !cls ) {
        printf( "--Could not load class %s\n", classname );
        return;
    }
    
    printf("Getting main\n");
    jmethodID main_method = env->GetStaticMethodID(cls, "main", "([Ljava/lang/String;)V");
    if ( !main_method ) {
        printf("--main_method is null!\n");
        return;
    }

    printf("Getting constructor\n");
    jmethodID constructor = env->GetMethodID(cls, "<init>", "()V");
    if ( !constructor ) {
        printf("--Could not load constructor\n");
        return;
    }
    printf("--------------------------------------\n");

    return;
}



#endif /* JNABOOTSTRAP_H */