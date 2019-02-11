Taylor Roberts, P7 SafeThreadBUffer
CS253 
Ring Buffer Library {#mainpage}
===================

YOU MUST COMPLETE THIS README.md FILE BEFORE SUBMITTING!

To run the test programs you will need to set the paths to find the library:

```
export LD_LIBRARY_PATH=$LD_LIBRARY_PATH:./lib
```

Then run the test programs as follows:

```
./grader
```

Or the run.sh script will set the path for you and execute valgrind:

```
./run.sh
```

To run the autograder before submitting, run:

```
./backpack.sh
```

Functionality:
This update to the buffer assignment adds the functionality of threading. The threading will split up the work load of loading and dumping information from the buffer to the ring.log file. 

How to Use:
As mentioned above, you can additionally type the number of threads and the number of messages you would like to log after the grader command.

Example:
Grader 4 1000000

The about command would run the buffer with 4 threads and log 1000000 messages. Essentially this should allow the logging to finish 4x fasther than with just one thread.



Bugs:
I could not understand how to connect the about command line options with the test-threads.c file, so I just ran the test file with 1000000 messages, all having their own thread. It works, b/c all the messages are being logged at the same time. I still would like to know how to get this working. 



