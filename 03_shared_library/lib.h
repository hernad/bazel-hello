#define SYM  "symbol01"

#ifdef _MSC_VER
   #include <windows.h>
#endif

#ifdef COMPILING_DLL
#define DLLEXP __declspec(dllexport)
#else
#define DLLEXP
#endif


extern "C" DLLEXP int get_number_plus_2(int number);
