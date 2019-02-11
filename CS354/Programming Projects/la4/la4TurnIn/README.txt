Taylor Paul Roberts
CS354-2
Dr. James Buffenbarger 
la4


This program utilizes the features the data scanning features of Awk to traverse a csv file, and print out desired results in an html format file. In particular, this program scans a csv (comma separated values) file in order to find and print out single family dwelling building permits info amongst a collection of other building permit locations. 

## Getting Started

Once in the directory of the program's contents, simply run the program as follows...

[user]$ ./realDealConversion <name of csv file>.csv > <name of html file>.html

Example:
[user]$ ./realDealConversion.awk bldgPermits.csv > table.html

### Prerequisites

You will need to have Gawk installed from GNU. 

Here is a link to all the gawk downloads 
http://ftp.gnu.org/gnu/gawk/

Here is a guide to expand and unzip the file package under "getting the gawk distribution" skip 1 and 2, and just follow 3. 
ftp://ftp.gnu.org/old-gnu/Manuals/gawk-3.0.3/html_chapter/gawk_20.es.html

## Running the tests

Running tests was fairly simple for this program. I simple changed contents of the awk file, then printed out the results to the console. If Everything in the console looked the way I wanted it, I then directed the output to a new html file to see how the html font I was adding displayed. 

Using my browsers developer options to see the html code of websites helped in asertaining what text to use for html. 

## Special Thanks

I would like to thank Dr. Buffenbarger for referencing chapter 4.7 of the GNU gawk user manual that pretty much gave a regular expression for keeping content that had commas within a cell together. Life saver.

## Authors

Taylor Paul Roberts
