//
//  history.c
//  
//
//  Created by Taylor Paul Roberts on 11/03/17.
//
//

#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <unistd.h>
#include "history.h"

#define MAXLINE 4096
#define MAX_HIST 500



//function to create initial array for storing cmd structs
//in other words, array to hold history data
void init_history(struct cmd * hist, int capacity)
{
    
    //init our commands we want a multi-sized array
    hist->commands = malloc(sizeof(char*) * (MAX_HIST));
    
    hist->capacity=MAX_HIST;
    hist->current = 0;
    hist->pid = NULL;
}


//function to add cmd structs into history
void add_history(struct cmd * hist, char * command)
{
    int current_index = hist->current % MAX_HIST;
    if(hist->current >= MAX_HIST){
        printf("History full. CLEAR before adding more\n");
        
    }else{
        
        hist->commands[current_index] = malloc(sizeof(strlen(command)+1));
        strncpy(hist->commands[current_index],command, MAXLINE -1);
        (hist->current)++;
    }
}


//function to clear history of arguments
void clear_history(struct cmd * hist)
{
    int i;
    for(i=0; i< hist->current; i++)
    {
        free(hist->commands[i]=NULL);
    }
    printf("History cleared.\n");
}


//function that prints history of arguments
void print_history(struct cmd * hist)
{
    int i;
    for(i=0;i<(hist->current)-1;i++){
        printf("[%d] %s\n", i, hist->commands[i]);
        
    }
}

