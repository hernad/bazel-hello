#include "JavaCAPI.h"

unsigned int microseconds = 1000000;

using namespace std;

int main(int argc, char** argv) {

    int val = 2;

    bool useCPP = false; // use the C or C++ API?
    
    if ( useCPP ) {
        // Use C++ API
        JavaCAPI* pJavaCAPI = new JavaCAPI();
        
        const char* thisGuy = pJavaCAPI->getName();
        
        pJavaCAPI->logme( (char* )thisGuy );
        
        for ( int x = 0; x < 5; x++ ) {
            val = pJavaCAPI->calc(val);
            printf("In C++: value returned: %d\n", val);
        }
        delete pJavaCAPI;
    }
    else {
        // Use C API
        const char* thisGuy = getName();
        
        logme( (char* )thisGuy );
        
        for ( int x = 0; x < 5; x++ ) {
            val = calc(val);
            printf("In C: value returned: %d\n", val);
        }
    }
    
    return 0;
}
