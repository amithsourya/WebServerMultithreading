# WebServerMultithreading
It is a Web Server which can handle multiple requests simultaneously using multithreading feature of java. Hence no delay in responding to the cients requests. It has two packages namely processing and server. In the processing package it has two classes namely FunctionClass.java and InputProcessor.java. In the server class it has a class called WebServer. The webserver class will host the local host on the system with the given port number. It receives input and sends it to input processor class. The input processor processes the input and invokes the requested function from the function class and gets the output in the form of a string. The input processor class receives the ouput sent by function class and sends it to the webserver class. The webserver class will send the output to the Data Output Stream through the socket to the connected client. Then we can see the ouput on the browser.
