# WebLinksApp

Author: Christine Cao

This is a Java program using standard Java APIs that takes a URL String as input. 
The URL string is the root of a web site and constructs the set of all links on the website. 
A recursive procedure is used to process the graph of URLs that are reachable from the root 
web page until 50 URLs are found or nothing is left to find, placing all links from the Set as variables 
visitedUrlsSet and groupUrlsSet to hold unique links.

The program validates the input URL String, in the class App.java which contains the main method
takes a URL String as an argument of the program from the command, for example: http://www.google.com
the method public boolean isValidUrl(String url)
returns true if the input URL string is valid, otherwise returns false.

In the class LinkedContent, the method 
public boolean findContentFromURL(String strLink) 
and method
private boolean findURL(String content)
recursively find reachable URLs until 50 URLs are found.

The URLs found show as command line output. Exceptions show as command line errors. 


There are three Java source files:

App.java            (main class)

LinkedContent.java  (process finding urls)

Constants.java      (to hold constants)


There are two Java unit tests files. Unit testing is done using JUnit 3.8.1

AppTest.java

LinkedContentTest.java

I use the build tool Maven to manage the dependencies and compile with Java version "1.8.0_141"

The project layout looks like this

.

..

.classpath

.project

.settings

pom.xml

src

target


(1) To compile the sources:

	mvn compile
 
(2) To create a jar file:

	mvn clean package

(3) To run the app:

	java -cp target\links-0.0.1-SNAPSHOT.jar io.christine.links.App <a URL String as an arg>
	
	for example:
	
		java -cp target\links-0.0.1-SNAPSHOT.jar io.christine.links.App http://www.google.com
		
		java -cp target\links-0.0.1-SNAPSHOT.jar io.christine.links.App https://github.com/
		
(4) To run the unit testing:

	mvn test 

The steps to run this program in Windows:

1. Download Java  from the link:

	http://www.oracle.com/technetwork/java/javase/downloads/jre8-downloads-2133155.html

2. Download Maven from the link:

	https://maven.apache.org/download.cgi?Preferred=ftp%3A%2F%2Fmirror.reverse.net%2Fpub%2Fapache%2F


3. Define Environment System variables %JAVA_HOME% and %MAVEN_HOME%  


4. Set path into your system path:

	%JAVA_HOME%\bin and %MAVEN_HOME%\bin

5. Download the zip file links.zip

6. Unzip the file links.zip into a folder for example C:\test 

7. In the directory C:\test\links to run the app:

	C:\test\links>java -cp target\links-0.0.1-SNAPSHOT.jar io.christine.links.App aURLString
	
	for example:
	
	C:\test\links>java -cp target\links-0.0.1-SNAPSHOT.jar io.christine.links.App http://www.google.com

8. In the directory C:\test\links to run unit testing:

	C:\test\links>mvn test
	
