# Project Title

Avoid SSL validation in Spring WebServiceTemplate

## Overview

In this example, we will set up a WebServiceTemplate without the SSL Certificate Validation. So we've used an online https rest service
[https://soap.aspsms.com/aspsmsx2.asmx](https://soap.aspsms.com/aspsmsx2.asmx) to do the test.

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
java -jar target/3-by-pass-ssl-0.0.1-SNAPSHOT.jar
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
