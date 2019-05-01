# Project Title

Override your application datasource for testing

## Overview

In this example, we’ll show you how to override your application configuration to be able to execute the tests.
for example, how to override your jndi datasource with an in memory datasource so you can start your tests otherwise you will
 have a datasource not found exception.

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
java -jar target/1-override-project-config-0.0.1-SNAPSHOT.jar
```

or using the spring boot maven plugin :

```
mvn spring-boot:run
```

### Built With

[Maven](https://maven.apache.org/) v3.6.0 - Dependency Management


### Running the tests

* **To test the application datasource**
There is no junit tests in this example. We've created our test in the runner package. We've implemented the Spring’s CommandLineRunner interface
 so after you start the application the test will be executed automatically and you can check the logs after.

* **To test the in memory datasource**
```
mvn test
```

## Authors

* **Amdouni Mohamed Ali** - *Initial work* - [github](https://github.com/amdouni-mohamed-ali)
