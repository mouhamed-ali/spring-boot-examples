# Project Title

calculator soap web service consumer


## Overview

In this example we will learn how to consume a SOAP web services using spring boot soap client and auto client proxy class generation using JAXB maven plugin.
The WebServiceTemplate is the core class for client-side Web service access in Spring-WS. It contains methods for sending Source objects, and receiving response messages as either Source or Result. Additionally, it can marshal objects to XML before sending them across a transport, and unmarshal any response XML into an object again.
So the JAXB will be used to marshall/unmarshall our xml request/response.

In this example we will use a public soap web service used to do some basic calculation. you can find it at :
* http://www.dneonline.com/calculator.asmx?wsdl

I will download the wsdl ,save it in a file and then copy it in the resources of the project (it will be used bu jaxb).

I've created a soap interceptor so we can log all of our soap requests and responses.

### Prerequisites

Java 8 or above

### Building

After cloning the project, you can build it from source with this command:

```
mvn clean package
```

### Running the application

you can run this application using java -jar, as shown in the following example:

```
java -jar target/1-calculator-ws-0.0.1-SNAPSHOT.jar
```

or using the spring boot maven plugin :

```
mvn spring-boot:run
```

### Built With

[Maven](https://maven.apache.org/) v3.6.0 - Dependency Management


### Running the tests

There is no junit tests in this example. We've created our test in the runner package. We've implemented the Spring’s CommandLineRunner interface
 so after you start the application the test will be executed automatically and you can check the logs after.

## Authors

* **Amdouni Mohamed Ali** - *Initial work* - [github](https://github.com/amdouni-mohamed-ali)
