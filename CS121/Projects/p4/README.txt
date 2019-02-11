{\rtf1\ansi\ansicpg1252\cocoartf1404\cocoasubrtf130
{\fonttbl\f0\fmodern\fcharset0 Courier;}
{\colortbl;\red255\green255\blue255;}
\margl1440\margr1440\vieww15520\viewh8400\viewkind0
\deftab720
\pard\pardeftab720\partightenfactor0

\f0\fs26 \cf0 \expnd0\expndtw0\kerning0
**********************\
p4\
CS 121\
Nov 11, 2015\
Taylor Paul Roberts\
**********************\
\
OVERVIEW:\
\
This program scans a text file\'92s content then gives you the statistics for numerous aspects of the file.\
\
\
INCLUDED FILES:\
\
 * TextStatisticsInterface.java \
 * TextStatistics.java\
 * ProcessText.java\
 * TextStatisticsTest.java\
 * README \
\
-TextStatistics.java is a class that scans the file and creates statistics for that file.\
\
-ProcessText.java is another class that utilizes TextStatistics.java, making it easy to get all the statistics of a file with one command line in the console.\
\
-TextStatisticsTest.java is used to verify the class TextStatistics is scanning files properly.\
\pard\pardeftab720\partightenfactor0
\cf0 \
-TextStatisticsInterface.java is an interface for the user, giving the user all the needed methods for accessing the TextStatistics object.\
\
COMPILING AND RUNNING:\
\
From the directory containing all the source files, run ProcessText followed by text files within the same directory. This will get back a summary of the statistics for the file(s).\
\
Ex: java ProcessText testFile.txt anotherFile.txt andAnotherFile.txt\
\
\
PROGRAM DESIGN AND IMPORTANT CONCEPTS:\
\
The package consists of two classes that work with each other to achieve user friendly interaction with fast results. As stated in the COMPILING AND RUNNING above, running the ProcessText java file will give output of the files you choose to scan in the program. \
\
The program ProcessText.java\'92s foundation is TextStatistics. This java doc contains the code that scans and stores the results of the statistics. ProcessText makes life simple by creating a TextStatistics object from a command line input, then implementing the TextStatistics toString which contains information derived from all the methods within TextStatistics.\
\
TextStatistics\'92 constructor calculates all of the statistics. The methods of the class simple give back the results. \
\
TESTING:\
\
Testing this program was very easy. Simply running the TextStatistics.java doc informed whether or not the program is giving back correct statistics for the file in question. \
\
Creating a new java doc and implementing/running the separate methods every time a change was made showed how far the program was getting to the right output as well.\
\
\
DISCUSSION:\
\
This project was fun to work with. For the character count, it was puzzling as to why the count was missing just a little after getting the line\'92s length. In time it was revealed that the end of every line had a character of \\n that the line.length() did not account for so I fixed that quick. For the alphabet array, finding out how the letters had a number that represented them, and then how to store that in the array was fun. Finding the average word length was interesting as well. At first it sounded like something very easy to write out, but then when it came to writing the code, a lot of thinking a writing on paper was needed. In the end everything worked out just fine.\
\
EXTRA CREDIT:\
\
+5 extra credit for turning in the project before midnight on November 11, 2015.\
\
\
----------------------------------------------------------------------------\
\
}