Taylor Roberts
CS354-2
Dr. James Buffenbarger 
la3 - Prolog 


This is a prolog programming language suite. This particular suite has a list of time slots that individuals are free. The program file meetone.pl different peoples available times to an entered value, then returns those names that are free for the entered value. meet.pl takes in names from the user, and prints out time slots that these entered names can meet. 

## Getting Started

Once in the directory of the prolog suite, compile by running
./<filename>.pl
in a shell that has GNU prolog 1.4.4

the two program files will run and compile at the same time. 

### Data Entry

***Entering in data for meetone.pl

-requires a time slot to be entered into the file within main.

Example:
meetone(Person,slot(time(8,30,am),time(8,45,am)))
is for a time slot from 8:30 am to 8:45 am


***Entering in data for meet.pl

-requires the user to enter in names from the data.pl file.
Names include ann, bob, carla, dave, ed.

Example:
people([ann,bob,carla]).
this line of code is right above main near the bottom of the file

***by default the example time slot and names are already entered into the file***


### Prerequisites

You will need to install GNU Prolog 1.4.4 or greater
You find help with this here... http://www.gprolog.org/manual/html_node/

## Running the tests

Running tests involved executing the program after adding code to the file to see if the desired outcome printed out onto the console. 

Here are some results for meetone.pl...
 meetone(Person,slot(time(8,30,am),time(8,45,am)))
[ann,ann,bob,carla,dave,ann,ann,bob,carla,dave]

 meetone(Person,slot(time(9,0,am),time(10,0,am)))
[ann,ann,ann,bob,carla,carla,dave,dave,ed,ann,ann,ann,bob,carla,carla,dave,dave,ed]

I have not completed the meetone.pl or meet.pl, and I am aware that the am and pm are not quite right for my meetone true/false check. I would like to just add an additional 12 hours if the ampm field is pm, that should do the trick, but atlas, I have ran out of time!

The meet.pl is hardly finished at all. Sorry!

## Authors

Taylor Roberts, CS Department @ BSU, Dr. James Buffenbarger 
