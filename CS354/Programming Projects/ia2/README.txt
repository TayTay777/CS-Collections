Taylor Roberts
CS354-2
Dr. James Buffenbarger 
Interpreter2 


This program is based on a real interpreter that can take in lines of code one by one. This particular interpreter adds on the the first interpreter assignment, adding things like "if, then, else statements" and "begin" "end" blocks. For the full list of changes, refer to the grammar file that comes with the java program suite. 


## Getting Started


Once in the directory of the java suite, compile by running
javac *.java
in a shell that has jdk java integrated

Once compiled, the program can be run and tested by typing
java Interpreter 
then your expressions you would like to be solved

Now you can have more than one statement within an command prompt argument. After each statement, a ";" is required, except for the last statement.
Ex:
"y = 1+1; z = y + 7; x = 333"

formatting for expressions is still the same...
<variable name> = <number> <+,-,*,/> <number>;
Ex: x = 3 + 2;

formatting for Boolean if statements is as follows...
<if> <boolean expression> <then> <statement> <else> <statement>
**note the else is optional, followed by a statement is optional
Ex: if 3 > 5 then y = 3 else y = 5
B/c 3 is less than 5, the variable y = 5

***THE ONLY WAY TO SEE OUTPUT IS WITH THE "wr" COMMAND***
Ex: "y = 3 + 3 + 3 + 3; x = 3 + 3 + 3; wr y"
Output: 12

***You can refer to the Grammar file to get formatting requirements as well as the changes from interpreter 1, as mentioned above. 


##Advanced Use


**How to use established variables with multiple programs:

Ex: x = 3 + 2;
x = 5

java Interpreter "x = 3 + 2" "y = x + 3"
x = 5
y = 8

**You can also put comments in a program.

Conditions: comments must be contained within pound signs, and be within the program parameter (ie, quotes)
Ex: " x = 3 + #this is a comment# 3; "

**Running multiple statements within a one program.

-Simply put a semi-colon after every program, followed by another program
-the last program within the quotes does not need a semi-colon
Ex. "if 4 > 3 then y = 5; x = 5 + y; wr x"
This contains three programs
-if 4 > 3 then y = 5
-x = 5 + y
-wr x

**"begin" block "end"

-A block is just a placeholder for any combination that is allowed with the grammar structure. In other words, if you would like to put a program within a program, You can do so with a begin-(program)-end statement.
Ex: " x = 3 + 3; begin x = 3 + 3; y = 4 + 4; if y == 8 then x = x + 1 end; y = 5"


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
prg - contains the program being tested. (example: x = 3+3; y = 4+4) Can only contain one program at a time.

If the contents of exp and out folders do not match, then a failed message will appear.

***For some reason the test suite is not working, probably my personal bash configuration***

console print outs as follows...

Taylor $ "if 3 > 2 then y = 4 + 4; x = # comment comment comment # 3 + 3; wr x; wr y; y = 3+3; wr y; if y == 7 then wr 3 else wr 777; begin y =3; if 3 >= 3 then x = 5; wr x + y end"

Output: 6.0
8.0
6.0
777.0
8.0


Taylor $ "if 5 > 4 then y = 5 else y = 6; wr y"

Output: 5.0


Taylor $ "rd y; wr 3 + y"
Input: 30
Output: 33.0

###Authors###
Taylor Paul Roberts and Dr. James Buffenbarger


