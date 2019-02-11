CC = gcc
CFLAGS = -Wall -g


all: smash

smash: history.o smash.o 
	$(CC) $(CFLAGS) $^ -o $@
	#valgrind --leak-check=yes test

clean:
	rm -f *.o smash

.PHONY: clean


