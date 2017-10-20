Assuming you are in the directory containing this README:

## To clean:
ant -buildfile src/build.xml clean

-----------------------------------------------------------------------
## To compile: modified build file to compile when run command is executed

-----------------------------------------------------------------------
## To run by specifying arguments from command line 
## We will use this to run your code
ant -buildfile src/build.xml run -Darg0=FIRST -Darg1=SECOND -Darg2=THIRD
eg: ant -buildfile src/build.xml run -Darg0=/import/linux/home1/hloya1/input_file/input.txt -Darg1=/import/linux/home1/hloya1/output_file/output.txt -Darg2=0

#Note: 
1. Make sure input.txt is present at appropriate location
2. Output file location and existence doesn't matter but its name should be "<some path>/output.txt"
-----------------------------------------------------------------------

"I have done this assignment completely on my own. I have not copied
it, nor have I given my solution to anyone else. I understand that if
I am involved in plagiarism or cheating I will have to sign an
official form that I have cheated and that this form will be stored in
my official university record. I also understand that I will receive a
grade of 0 for the involved assignment for my first offense and that I
will receive a grade of F for the course for any additional
offense.”

[Date: 10/19/2017]

-----------------------------------------------------------------------
Considering the input file is well formatted and has contents in chronological order.
The output is printed whenever a new traveler is processed by the airport.
Based on what item the traveler is carrying prohibited item count is incremented.
The day count gets incremented whenever a day number other than the current day number is received. If some day number is missing, my code still considers an increment of 1 day not the respective day the airport has moved to.
Whenever a new day is started my code does not reset anything.
So, all calculations are based on total number of travelers, total number of prohibited items and total number of days received till the current point of file reading.
Basically, Recompute average travelers per day and average prohibited items per day then based on them update the current state if required, and then perform the operations.
Output file contains the respective state operation id whenever each traveler is processed.
-----------------------------------------------------------------------