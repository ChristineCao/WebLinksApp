# WebLinksApp

Author: Christine Cao

This is a Java program using standard Java APIs that takes a URL String as input. 
The URL string is the root of a web site and constructs the set of all links on the website. 
Using recursive procedure that processes the graph of web pages that are reachable from the root 
web page until 50 URLs are found or nothing is left to find, placing all links on the Set as variable 
visitedUrlsSet and groupUrlsSet to hold the unique links.

The program validates the input URL String, in the class App.java which contains the main method
takes a URL String as an argument of the program from the command, for example: http://www.google.com
the method public boolean isValidUrl(String url)
return true if the input URL string is valid, otherwise return false.

In the class LinkedContent, the method 
public boolean findContentFromURL(String strLink) 
and method
private boolean findURL(String content)
recursively find the reachable other URLs unitl 50 URLs are found.

The found URLs show as command line output. Exceptions show as command line error. 


I created the three java src files:

App.java            (main class)

LinkedContent.java  (process finding urls)

Constants.java      (to hold constants)


I created the two files for unit tests by using junit 3.8.1

AppTest.java

LinkedContentTest.java


I use the build tool Maven to manage the dependencies (see pom.xml) and compile with Java version "1.8.0_141"

Here are what I did:

In the project root directory which contains:
.

..

.classpath

.project

.settings

pom.xml

src

target


(1) To comile the sources:

	mvn compile
 
(2) To create a jar fie:

	mvn clean package

(3) To run the app:

	java -cp target\links-0.0.1-SNAPSHOT.jar io.christine.links.App <a URL String as an arg>
	
	for example:
	
		java -cp target\links-0.0.1-SNAPSHOT.jar io.christine.links.App http://www.google.com
		
		java -cp target\links-0.0.1-SNAPSHOT.jar io.christine.links.App https://github.com/
		
(4) To run the unit testing:

	mvn test

To run this program, java 8 and mvn need to be installed in your computer.  Please download the zip file links.zip, then unzip it into a folder for example C:\test\links, 
in the directory, 

to run the app:

C:\test\links>java -cp target\links-0.0.1-SNAPSHOT.jar io.christine.links.App http://www.google.com

to run unit testing:

C:\test\links>mvn test
