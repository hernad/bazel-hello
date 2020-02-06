#include <stdio.h>
#include "lib.h"

#ifdef _MSC_VER
   #include <windows.h>
#endif

extern "C" {

#ifdef _MSC_VER
  DLLEXPORT
#endif
  int get_number_plus_2(int number) {
	printf(SYM);
	return number + 2;
  }

}
