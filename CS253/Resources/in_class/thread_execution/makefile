C = gcc
CFLAGS = -Wall -g -pthread


all: run

run: hello_arg2.c 
	$(CC) $(CFLAGS) $^ -o $@

clean:
	rm -f *.o run

.PHONY: clean


