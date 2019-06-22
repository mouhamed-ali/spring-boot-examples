# Project Title

Externalize the classpath of a spring boot application

## Overview

In this example, we will configure our spring boot archive using a custom configuration we will configure the classpath the main class via jvm properties.
This model is often more flexible and more amenable to creating well-behaved OS-level services than a model based on executable jars.

### References
https://docs.spring.io/spring-boot/docs/current/reference/html/executable-jar.html#executable-jar-launching
https://docs.spring.io/spring-boot/docs/current-SNAPSHOT/reference/htmlsingle/#build-tool-plugins-maven-packaging-optional-params(https://docs.spring.io/spring-boot/docs/current-SNAPSHOT/reference/htmlsingle/#build-tool-plugins-maven-packaging-optional-params)
https://docs.spring.io/spring-boot/docs/current/reference/html/executable-jar.html(https://docs.spring.io/spring-boot/docs/current/reference/html/executable-jar.html)
https://github.com/spring-projects/spring-boot/blob/master/spring-boot-project/spring-boot-tools/spring-boot-loader/src/main/java/org/springframework/boot/loader/PropertiesLauncher.java(https://github.com/spring-projects/spring-boot/blob/master/spring-boot-project/spring-boot-tools/spring-boot-loader/src/main/java/org/springframework/boot/loader/PropertiesLauncher.java)
https://github.com/spring-projects/spring-boot/blob/master/spring-boot-project/spring-boot-tools/spring-boot-loader/src/main/java/org/springframework/boot/loader/PropertiesLauncher.java(https://github.com/spring-projects/spring-boot/blob/master/spring-boot-project/spring-boot-tools/spring-boot-loader/src/main/java/org/springframework/boot/loader/PropertiesLauncher.java)

### Prerequisites

Java 8 or above

### Building

After cloning the project, you can build it from source with this command:

```
mvn clean package
```

### Installing

There's a script to build and run the application. you can find it in the build directory.
To run it use this :

```
cd build
sh package.sh
```

### Built With

[Maven](https://maven.apache.org/) v3.6.0 - Dependency Management

## Authors

* **Amdouni Mohamed Ali** - *Initial work* - [github](https://github.com/amdouni-mohamed-ali)
