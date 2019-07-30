# Project Title

Mock rest and database queries

## Overview

In this example, we will build an api rest application using the spring framework. then, we will mock all database and rest 
queries so when we build our application (from a jenkins job for example) it will works without errors.

### References
https://www.baeldung.com/spring-boot-tomcat-connection-pool<br/>
https://www.javainterviewpoint.com/spring-boot-jdbc-connection-pool-example/<br/>
https://javadeveloperzone.com/spring-boot/spring-boot-common-dbcp2-connection-pool/<br/>
https://commons.apache.org/proper/commons-dbcp/configuration.html<br/>
https://commons.apache.org/proper/commons-dbcp/configuration.html<br/>
http://masterspringboot.com/configuration/web-server/configuring-tomcat-connection-pool-on-spring-boot<br/>


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
java -jar target/2-test-rest-api-mockito-0.0.1-SNAPSHOT.jar
```

or using the spring boot maven plugin :

```
mvn spring-boot:run
```

### Running the application

After running the application you can use the soapui collection (in the resources folder) to call the application
rest endpoints.

### Running the tests

Use this command to run the junit tests :

```
mvn test
```

you can find some load tests in the soapui collection

### Built With

[Maven](https://maven.apache.org/) v3.6.0 - Dependency Management

## Authors

* **Amdouni Mohamed Ali** - *Initial work* - [github](https://github.com/amdouni-mohamed-ali)
