#include <stdio.h>
#include "lib.h"

extern "C" {
  int get_number_plus_2(int number) {
	printf(SYM);
	return number + 2;
  }

}
