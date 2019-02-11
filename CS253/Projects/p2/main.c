#include <stdio.h>
#include <ctype.h>
#include <stdlib.h>
#include <unistd.h>
#define IN 1 /* inside a word */
#define OUT 0 /* outside a word */



int main(int argc, char **argv)
{


//GetOpt variables
int hflag = 0;
char *mvalue = NULL;
int index;
int m;
//WordCountCode variables
int c;
long nc, nw, nl;
int state;
long zero, one, two, three, four, five, six, svn, ate, nine;
//WordMatchVariables
int DashMLength = 0;
int DashMMatchCount = 0;
int numberOfMatches = 0;
char DashMChar[20];



//used for GetOpt
opterr = 0;


//printf("%s\n", argv[2]); -for testing purposes


//code for storing the mvalue as separate letters using a pointer variable

char *p = argv[2];
while ( *p != '\0' ) {
          //printf ("%c\n", *p  ); 
		DashMChar[DashMLength] = *p;
		DashMLength++;
           p++ ; // got help from https://stackoverflow.com/questions/32858256/split-a-stringa-word-to-letters-in-c
}



//for testing purposes, next two lines
//printf("%c\n", DashMChar[2]);
//printf("%i\n", DashMLength);


/* below code within the getchar() while loop*/
//if (mvalue != NULL){

//	if (c == DashMChar[DashMMatchCount]){
//	DashMMatchCount++;
//	else
//	DashMMatchCount = 0;
//	}
//	if (DashMMatchCount == DashMLength){
//	numberOfMatches++;
//	DashMMatchCount = 0;
//	}

//}


//GetOpt functionality
  while ((m = getopt (argc, argv, "hm:")) != -1)
    switch (m)
      {
      case 'h':
        hflag = 1;
        break;
      case 'm':
        mvalue = optarg;
        break;
      case '?':
        if (optopt == 'm')
          fprintf (stderr, "Option -%m requires an argument.\n", optopt);
        else if (isprint (optopt))
          fprintf (stderr, "Unknown option `-%m'.\n", optopt);
        else
        fprintf (stderr, "Unknown option character `\\x%x'.\n", optopt);
        return 1;
      default:
        abort ();
      }


if (hflag == 1)
printf("\nProgram is formatted to take in the executable (wc-match) then an argument, if neccessary. \n format: <wc-match> <optional -m> <option word with -m> < <data standard in> > <Data standard out> \n Note: 2> for error output\n");



//beginning of word counting code

    state = OUT;
nc = nw = nl = 0; 
zero= one= two= three= four= five= six= svn= ate= nine = 0;
    while ((c = getchar()) != EOF ) {
        nc++;
        if (c == '\n') 
            nl++;
	if (c == '0')
	zero++;
	if (c == '1')
	one++;
	if (c == '2')
	two++;
	if (c == '3')
	three++;
	if (c == '4')
	four++;
	if (c == '5')
	five++;
	if (c == '6')
	six++;
	if (c == '7')
	svn++;
	if (c == '8')
	ate++;
	if (c == '9')
	nine++;

//word match code
if (mvalue != NULL){

	if (c == DashMChar[DashMMatchCount])
	DashMMatchCount++;
	else
	DashMMatchCount = 0;

	if (DashMMatchCount == DashMLength){
	numberOfMatches++;
	DashMMatchCount = 0;
	}

}


        if (c == ' ' || c == '\n' || c == '\t') {
            state = OUT;
        } else if (state == OUT) {
            state = IN;
            nw++;
        }
    }

    printf("words: %ld\nchars: %ld\nlines: %ld \n",  nw, nc, nl);
printf("digit 0: %ld\ndigit 1: %ld\ndigit 2: %ld\ndigit 3: %ld\ndigit 4: %ld\ndigit 5: %ld\ndigit 6: %ld\ndigit 7: %ld\ndigit 8: %ld\ndigit 9: %ld\n", zero, one, two, three, four, five, six, svn, ate, nine);
  
if (mvalue == NULL)
printf("matched : 0\n");
else
  printf ("matched %s: %i \n", mvalue, numberOfMatches);


  for (index = optind; index < argc; index++)
    printf ("Non-option argument %s\n", argv[index]);
  return 0;
}
