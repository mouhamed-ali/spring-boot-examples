# Project Title

Spring boot jpa example

## Overview

In this example, we will use show you how to use and configure spring jpa with spring boot. the used database is H2.

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
java -jar target/1-persistence-context-0.0.1-SNAPSHOT.jar
```

or using the spring boot maven plugin :

```
mvn spring-boot:run
```

### Built With

[Maven](https://maven.apache.org/) v3.6.0 - Dependency Management


### Running the tests

We've created our test in the runner package. We've implemented the Spring’s CommandLineRunner interface
 so after you start the application the test will be executed automatically and you can check the logs after.

junit tests can be launched using this command :
```
mvn test
```

## Authors

* **Amdouni Mohamed Ali** - *Initial work* - [github](https://github.com/amdouni-mohamed-ali)
