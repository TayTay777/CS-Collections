#!/bin/gprolog --consult-file

:- include('data.pl').

% Your code goes here.


:- include('data.pl').



% returns true for the person if inside the begin and end time range. 

meetone(Person, slot(time(FHour, FMin, AMPMOne), time(LHour, LMin, AMPMTwo)))
:- free(Person, slot(time(FH, FM, APOne), time(LH, LM, APTwo))),
   FH*60 + FM =< LHour*60 + LMin,
   LH*60 + LM >= FHour*60 + FMin,
   AMPMOne == 'am',
   AMPMTwo == 'am'.

% prints out names that are within the time window.

main :- findall(Person,
		meetone(Person,slot(time(9,0,am),time(10,0,am))),
		People),
	write(People), nl, halt.

:- initialization(main).
