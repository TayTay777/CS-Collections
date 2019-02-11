#!/bin/gprolog --consult-file



:- include('data.pl').
:- include('uniq.pl').


% Compares the first and second time slot hours and minutes

lte(time(FirstHour, _),  time(SecondHour, _))  :- FirstHour < SecondHour.
lte(time(Hour, FirstMin), time(Hour, SecondMin)) :- FirstMin =< SecondMin. 

% not finished

people([ann,bob,carla]).

main :- findall(Slot, meet(Slot), Slots),
        uniq(Slots, Uniq),
        write(Uniq), nl, halt.

:- initialization(main).

