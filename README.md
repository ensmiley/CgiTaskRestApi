# CgiTask

Author: Henrik Esmaili, revised 6/4-2024

This README.md is divided into two sections. A short introduction part just going through how to operate the API and a more detailed explanation of the classes and functions making up the API.

______________________________________
Short introduction:

This repo contains an API for checking the ten most frequent words in a string that is passed as an argument, with their frequency. The API is based on the spring framework, written in Java. The API sets up a local host through which you can parse your input. The function accepts Roman letters and numbers, including the Swedish letters Å,Ä and Ö. Here you call the method "/count" after the local host adress to call the count method.


There are two ways to call the API. Either through running the .jar file found in 

out/artifacts/CgiTask_jar/

or running the file "CgiTaskApplication.java" in your local IDE.






This is an example of the input which you can call the API with:

**Input:**
  curl -H "Content.type: text/plain" -X "POST" -d "Katt Hund Banan 1945s were a really good time katt to bönan" http://localhost:8080/count 

 The API will give you the local host port when starting up the .jar file.

 
**Output:**
will be a JSON look-alike string with the word and its respectice frequency:
 {"bönan":2,"katt":2,"a":1,"hund":1,"were":1,"1945s":1,"time":1,"to":1,"äpple":1,"good":1}


Note: An assumption for this function is that numbers and "numbered words" such as "1945s" are assumed to be a counted as a word. The signs such as -,?,! etc will not be included.

Note: Passing an empty string will result in the return "::1" 

________________________________________________________________________________


More Detailed Explanation of each class:


**CGiTaskApplication**:
Main function. Boots up the spring  boot application.


**UserController**:

Conatins the method "getString" which fetches the string parsed through the API call. It then creates a WordFrequency object through UserService class to be able to compute the word frequency.

**UserService**:

creates a WordFrequency object and calls the count method of the object. This will return the JSON look-alike string of word counts.

**WordFrequency**:

A class with a string "input" as its own class parameter. "Input" is the input string gathered from UserController. The WordFrequency class has its own method "count" which calls on two public static classes "calculateFrequencies" and "returnList" belonging to the WordFrequencyUtils class. "count" returns the JSON look-alike string, which is the return value of the API.



**WordFrequencyUtils**:

The class contists of two methods "calculateFrequencies" and "WordFrequencyUtils".The first method returns a sorted list with hashmaps containing the unique words and their frequencies. It removes any prohibiteed characters and then checks for the words, separated by spaces.  "returnList" uses the return value from "calculateFrequencies" to return the ten most frequent words in a JSON look-alike string format.  
 
