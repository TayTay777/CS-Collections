Taylor Roberts
CS354-2
Dr. James Buffenbarger 
Interpreter2 


This program suite is a port from a java to C#. When ran, a window will pop up with a button and text field. The text in the center of the button will change from on to off and vise versa when clicked and every time the button is clicked a binary representation of the amount of clicks will show in the text field to the right of the button. 


## Getting Started


Once in the directory of the C# suite, compile by running command...

[User]$ mcs -r:System.Windows.Forms.dll -r:System.Drawing.dll \
LightSwitch.cs \
BinaryCounter.cs \
ToggleButton.cs \

(Note '\' characters are not neccessarily part of the compile command, but rather to show the command is one line. Can still be copied and pasted as is, and run fine.)


Once compiled, the program can be run and tested by typing...

[User]$ mono LightSwitch.exe

which will bring up the window described in the brief description header. 

### Prerequisites

You will need a C# compiler and executor installed in the shell you are using.

Mono, which is sponsored by Microsoft, has a free download at,
https://www.mono-project.com/download/stable/

Description at,
https://www.mono-project.com/docs/about-mono/languages/csharp/

## Running the tests

As far as testing went, I first followed the tutorials from http://zetcode.com/gui/csharpwinforms and ran the code provided. After I got a general sense of the C# layout with Forms, I started to understand how to extend classes as well. 

Before a made three separate files, I first put everything into one large file because I knew that would be fairly easy. Basically done to test basic coding structure first.

After I created the three files.cs from what I learned via zetcode.com, I ran and followed the error corrections based on the stack trace. I don't know if it's just me being inexperienced with C#, or what, but I thought the error codes weren't very helpful. 

I did run into one major issue that I had to put a band-aid on. I could not figure out how to call the OnClick methods I created for the button and counter classes within the lightswitch class. The compiler kept saying I could only call the OnClick methods within the class that it was created in. To at least get the program to mimic the java suite, I changed the type of the OnClick methods to regular methods that do the same thing. I then called the methods within a newly created OnClick() within the lightSwith.cs file itself. I have commented this part of lightSwitch.cs, to help the reader reference back here.  


## Final Notes

All in all, I would say the tutorial about winforms (link above under "Running the tests") was the most helpful. With that, and the simularities of java and C# I put two and two together. I was worried because I'm not too familiar with JPanel and JButton.


###Authors###

Taylor Paul Roberts and credit to Dr. James Buffenbarger for the java suite the program was ported from and helpful tutorial links!


