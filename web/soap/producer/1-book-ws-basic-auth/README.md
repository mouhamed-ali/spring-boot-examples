# Project Title

SOAP web service server + Basic Authentication

## Overview

In this example we will use spring ws to build a simple soap webservice then we gonna use spring security to secure its endpoints
by using a basic authentication.

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
java -jar target/1-book-ws-basic-auth-0.0.1-SNAPSHOT.jar
```

or using the spring boot maven plugin :

```
mvn spring-boot:run
```

### Built With

[Maven](https://maven.apache.org/) v3.6.0 - Dependency Management


### Running the tests

You can get the wsdl file using this command :
```
curl -i client:password http://localhost:8080/ws/library/books.wsdl
```

Or by typing this url in your browser (use client/password as login/password) :
```
http://localhost:8080/ws/library/books.wsdl
```

to test the GetBook endpoint you can build your own request otherwise you can use the soapui project located in the test resources.

## Authors

* **Amdouni Mohamed Ali** - *Initial work* - [github](https://github.com/amdouni-mohamed-ali)
