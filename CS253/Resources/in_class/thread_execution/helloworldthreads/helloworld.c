#include <pthread.h>
#include <unistd.h>
#include <stdio.h>
#include <stdlib.h>
#include <sys/types.h>
#include <sys/wait.h>
#include <string.h>
#include <ctype.h>


//it should print. Three threads are executing. One of them is the parent.
//when the parent dyes, so do the children. Waitpid? Solution: allow the parent to wait
//until the child processes finish. 

void* printMSG(void* msg){

char* actualMessage = (char*)msg;
printf("%s", actualMessage);
fflush(stdout);
pthread_exit(NULL);

//return NULL;

}


int main(int argc, char** argv){


pthread_t thread1;
pthread_t thread2;

char* msg1 = "Hello ";
char* msg2 = "World!\n";

//create two threads

pthread_create(&thread1,NULL,printMSG,msg1);
pthread_create(&thread2,NULL,printMSG,msg2);

//printf("%s%s", msg1,msg2);
//printMSG(msg1);
//printMSG(msg2);

return 0;

}

pthread_create(
