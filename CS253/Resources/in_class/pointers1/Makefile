CC = gcc
CFLAGS = -Wall -g


all: test

test:  test1.c myRevArr.c 
	$(CC) $(CFLAGS) $^ -o $@
	valgrind --leak-check=yes test


clean:
	rm -f *.o test

.PHONY: clean


