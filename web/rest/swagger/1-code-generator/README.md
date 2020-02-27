# Project Title

Swagger code generator

## Overview

This is an example of how we can use the Swagger Codegen maven plugin [swagger-codegen-maven-plugin], which allows generation of API client libraries. In this example we
will generate only the model classes (the plugin configuration can be found in pom.xml) using the codegen maven plugin then we gonna build a method that takes
a json string as input and provides a java object as output.

### Prerequisites

Java 8 or above

### Building

After cloning the project, you can build it from source with this command:

```
mvn clean package
```

### Built With

[Maven](https://maven.apache.org/) v3.6.0 - Dependency Management


### Running the tests

```
mvn test
```

## Authors

* **Amdouni Mohamed Ali** - *Initial work* - [github](https://github.com/amdouni-mohamed-ali)
