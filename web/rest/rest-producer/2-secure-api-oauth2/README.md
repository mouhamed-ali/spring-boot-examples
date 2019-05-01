# Project Title

Swagger code generator

## Overview

In this example we will show how to implement the Oauth2 authorization using spring security. we gonna configure :

* **The Authorization Server** - the server that provides tokens
* **The Resource Server** - the server that exposes our rest api

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
java -jar target/2-secure-api-oauth2-0.0.1-SNAPSHOT.jar
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
