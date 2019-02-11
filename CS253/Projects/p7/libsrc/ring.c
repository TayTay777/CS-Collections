#include <string.h>
#include <stdio.h>
#include <time.h>
#include <ring.h>
#include <stdlib.h>
#include <unistd.h>
#include <signal.h>
#include <pthread.h>

pthread_mutex_t mutex;
int dumpBuffer; //variable for checking the last dump of the buffer array
static void dump_buffer();
static void alarmReset(int alarmSignal);


static struct {
    int curr;
    char log[MAX_LOG_ENTRY][MAX_STRING_LENGTH];
} buff;


void *foo(void* foo){
	while(1){
		dump_buffer();
		sleep(alarm_interval);
	}
}


void init_buffer()
{
    pthread_t pid;
    dumpBuffer = 0; 
    printf("Initialize the ring buffer\n");
    signal (SIGALRM, alarmReset); //signal-handler for alarm reset and buff dump to disk
    int i;
    for(i = 0; i < MAX_LOG_ENTRY; i++) {
        buff.log[i][0]='\0';
    } //Sets alarm to send a signal to macro SIGALRM every 2 secs
                           //handler resets the alarm the re-calls the signal function (handler at bottom)
    buff.curr = 0;

    pthread_create(&pid,NULL,foo,NULL);
}



/**
 * Return the current timestamp (localtime) from the system.
 */
static char *getTimeString()
{
    time_t myTime = time(NULL); //this is a system call
    char *timeString = ctime(&myTime);
    timeString[strlen(timeString)-1] = '\0'; //erase the newline at the end
    return timeString;
}


void log_msg(char *entry)
{
    if (entry == NULL) {
        printf("Skipping null log entry!\n");
        return;
    }

    printf("Adding log entry into buffer\n");

    char *timeString = getTimeString();
    int idx = buff.curr % MAX_LOG_ENTRY;

    snprintf(buff.log[idx], MAX_STRING_LENGTH, "%s -- %s", timeString, entry);

    buff.curr++;

    if (dumpBuffer==1){
	dump_buffer();
	dumpBuffer=0;
    }
}



/*
 * Right now this is just printing to the console. We want to change this to
 * write to a file (log_name) and we want to use signals to trigger the logging
 * event. This also needs to be fixed so that it prints the log messages in the
 * right order (from the oldest to the newest).
 *
 * This method should write all the current entries to disk in the right order
 * (from the oldest to the newest). We will use the constant log_name as the
 * name of the file.
 */
static void dump_buffer()
{
    FILE *file = fopen (log_name, "w");
    int i;
    if(!file) {
	printf("Error: couldn't open file.\n");
	return;
    }

    else{
	for(i = 0; i < MAX_LOG_ENTRY; i++) {
	pthread_mutex_lock(&mutex);
	fprintf(file, "log %d: %s\n",i, buff.log[i]);
	pthread_mutex_unlock(&mutex);
	}
    }
    fclose(file);
}



/*function that resets or rather re-calls the alarm function as 
 * well as the signal function. Sets dumpBuffer to '1' in order
 * to let the dump_buffer() function know that there is new data
 * to be saved to the disk (file)
 */

static void alarmReset(int alarmSignal){

    fflush (stdout);
    signal (SIGALRM, alarmReset);
    alarm (alarm_interval);
    dumpBuffer = 1;
}

