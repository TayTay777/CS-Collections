Taylor Roberts
CS354-2
Dr. James Buffenbarger 
Interpreter1 


This program is based on a real interpreter that can take in lines of code one by one. This particular interpreter is very basic, only being about to solve addition/subtraction and multiplication/devision, then storing these expressions as a variable. Variables established can be used in separate expressions as well. From here on out, any reference to the word 'program' is referencing the expressions. program = Ex: "x = 3 + 2;"

## Getting Started

Once in the directory of the java suite, compile by running
javac *.java
in a shell that has jdk java integrated

Once compiled, the program can be run and tested by typing
java Interpreter 
then your expressions you would like to be solved

All expressions must be contained with "" in order to be seen as separate arguments by the Interpreter.
formatting for the expressions is as follows...
<variable name> = <number> <+,-,*,/> <number>;
Ex: x = 3 + 2;

##Advanced Use

**How to use established variables with multiple programs:

Ex: x = 3 + 2;
x = 5

java Interpreter "x = 3 + 2;" "y = x + 3;"
x = 5
y = 8

**You can also put comments in a program.

Conditions: comments must be contained within pound signs, and be within the program parameter (ie, quotes)
Ex: " x = 3 + #this is a comment# 3; "

### Prerequisites

You will need to install JDK 8
Link: https://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html
This java development kit is used for running the .java files

## Running the tests

In order to run tests, a test suite has been created
The test suite is located in the test folder, located in the directory of the java suite (where all the .java files are)
Once within the test folder, you can run the suite by typing
sh run

Every folder in the test suite has four text files consisting of 
exp - contains what the desired output of the program in prg should be if working correctly
inp - contains the input of the program 
out - stout, the programs output, is printed into this file
prg - contains the program being tested. (example: x = 3+3;) Can only contain one program at a time.

If the contents of exp and out folders do not match, then a failed message will appear

##Additional Notes & issues for grader
For some reason the test suite is not finding what is stored in the prg file. 
I have run tests on my own, and will paste them below because of this as well as submit screen shot with project

>  Interpreter java Interpreter "x = 33 + 44;"
77.0
>  Interpreter java Interpreter "x = 33 + 44;" "y = x + 83;"
77.0
160.0
>  Interpreter java Interpreter "x = 33 + 44;" "y = x + -----83;"
77.0
-6.0
>  Interpreter java Interpreter "x = 33 + 44;" "y = x +#jajjjljljjljkljkj# -----83;"
77.0
-6.0
>  Interpreter java Interpreter "x = 33 + 44;" "y = x + -----83;#comment after semi colon#"
77.0
-6.0
>  Interpreter java Interpreter "x = 33.99 * 44;" "y = x / -----83.82;#comment after semi colon#"
1495.5600000000002
-17.842519685039374
>  Interpreter

## Built With

* [Eclipse IDE](https://www.eclipse.org/) - The IDE used

## Authors

Taylor Roberts, CS Department @ BSU, Dr. James Buffenbarger 
