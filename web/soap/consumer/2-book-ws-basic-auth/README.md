# Project Title

Soap basic authentication client

## Overview

This article shows how to use Springs WebServiceTemplate to consume a soap Service secured with Basic Authentication.
The credentials will be encoded and will use the Authorization HTTP Header, in accordance with the specs of the Basic Authentication scheme. An example would look like this:
Authorization: Basic QWxhZGRpbjpvcGVuIHNlc2FtZQ==

In this example we will test the book soap web service. We have already created this service and you can find it at
[web/soap/producer/1-book-ws-basic-auth](https://github.com/amdouni-mohamed-ali/spring-boot-examples/tree/develop/web/soap/producer/1-book-ws-basic-auth).

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
java -jar target/2-book-ws-basic-auth-0.0.1-SNAPSHOT.jar
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
