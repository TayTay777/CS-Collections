CC=gcc

all: tester 

test: tester.c isPrimes.c primeInterface.c
	./tester

	$(CC) -o tester tester.c isPrimes.c primeInterface.c

clean: 
	rm -f tester *.o 
