
CC=gcc
LIBFLAGS=-I. -shared -fPIC
CFLAGS=-I. -Wall -shared -fPIC
LIBS=-lmylib
LIBOBJS=f1.o f2.o f3.o

all: libmylib.so libmylib.a  test1 test1-static

libmylib.so: $(LIBOBJS)
	$(LD) $(LIBFLAGS) -o $@ $?

libmylib.a: $(LIBOBJS)
	$(AR)  rcv $@ $(LIBOBJS)
	ranlib $@


test1: test1.c
	$(CC) -Wall -save-temps -I. -L. test1.c -lmylib -o $@



test1-static: test1.c
	$(CC) -Wall -I. -L. test1.c -lmylib -o $@

clean:
	/bin/rm -f *.o libmylib.so libmylib.a a.out core test1 test1-static
