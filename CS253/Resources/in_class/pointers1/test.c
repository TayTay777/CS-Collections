
#include <string.h>
#include <stdio.h>
#include "mystrcpy.h"
#include <stdlib.h>

int main (void) {

char* s1 = "bye";
char* destination = (char*)malloc(sizeof(char)* strlen(s1)+1);

mystrcpy (destination, s1);

if (!strcmp(destination, s1) != 0){
printf("String does not match!");
}


return 0;



}
