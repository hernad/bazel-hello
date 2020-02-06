#include <stdio.h>
#include "lib.h"

extern "C" {
	
int main(){
  printf("\n\n2+2=%d\n", get_number_plus_2(2));
  return 0;
}

}
