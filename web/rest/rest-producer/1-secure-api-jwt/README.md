# Project Title

Spring Boot + Spring Security + JWT

## Overview

In this example, We’ll configure Spring Security along with JWT authentication,
and write the APIs to let users login to our application.

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
java -jar target/1-secure-api-jwt-0.0.1-SNAPSHOT.jar
```

or using the spring boot maven plugin :

```
mvn spring-boot:run
```

### Built With

[Maven](https://maven.apache.org/) v3.6.0 - Dependency Management


### Running the tests

I've created a postman collection test. you can find it in the test resources. you must start by the login endpoint then you can consume
other endpoints after providing the received token (you can get it from the login response).

## Authors

* **Amdouni Mohamed Ali** - *Initial work* - [github](https://github.com/amdouni-mohamed-ali)
