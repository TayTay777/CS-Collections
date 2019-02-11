
CC=gcc
CFLAGS=-Wall -g  


all: SimpleTestList.o RandomTestList.o test.o


SimpleTestList: SimpleTestList.o List.o Node.o Job.o
	$(CC) $(CFLAGS) -o $@ $^

RandomTestList: RandomTestList.o List.o Node.o Job.o
	$(CC) $(CFLAGS) -o $@ $^


clean:
	rm --force *.o RandomTestList SimpleTestList 

