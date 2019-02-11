#include <stdio.h>
#include <unistd.h>
#include <signal.h>




int main (int argc, char** argv){



/* process A */
/* ... */
 if (fork() == 0) {
    if (fork() == 0) {
        if (fork() == 0) {
            if (fork() == 0) {
             printf("Print text\n");


            }
        }
    }
 }
/* ... */



printf("Print text\n");





}
