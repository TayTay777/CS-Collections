//
//  history.h
//  
//
//  Created by Taylor Paul Roberts on 10/20/17.
//
//

#ifndef HISTORY_H
#define HISTORY_H


//struct for cmd commands
//treats cmd command lines as objects
struct cmd{
    void * pid;
    char ** commands; // malloc'd string containing the command that was run include arguments.
    int current;
    int capacity;
};


//functions from history.c with input types
void init_history(struct cmd * hist, int capacity);
void add_history(struct cmd * hist, char* command);
void clear_history(struct cmd * hist);
void print_history(struct cmd * hist);



#endif /* __HISTORY_H */
