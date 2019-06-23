# Project Title

Externalize all the dependencies of a spring boot project. these extracted dependencies will be loaded
as external libraries using a config file (loader.properties).

## Overview

In this example, we will configure our spring boot archive to load all dependencies from an external directory even the spring framework jars.
We will create a properties file named loader.properties to initialize this configuration.

### References
https://docs.spring.io/spring-boot/docs/current/maven-plugin/examples/exclude-dependency.html__
https://github.com/spring-projects/spring-boot/blob/master/spring-boot-project/spring-boot-tools/spring-boot-loader/src/it/executable-props-lib/loader.properties__
https://docs.spring.io/spring-boot/docs/current/reference/html/executable-jar.html#executable-jar-property-launcher-features__
https://github.com/spring-projects/spring-boot/blob/master/spring-boot-project/spring-boot-tools/spring-boot-loader/src/main/java/org/springframework/boot/loader/PropertiesLauncher.java__

### Prerequisites

Java 8 or above

### Building

After cloning the project, you can build it from source with this command:

```
mvn clean package
```

### Installing

There's two scripts to build and run the application. you can find them in the build directory.
To run the first one, use this (this will load config from jvm parameters):

```
cd build
bash build.sh
```

To run the second, use this (this will load config from a properties file):

```
cd build
bash build-loader.sh
```

### Built With

[Maven](https://maven.apache.org/) v3.6.0 - Dependency Management

## Authors

* **Amdouni Mohamed Ali** - *Initial work* - [github](https://github.com/amdouni-mohamed-ali)
