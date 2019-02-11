#include <stdio.h>
#include <stdlib.h>
#include <unistd.h> //for sleep ()
#include <ring.h>

int main(void)
{

    init_buffer();
    /*Add in a bunch of entries*/
    int i;
    for(i = 0; i < 1000000; i++){
    	log_msg("log");
    }

    //sleep for (alarm_interval + 1) seconds to ensure that the
    //signal has fired and we have written out our file
    //This approach (hard coded sleep) is really bad
    //however for a quick test we can live with it for now
    printf("Sleeping for %d seconds to let signals finish\n" , alarm_interval + 2);
    sleep(alarm_interval + 2);
    exit(EXIT_SUCCESS);
}
