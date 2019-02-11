#build the grader from the file test.c

CC=gcc
CFLAGS=-Wall -pthread -g -I../include 

grader: test-threads.o 
	$(CC) $(CFLAGS) -o $@ $^  -L../lib/ -lring

clean:
	/bin/rm -f *.o grader
