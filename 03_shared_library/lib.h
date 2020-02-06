#define SYM  "symbol01"


#ifdef COMPILING_DLL
#define DLLEXPORT __declspec(dllexport)
#else
#define DLLEXPORT
#endif

extern "C" DLLEXPORT char *get_time();
extern "C" DLLEXPORT void say_hello(char *);


extern "C" int get_number_plus_2(int number);
