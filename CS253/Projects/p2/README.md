***Project 2***

Author: Taylor Roberts
Class: CS253 Section 002

Overview:

Program suite that takes info from stdout and outputs number of words, chars, lines, numbers 0-9, and number of matches for specified word (word match optional). 


Compiling & Using:

Run using command (wc-match < data) after running make.
Ex:  [taylorroberts878@onyxnode16 p2]$ wc-maker < data1

You can make further use of the program by searching for match of specified words. For instance, if I would like to find out how many times the word "when" is written within the data1 file, I would use the command...
Ex: [taylorroberts878@onyxnode16 p2]$ wc-match -m when < data1
-m tells the program to expect a word after the -m argument. It is required to search for a word match

'<' symbol indicates that data is going into the program
'>' symbol indicates where data from the program's output is going out to
'2>' symbol indicates where all standard error data from the program's output is going out to

Ex: [taylorroberts878@onyxnode16 p2]$ wc-match < data1 > output
This full argument would take data from data1, run it through the program, then store the results in a new or already existing file called "output" 


Testing:

Testing was pretty straight forward. I began using the code provided in the intro directory. After I set up the basic structure I ran the program everytime I make a major change to see what the output was. The error messages from the make file compilation were very helpful, so whenever I got an error message, I would look directly to the indicated area in the code. As far as figuring out how to split up the -m argument into separate letters, that took awhile. I tried about 5 different methods, mixing them together as well, that involved mostly storing a string within an array that had two functions... it didnt work out well. What saved me was these things called pointers that I just learned about for this particular project. It only took a couple prints of each character to find out my code was finally working the way I envisioned it. After I stored the separate letters of the match-word, I wrote a nested if statement to check for the matches. I got this correct on the first try, after running the program and seeing that the number of matches correlated to the spec file provided for one of the data files. I have worked with a lot of arrays and nested for loops, so I guess I'm not that surprised. I did not make any specific test files for this project. 


Sources Used:

Most of the sources I used outside of class where unhelpful except the one I mentioned about about using a pointer variable for the match-word. [Here is the link!](https://stackoverflow.com/questions/32858256/split-a-stringa-word-to-letters-in-c) This link is also references within my code, main.c. I think I owe credit to the person that asked the question, and the person that answered the question. 


Known Issues:

A known issue would be that the program fails to close after typing "wc-match -m <word>" without an input source. 



