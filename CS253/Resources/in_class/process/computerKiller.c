#include <stdio.h>
#include <unistd.h>
#include <signal.h>

int main()
{
    while(1)
       fork();
    return 0;
}
