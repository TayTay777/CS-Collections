//
//  smash.c
//  
//
//  Created by Taylor Paul Roberts on 11/03/17.
//
//
#include <sys/wait.h>
#include <signal.h>
#include "history.h"
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <unistd.h>
#define MAXLINE 4096
#define MAXARGS 500



//declaring methods

int main(int argc, char *argv[]);
static char *smash_get_input(char *line, int n);
static int smash_cd(const char* dir);
static void smash_parse_args(const char *line, int *argc, char **argv);
static void smash_free_args(int argc, char **argv);
int chdir(const char *path);



char string[MAXLINE];
char buf[MAXLINE];
char* token;
int num = 0;
struct cmd history;
int rd;


int main(int argc, char *argv[]){
    struct cmd history;
    char line[MAXLINE];
    char *args[MAXARGS];
    int count=0;
    //for first command input
    printf("$ ");


const char* s = getenv("SMASH_KILL");
printf("%s", s);
printf("PATH :%s\n",(s!=NULL)? s : "getenv returned NULL");

    
    init_history(&history, 5);
    
    while(smash_get_input(line, MAXLINE)!=NULL){
        add_history(&history, line);
        smash_parse_args(line, &count, args);
        
        //for succeeding command input lines
        printf("$ ");
        
        if(args[0]!=NULL){
            if(strcmp(args[0], "exit")==0){
                smash_free_args(count, args);
                
                break;
                
            }else if(strcmp(args[0], "cd")==0){
                smash_cd(args[1]);
                
            }else if(strcmp(args[0], "history")==0){
                print_history(&history);
                
            }
            else if(strcmp(args[0], "clear")==0){
                clear_history(&history);
          
            }
	    else{
		//rd can only be 0,1,2,or 3, giving us 4 options
		//if we set only one to false, then that is a 3 in 4 chance
		//of happening with the random number generator
	        const char* smashKill = getenv("SMASH_KILL");
		char* smashSet = "yes";
		rd= rand()%4;
	        pid_t pid;
	        int status;
		//only forks 75% of the time after running pre-made commands
		if  (strncmp(smashKill,smashSet , 3)== 0){
			execvp(args[0], args);
                        fprintf(stderr,"couldn't execute: %s\n", args[0]);
                        return 1;
		}
		
		else{

		if (rd!=1){
	        	if ((pid = fork()) < 0){
			printf("fork error\n");

	        	
			}else if (pid == 0){
			execvp(args[0], args);
			fprintf(stderr,"couldn't execute: %s\n", args[0]); 
			return 1;
			}     

			//Informs parent process to wait until child finishes
			if ((pid = waitpid(pid, &status, 0)) < 0){
			fprintf(stderr, "waitpid error\n");
			//printf("%% ");
	             	}
		}
		}
	       }
        }
        smash_free_args(count, args);
    }
    clear_history(&history);
    return EXIT_SUCCESS;
}



static char *smash_get_input(char *line, int n){
    if(fgets(line, n, stdin) !=NULL){
        //trims the new line character
        line[strlen(line)-1]= '\0';
        return line;
    }
    return NULL;
}


//change directory code using command cd
static int smash_cd(const char* dir)
{
    
    char cwd[MAXLINE]={};
    //check if valid directory change
    
    //if NULL, returns to HOME directory
    if(dir==NULL){
        dir= getenv("HOME");
        
    }
    
    if(chdir(dir)==0){
        if(getcwd(cwd, MAXLINE)==NULL){
            printf("error: getcwd failed");
            return -1;
            
        }
        printf("%s\n", cwd);
    } else{
        printf("error: %s does not exist\n", dir);
        return -1;
        
    }
    return 0;
}



static void smash_free_args(int argc, char **argv){
    int i=0;
    for(i=0; i<argc; i++){
        //can but used to pring arguments after every input, neccessary for previous part
        //printf("[%d] %s\n", i, argv[i]);
        
    }
}



static void smash_parse_args(const char *line, int *argc, char **argv){
    char *copy;
    char *token;
    
    //token for sting copies
    copy= malloc(sizeof(char) *(strlen(line)+1));
    strcpy(copy, line);
    
    *argc=0;
    
    //turns arguments into tokens, then stores in argv array
    token= strtok(copy, " ");
    
    while(token!=NULL &&*argc<MAXARGS-1){//strtok has returned something valid
        //allocate memory 
        argv[*argc]=malloc(sizeof(char) *(strlen(token)+1));
        //copy into array
        strcpy(argv[*argc], token);
        //get next token
        token= strtok(NULL," ");
        (*argc)++;
    }
    
    argv[*argc]=NULL;
    
    //freeing all memory malloc'd
    free(copy);
    
    
    
}





