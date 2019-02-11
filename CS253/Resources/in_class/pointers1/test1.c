#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include "mystrcpy.h"
#include "myRevArr.h"


int main(int argc, char** argv){


char* str0 = "this";
char* str1 = "is";
char* str2 = "a";
char* str3= "string";

int numStrings = 4;

char** sentence = (char**)malloc(numStrings * sizeof(char*));


sentence[0] = str0;
sentence[1] = str1;
sentence[2] = str2;
sentence[3] = str3;


char **destArray = myRevArr(sentence, numStrings);

  if(destArray != NULL){
    if(destArray==sentence){
      printf("ERROR: test failure 2\n");
    }
    if(destArray[0]==sentence[0]){
      printf("ERROR: test failure 3\n");
    }
    if(destArray[0]==sentence[4]){
      printf("ERROR: test failure 4\n");
    }
    if(strcmp(destArray[0],sentence[4]) != 0){
      printf("ERROR: test failure 5\n");
    }
    if(strcmp(destArray[4],sentence[0]) != 0){
      printf("ERROR: test failure 6\n");
    }
    for(i=0;i<numstrings;i++){
      free(destArray[i]);
    }
    free(destArray);
  }else{
    printf("FATAL ERROR: exiting\n");
  }
  free(sentence);



return 0;

}
