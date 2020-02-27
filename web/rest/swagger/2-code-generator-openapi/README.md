# Project Title

OpenAPI code generator

## Overview

This is an example of how we can use the OpenAPI Codegen maven plugin [openapi-generator-maven-plugin], which allows generation of API client libraries. In this example we
will generate only the model classes (the plugin configuration can be found in pom.xml).<br/>
OpenAPI Generator is a fork of swagger-codegen between version 2.3.1 and 2.4.0. This community-driven version called
"OpenAPI Generator" provides similar functionalities and can be used as drop-in replacement. This guide explains the major
differences in order to help you with the migration.
source : [https://openapi-generator.tech/docs/swagger-codegen-migration](https://openapi-generator.tech/docs/swagger-codegen-migration)

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

run this command :
```
mvn package
```
then check the classes generation in target/generated-sources.

## Authors

* **Amdouni Mohamed Ali** - *Initial work* - [github](https://github.com/amdouni-mohamed-ali)
