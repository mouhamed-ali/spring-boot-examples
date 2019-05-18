# Project Title

Spring Profiles

## Overview

In this example, we will show you how to use Spring profiles to pass different parameters (server or database parameters) for different environments (dev or prod)
and how to build an application per environment.

### Prerequisites

Java 8 or above

### Building

After cloning the project, you can build it from source with this command:

```
mvn clean package
```

this will use the default spring profile which is development. to package the production profile you can
use one of the following commands :

```
mvn clean package -D spring.active.profile=production
```

### Running the application

you can run this application using java -jar, as shown in the following example:

```
java -jar target/2-spring-profiles-example-0.0.1-SNAPSHOT.jar
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
