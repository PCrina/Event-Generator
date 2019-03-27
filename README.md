# Event-Generator
Implementing a parallel processing system for events coming from multiple sources.
There are several events generators of different types (an event requiring the calculation of a value). When an event is generated, it is added to a queue of events. Events in the queue are then processed by workers in a pool,the results being put into a data structure specific to the type of event. 

There are 4 types of events:
1) PRIME: calculates the largest prime number less than or equal to a given N
2) FACT: calculates the largest number that has a factorial less than or equal to a given N
3) SQUARE: calculates the largest number whose perfect square is less than or equal to a given N
4) FIB: calculates the largest number for which the corresponding value in the Fibbonaci sequence is less than or equal to N

Parameters
- queue size
- the number of events in each file 
- the names of files containing the events to be generated

Each file corresponds to an event generator and looks like:
```
interval_timp1,eveniment1,N1
interval_timp2,eveniment2,N2
[...]
```

The results of the events will be written each in one file, one value per line. The program will have 4 output files:
- PRIME.out
- FACT.out
- SQUARE.out
- FIB.out

Example:
```
input1
440,FIB,67
70,FIB,57
50,FIB,69
190,SQUARE,25
130,SQUARE,77

input2
500,FIB,24
340,FIB,90
160,SQUARE,100
200,PRIME,67
280,FACT,27

FIB.out
8 
10
10
10
11

SQUARE.out
5
8
10

PRIME.out
67

FACT.out
4
```
To run the app:
```
java -jar eventqueue.jar queue_size file_events file1 file2 [...]
```
