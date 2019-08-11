# Project Title

Hikari connection pool

## Overview

In this example, we will configure an Hikari connection pool using spring boot.

### References
https://www.baeldung.com/spring-boot-hikari<br/>
https://github.com/brettwooldridge/HikariCP#configuration-knobs-baby<br/>
https://javadeveloperzone.com/spring-boot/spring-boot-common-dbcp2-connection-pool/<br/>
https://www.javainterviewpoint.com/spring-boot-jdbc-connection-pool-example/<br/>
https://commons.apache.org/proper/commons-dbcp/configuration.html<br/>

### Prerequisites

Java 8 or above

### Building

After cloning the project, you can build it from source with this command:

```
mvn clean package
```

### Installing

you can run this application using java -jar, as shown in the following example:

```
java -jar target/1-connection-pool-hikari-0.0.1-SNAPSHOT.jar
```

or using the spring boot maven plugin :

```
mvn spring-boot:run
```

### Running the tests

Use this command to run the junit tests :

```
mvn test
```

### Built With

[Maven](https://maven.apache.org/) v3.6.0 - Dependency Management

## Authors

* **Amdouni Mohamed Ali** - *Initial work* - [github](https://github.com/amdouni-mohamed-ali)
