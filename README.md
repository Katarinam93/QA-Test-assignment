# QA-Test-assignment

## This assignment is divided in two parts. 

### The first one is manual testing which consists of:

* Two exploratory testing tasks for two different sites
    * [007Museum](http://www.007museum.com "007museum.com")
    *  [LibertyVan](http://www.libertyvan.com "libertyvan site")
* Test case writing task for the site [WalmartContacts](https://www.walmartcontacts.com/Lens/614 "Clariti 1-day Sphere 90pk")
* Create Suggestions task for the site [TR Group](https://www.trgroup.co.nz "Trauck & trailer rental group")

**All of the files for the first part are in the folder Manual Testing**
***
***

## The other Test Automation assignment with Selenium WebDriver tests and using JUnit5 and Maven.

# _Selenium Instalation_
* Step 1 - Install Java on your computer.
* Step 2 - Install Eclipse IDE.
* Step 3 - Download the Selenium Java Client Driver. 

# _Tools_
## Selenium
Selenium Webdriver is a framework that allows automation testing. It allows testing across various browsers. It can execute multiple tests over multiple browsers on multiple OS. Web Driver makes it possible to write a test script in Linux and run it in Windows. There are multiple programming languages that are supported by Web Driver such as Java, Python, Ruby, .Net, PHP to create test scripts.



## Junit5
_JUnit 5 = JUnit Platform + JUnit Jupiter + JUnit Vintage_
The JUnit Platform serves as a foundation for launching testing frameworks on the JVM. It also defines the TestEngine API for developing a testing framework that runs on the platform.

JUnit 5 requires Java 8 (or higher) at runtime. However, you can still test code that has been compiled with previous versions of the JDK.

## log4j
_Logging Utility for Java_

A reliable, fast and flexible logging framework (APIs) written in Java, which is distributed under the Apache Software Licens

## Maven
Maven is a powerful project management tool that is based on POM (project object model). It is used for projects build, dependency and documentation.
All of the required dependencies used in the project are imported via maven.

***
### To make the tests runnable via command line type: 

_**mvn test**_

Or if you want only a specific test to run:
* _mvn test -Dtest=Test1_
* _mvn test -Dtest=Test2_
* _mvn test -Dtest=Test3_

### To make the browsers changable go to:
_**./Selenium/src/main/java/setup/file.properties**_ and change the name of the browser
***

# Design Patern
**Page Object Model (POM)** is a design pattern, popularly used in test automation that creates Object Repository for web UI elements. The advantage of the model is that it reduces code duplication and improves test maintenance.

Under this model, for each web page in the application, there is a corresponding Page Class

