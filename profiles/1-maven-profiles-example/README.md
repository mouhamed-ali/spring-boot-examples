# Project Title

Maven Profiles

## Overview

In this example, we will show you how to use Maven profile to pass different parameters (server or database parameters) for different environments (dev or prod)
and how to build an application per environment.
reference : [https://www.mkyong.com/maven/maven-profiles-example/](https://www.mkyong.com/maven/maven-profiles-example/)
### Prerequisites

Java 8 or above

### Building

After cloning the project, you can build it from source with this command:

```
mvn clean package
```

this will use the default maven profile which is dev. to package the production profile you can
use one of the following commands
```
mvn clean package -P prod
```
```
mvn clean package -D env=prod
```

### Running the application

you can run this application using java -jar, as shown in the following example:

```
java -jar target/1-maven-profiles-example-0.0.1-SNAPSHOT.jar
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
