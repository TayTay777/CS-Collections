Project 3 (Smash Prt2)
Author: Taylor Paul Roberts
Class: CS253 Section 2

**Overview** 
Program is it’s own shell. Just like any other shell like terminal on a mac, it can change directories using the ‘cd’ command and store argument values, with the addition of displaying the entire history of all cmd commands for part 2. 

For part 3 of the assignment we added the function to fork all processes that involved commands not already created in main. These forks will only work 75% of the time.

**Compiling and Using**
To compile code suite simple enter make into the shell. The executable file name is ‘smash’. To clean up, simply type “make clean” into the console, just like any other standard make file functionality for standard C. This suite will take in stdin via the ‘<‘ and print to stdout via the ‘>’ sign with a file. 

As mentioned in the overview, the forks will only work 75% of the time. If you would like to disable this, before going into the smash shell, export the environment variable SMASH_KILL to "yes. You will also have to export the variable because the smash shell is techinally a child shell from the one your running.

Example: [user@onyx]$ export SMASH_KILL="yes"

To re-enable the 75% forking, exit out of smash, then set SMASH_KILL to anything besides yes

Example,
[taylorroberts878@onyx p3]$ smash < test.in


If only the executable is typed, you will be brought into the smash shell itself. Once inside you can use commands exit (for exiting), cd <directory> (for changing directories), and "history" for displaying all the cmd commands entered in by whom ever the user is. 

Example,
$[taylorroberts878@onyx p3]$ smash
$ cd /home
/home
$ cd /directorythatdoesnotexist
error: /directorythatdoesnotexist does not exist
$ history
$ [0] cd /home
[1] cd /directorythatdoesnotexist
$ history
$ [0] cd /home
[1] cd /directorythatdoesnotexist
[2] history
$ exit
[taylorroberts878@onyx p3]$ 

*Note that exiting the smash shell will remove all data stored in memory of your cmd commands!

**Testing**
The makefile helped a lot with compile testing. Basically I ran the makefile, and looked over all the errors that showed up, looking specifically where they were pointing to in the smash.c file. Warnings come second. As for testing the functionality, I basically used the shell myself as if I was a user. Once my results met the criteria of the assignment, I called it a day ;)

**Sources used**
No sources were used, but I would like to note that I got a lot of help from my peers and Tutors in the CS lab. I think class helped the most this time around! Thanks Teach!

**Know issues?**
For some reason I get an error about the memory being tampered with after I had already freed it. This came up every so often, but I'm pretty sure I fixed it by removing a call to data after the data was freed. Also, randomly the history will delete two struct object data values. Again, this seems to happen randomly, but is most likely associated with the above error discribed. I have not seen this happen again either. I would investigate further into this by just creating a test.in file with a lot of cmd commands, but I am strapped for time. I cannot seem to get the dollar signs to populate in the right places. A simple fix, I'm sure.
