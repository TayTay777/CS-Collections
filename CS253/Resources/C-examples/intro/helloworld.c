/* C-examples/intro/helloworld.c */

#include <stdio.h>
//#include <unistd.h>
int main(void)
{
	int returnvalue = write(1, "Hello World!\n", 13);

    //O means normal termination, non zero means abnormal termination
    return 0;
}
