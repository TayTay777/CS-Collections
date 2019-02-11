 
**********************
* Clocks
* CS 221
* February 22, 1990
* Taylor Paul Roberts
**********************

OVERVIEW:

This set of classes was created to show the use of inheritance and polymorphism. 

There are 5 different types of clocks and each one of them inherits the methods from the Clock class.


INCLUDED FILES:

- TimePiece.java - Interface.  
- Clock.java - Parent Class.
- Sundial.java - Individual clock Class.
- CuckooClock.java - Individual clock Class.
- GrandfatherClock.java - Individual clock Class.
- AtomicClock.java - Individual clock Class.
- WristWatch.java - Individual clock Class.
- ClockSimulation.java - Runs simulation.
- README - this file.


COMPILING AND RUNNING:

 To run the program, simply execute the ClockSimulation java file. This file will run a simulation 
 for every type of clock. This test will read the time of the clocks after one day, week, month, then year. 
 You will also have the accumulated drift time, which is different depending on the type of clock.
 
 From the directory containing all source files, compile the
 driver class (and all dependencies) with the command:
 $ javac ClockSimulation.java
 
 Run the compiled class file with the command:
 $ java ClockSimulation
 
 
PROGRAM DESIGN AND IMPORTANT CONCEPTS:

 The first thing this project touched based on was inheritance. With inheritance you can gain all the methods from another class. Classes are shown with an "extends" connotation in the class header for Individual clock classes. It is also shown within the display() method for each individual clock the use of inheritated methods. Use of an abstract class was created as well. 
 
 Polymorphism was used to show that a container for "Clock" objects can hold any type of children off branches
 that Clock class is a parent of. This was very useful, and ultimately took less time to complete the assignment because 
 of the polymorphism implementation. 
 
 The program calls upon the tick() method for every second that has passed. I created a for loop for every instance of time 
 passing. 

TESTING:

I tested the program using the ClockSimulation java file. This file creates objects within the bag() object. Once creating
the 5 different types of clocks, you can then use getter methods from the bag() class to edit the information, at the same
time using methods inheritated from the clock class. 


DISCUSSION:
 
There was little issues with the program. I have never used an enumeration before, nore have I used a getter method to 
edit the element I am retrieving. Pretty snazzy. 
 
 
