
int isPrimes(int num) {

int counter = 2;
int primeNotPrime = 0;
int remainder;

//looked it up 1 is not a prime number

if (num > 1){

	while (num > counter)
	{

	remainder = num % counter;
	counter++;

		if (remainder == 0){
		primeNotPrime = 1;
		//command to exit while loop in C?
		break;
		}
	}
}
	return primeNotPrime;
}



