# Project Title

Swagger api documentation

## Overview

In this example, we will build an api rest documentation using the swagger annotations

### References
https://docs.spring.io/spring-boot/docs/current/reference/html/common-application-properties.html<br/>
https://docs.spring.io/spring-boot/docs/current/reference/html/howto-database-initialization.html<br/>
https://www.baeldung.com/jackson-bidirectional-relationships-and-infinite-recursion<br/>
https://codeboje.de/jackson-java-8-datetime-handling<br/>
https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#repositories.query-methods.details<br/>

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
java -jar target/3-swagger-api-documentation-0.0.1-SNAPSHOT.jar
```

or using the spring boot maven plugin :

```
mvn spring-boot:run
```

### Running the application

After running the application check this urls :

```
http://localhost:8080/swagger-ui.html
```


```
http://localhost:8080/v2/api-docs
```

### Built With

[Maven](https://maven.apache.org/) v3.6.0 - Dependency Management

## Authors

* **Amdouni Mohamed Ali** - *Initial work* - [github](https://github.com/amdouni-mohamed-ali)
