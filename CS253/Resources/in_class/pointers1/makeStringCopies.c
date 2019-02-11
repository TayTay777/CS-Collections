#include <stdio.h>



void mystrcpy(char *dest, char *source){

char *t1 = dest;
char *t2 = str;

while (*dest != NULL){
*dest = *source;
dest++;
source++;
}
return;

dest = t1;
source = t2;

}



