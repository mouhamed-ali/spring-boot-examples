# Project Title

Externalize configuration files of a jar application

## Overview

In this example, we will externalize the application.yml and the application-profile.yml files of a spring boot application. Our delivery file is jar.

### Prerequisites

Java 8 or above

### Building

After cloning the project, you can build it from source with this command:

```
mvn clean package
```

### Installing

Before you run the application you must place the config files in an another directory of your computer
(you can find this files in resources/config) then you must change the SPRING_CONFIG_NAME property in the Application.java file
with the full path of this directory.

### Running the application

you can run this application using java -jar, as shown in the following example:

```
java -jar target/1-ext-config-files-0.0.1-SNAPSHOT.jar
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
