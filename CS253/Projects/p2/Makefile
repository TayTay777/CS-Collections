CC = gcc
CFLAGS = -Wall -g


all: wc-match

wc-match: main.o 
	$(CC) $(CFLAGS) $^ -o $@

clean:
	rm -f *.o wc-match

.PHONY: clean


