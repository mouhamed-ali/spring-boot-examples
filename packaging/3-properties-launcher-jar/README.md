# Project Title

Load external libraries in a spring boot application

## Overview

In this example, we will configure our spring boot archive classpath. we will configure the classpath and the main class via jvm properties.
This model is often more flexible and more amenable to creating well-behaved OS-level services than a model based on executable jars.

### References
https://docs.spring.io/spring-boot/docs/current/reference/html/executable-jar.html#executable-jar-launching<br/>
https://docs.spring.io/spring-boot/docs/current-SNAPSHOT/reference/htmlsingle/#build-tool-plugins-maven-packaging-optional-params<br/>
https://docs.spring.io/spring-boot/docs/current/reference/html/executable-jar.html<br/>
https://github.com/spring-projects/spring-boot/blob/master/spring-boot-project/spring-boot-tools/spring-boot-loader/src/main/java/org/springframework/boot/loader/PropertiesLauncher.java<br/>
https://github.com/spring-projects/spring-boot/blob/master/spring-boot-project/spring-boot-tools/spring-boot-loader/src/main/java/org/springframework/boot/loader/PropertiesLauncher.java<br/>

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
