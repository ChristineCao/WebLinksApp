# WebLinksApp

Author: Christine Cao

This is a Java program that takes a URL String as input. 
The URL string is the root of a web site and constructs the set of all links on the website. 
Using recursive procedure that processes the graph of web pages that are reachable from the root web page, 
placing all links on the Set as variable visitedUrlsSet and groupUrlsSet to hold the links.

I created the three java src files: 
App.java            (main class) 
LinkedContent.java  (process finding urls)
Constants.java      (to hold constants)

I created the two files for unit tests by using junit 3.8.1
AppTest.java
LinkedContentTest.java

I use the build tool Maven to manage the dependencies. See pom.xml

Here are what I did:

in the project root directory:

(1) To comile the sources: 
	mvn compile
 
(2) To create a jar fie
	mvn clean package

(3) To run the app 
	java -cp target\links-0.0.1-SNAPSHOT.jar io.christine.links.App http://www.google.com 

(4) To run the unit testing:
	mvn test
