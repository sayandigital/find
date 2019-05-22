# find-primes

### The application is divided into below divisions:
1.User Input, gettting an integer n from user.Currently no upper limit validation added but tested with max 20000 as per requirement specification

2.Prime Evaluation and generating a bitset of first n prime numbers

3.Generating the multiplication table

4.Display of the multiplication table -In this for n< 100 will display in console output as well as generate json files
For n>100 will generate json for each prime.

### How to run the application:

1.Clone the application from git using 
  git clone https://github.com/sayandigital/find.git
  
2.Goto the find folder based on the location cloned. Eg-
 cd ~/find
 
 3.Run the command:
  gradle clean
  
  4.Run the command:
     gradle fatJar
     
  5.The jar will be created in the build/libs folder.
  
  6.Create a folder for the json files
  
  Example:
  
  mkdir -p /Users/sayandigital/Downloads/prime/
  
  7.Run the jar with json generation path directory:
  
  java -jar build/libs/java-find-primes-all-1.0-SNAPSHOT.jar /Users/sayandigital/Downloads/prime/
  
 8.Follow the user input instructions.
 
 #### Demo
 
 Enter the number of primes
 
5

May 22, 2019 6:27:08 PM past.FindPrimes generatePrimeMultiplicationTable

INFO: Prime numbers bit generation done0

May 22, 2019 6:27:08 PM past.DisplayPrimes displayPrimes

INFO: Bit Length12

{2, 3, 5, 7, 11}

{"2":[4,6,10,14,22]}

{"3":[6,9,15,21,33]}

{"5":[10,15,25,35,55]}

{"7":[14,21,35,49,77]}

{"11":[22,33,55,77,121]}

May 22, 2019 6:27:09 PM past.FindPrimes generatePrimeMultiplicationTable

INFO: Prime generation display done-247

May 22, 2019 6:27:09 PM past.FindPrimes main

INFO: Time taken in millis-284

