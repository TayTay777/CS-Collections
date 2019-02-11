# Project 1 Part 3 (Regular Expressions)

* Author: Taylor Paul Roberts
* Class: CS361
* Semester: Fall 2018

## Overview

This java suite takes in a regular expression, then creates a corresponding NFA
to represent it. The NFA can then be turned into a DFA with the DFA class and 
methods provided by the .jar file, which contains both DFA and NFA class and methods.

## Compiling and Using

To compile, execute the following command in the main project directory:
```
[User]$ javac -cp ".:./CS361FA.jar" re/REDriver.java
```

Run the compiled class, including a .txt file, with the command:
```
[User]$ java -cp ".:./CS361FA.jar" re.REDriver ./tests/p3tc1.txt
```

In the run command, the last part (Ex. ./tests/p3tc1.txt) is the test file
directory, followed by the test file itself. '/' represent going into a 
directory. 

## Discussion

The test files for the regEx suite include a regular expresion on the first line,
then a path to test on the proceeding lines. There can be an unlimited amount of 
test paths, as long as your computer can handle it, of course. 

Example: p3tc1.txt (provided test file)
(a|b)*a  <--Regular expression
aaaa     <--Path of traversal, as well as the proceeding lines. 
aba
bba
a
b
bbb

The regular expression can contain characters '(', ')', 'a', 'b', 'e', '|' , and '*'.
'a', 'b', 'e', are transition characters, '(' and ')' are used to contain expressions,
'|' represents the U union symbol, and '*' represents a loop.

Test file feedback: If the path of traversal can successfully run through the regular
expression at the top of the test file, then a resulting yes should be printed out to 
the terminal. 

Example: output from running p3tc1.txt 
yes
yes
yes
yes
no
no

***Note: the REDriver class takes care of everything, you just have to properly format
and provide a test file, as mentioned above, and put it in the ./tests/<testFILEname> 
directory. 

Files provided:

|--- re
|    |-REDriver.java
|    |-REInterface.java
|    |-RE.java
|
|-- tests
|    |-- p3tc1.txt
|    |-- p3tc2.txt
|    |-- p3tc3.txt
|
|-- CS361FA.jar
|-- CS361FAdocs.zip
|-- README.txt ( the file you're reading :) )

## Sources used

I used the provided CS361FAdocs.zip file for documentation regarding the NFA and DFA
classes. 

I also refered to the oracle java docs to learn about the Vector storage system here,
https://docs.oracle.com/javase/8/docs/api/java/util/Vector.html

I also like to thank Matt Might for recommending the Vector storage system. He did not 
personally recommend it, but it is mentioned in one of his articles. 