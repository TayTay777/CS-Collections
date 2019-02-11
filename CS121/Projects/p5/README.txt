 
**********************
* p5
* CS 121
* Dec 9th, 2015
* Taylor Paul Roberts
**********************

OVERVIEW:

 MineWalker is a game where you traverse down a path, attempting to avoid mines as you go.
 The goal is to hit the least amount of mines as possible. 

INCLUDED FILES:

 List the files required for the project with a brief
 explanation of why each is included.

 * MineWalker.java
 * MineWalkerPanel.java
 * RandomWalk.java
 * README.txt


COMPILING AND RUNNING:

 Run the program to initiating java MineWalkerPanel. This will run the code from the MineWalker 
 java file b/c the MineWalkerPanel is the main panel that the other panels from MineWalker rest on.


PROGRAM DESIGN AND IMPORTANT CONCEPTS:

This program's main concept is going over the array of buttons that makes up the entire grid and 
then checking each button for a specific characteristic. 

There are two main characteristics for the buttons. 
-array of Mines
-array of the path (generated using RandomWalk.java)

If the user clicks outside of the bounds of touching buttons, the program will not recognize this as 
a move. The system for checking the mines is simple. Your current position with be the color of how many 
mines there are around you based the on the color key outlined on the left of the GUI. 

When you update the grid size, all the buttons are re-made within the gridPanel Panel. (note, if the 
grid boxes are too small, the "x" will show "...")

TESTING:

The testing was pretty cut and dry. Adding the code, the running the program revealed all the little to dos
of the program. There was many instances where all the buttons on the gridPanel needed to be sweeped, or reset so
to speak in order for a clean look. 


DISCUSSION:

I personally had difficulties deciding the logic for the valid moves that the player can make. For example, if the player
clicks anywhere outside the up one down one ect. bounds, it is not valid. 

Otherwise, I had a lot of fun seeing how the logic works out with the points vs. button location. Very interesting how 
you tie the two together, and then it works! 

