# CgiTask

Author: Henrik Esmaili, revised 6/4-2024

This README.md is divided into two sections. A short introduction part just going through how to operate the API and a more detailed explanation of the classes and functions making up the API.

______________________________________
Short introduction:

This repo is contains an API for checking the ten most frequent words in a string that is passed as an argument, with their frequency. The API sets up a local host through which you can parse your input. The function accepts Roman letters and numbers, including the Swedish letters Å,Ä and Ö.


There are two ways to call the API. Either through running the .jar file found in 

out/artifacts/CgiTask_jar/

or running the file "CgiTaskApplication.java" in your local IDE.






This is an example of the input which you can call the API with:

**Input:**
  curl -H "Content.type: text/plain" -X "POST" -d "Katt Hund Banan 1945s were a really good time katt to bönan" http://localhost:8080/count 

 The API will give you the local host port when starting up the .jar file.

 
**Output:**
will be a JSON string with the word and its respectice frequency:
 {"bönan":2,"katt":2,"a":1,"hund":1,"were":1,"1945s":1,"time":1,"to":1,"äpple":1,"good":1}


Note: An assumption for this function is that numbers and "numbered words" such as "1945s" are assumed to be a counted as a word. The signs such as -,?,! etc will not be included.

________________________________________________________________________________


More Detailed Explanation of each class:
 
 
