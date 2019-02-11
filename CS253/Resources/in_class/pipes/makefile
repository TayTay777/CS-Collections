C = gcc
CFLAGS = -Wall -g


all: run

run: pipeStart.c 
	$(CC) $(CFLAGS) $^ -o $@
	valgrind --leak-check=yes test

clean:
	rm -f *.o run

.PHONY: clean


