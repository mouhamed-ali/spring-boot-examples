# Project Title

Externalize configuration files of a war application

## Overview

In this example, we will externalize the application.yml and the application-profile.yml files of a spring boot application. Our delivery file is war.

### Prerequisites

Java 8 or above

### Building

After cloning the project, you can build it from source with this command:

```
mvn clean package
```

### Installing

Before you run the application you must place the config files in an another directory of your computer
(you can find this files in resources) then you must initialize a system property or an environment property called CONFIG_DIRECTORY_LOCATION
with the full path of this directory.

### Running the application

you can run the application using a web server like tomcat. If you choose tomcat, you should copy/paste the generated
war target/2-ext-config-files-war.war in {APACHE_HOME}/webapps.

### Built With

[Maven](https://maven.apache.org/) v3.6.0 - Dependency Management


### Running the tests

There is no junit tests in this example. We've created our test in the runner package. We've implemented the Spring’s CommandLineRunner interface
 so after you start the application the test will be executed automatically and you can check the logs after.

You can also check this url -[http://localhost:8080/2-ext-config-files-war/actuator/info](http://localhost:8080/2-ext-config-files-war/actuator/info)- to know the loaded platform.

## Authors

* **Amdouni Mohamed Ali** - *Initial work* - [github](https://github.com/amdouni-mohamed-ali)
