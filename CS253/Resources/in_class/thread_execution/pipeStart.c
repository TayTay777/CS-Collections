#include <stdlib.h>
#include <stdio.h>
#include <sys/types.h>
#include <sys/wait.h>
#include <unistd.h>
#include <string.h>
#include <ctype.h>

//main program function:
//Standard input will be processed, then spit back out by 
//the child in all caps


int echoInCaps(int readStream){
  FILE *stream;
  int c;

  printf("I am the child!\n");
  stream = fdopen (readStream, "r");
  if(stream == NULL){
   perror("Error:");
   return 0;
  }

  fprintf(stdout,"child:");
  fflush(stdout);
  while ((c = fgetc (stream)) != EOF) {
    fprintf(stdout,"%c",toupper(c));
    fflush(stdout);
  }
  fclose (stream);
  return 0;
}

int main(int argc, char** argv){


//variables for standard in
  char* messageIn;
  int c;
  int length;
  // this is an original message size - it may change
  int messageSize = 5;

  // STUDENT: create a pipe to share with a child


  pid_t pid;
  int myPipe[2];



if (pipe(myPipe)){
fprintf (stderr, "Pipe failed.\n");
return EXIT_FAILURE;
}

  // STUDENT: create the child

messageIn = malloc(sizeof(char)*messageSize);
  pid = fork ();
  if (pid == (pid_t) 0)
    {
	printf("%p\n",messageIn); 

      /* This is the child process.
 *          Close other end first. */
      close (myPipe[1]);
      echoInCaps(myPipe[0]);
      return EXIT_SUCCESS;
    }
  else if (pid < (pid_t) 0)
    {
      /* The fork failed. */
      fprintf (stderr, "Fork failed.\n");
      return EXIT_FAILURE;
    }
  else
    {
   
	printf("%p\n",messageIn); 
  /* This is the parent process.
 *          Close other end first. */
      close (myPipe[0]);
      FILE *parentStream;
      parentStream = fdopen (myPipe[1], "w");
      
      printf("I am the parent!\n");
      // allocate the original size
      printf("Type in a message to give to the child:\n");

      length = 0; 
      while((c=getchar())!='\n'){
      messageIn[length]=c;
      length++;
      if(length >= messageSize){
      messageSize*=2;
      messageIn = realloc(messageIn,messageSize);
    }
    }
    messageIn[length] = '\0';
    fprintf(parentStream, "%s\n", messageIn);
    return EXIT_SUCCESS;
    }





//message size will double if length is greater than message size 

  // STUDENT: send to child
 
  // STUDENT: wait for the child - what happens if you leave this out?
  /*int status;
  int w = waitpid(pid, &status, WUNTRACED);
  if (w == -1) {
    perror("waitpid");
    return -1; 
  }*/
  free(messageIn); 
  return 0;
}
