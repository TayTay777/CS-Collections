CC=gcc
DEPS=myHeader.h
CFLAGS=-I.
OBJ = main.o f1.o f2.o f3.o 

all: myprog

%.o: %.c $(DEPS)
	$(CC) -c -o $@ $< $(CFLAGS)

myprog: $(OBJ)
	gcc -o $@ $^ $(CFLAGS)

.PHONY: clean

clean: 
	rm myprog $(OBJ)
