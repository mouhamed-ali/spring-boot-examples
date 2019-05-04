# Project Title

Swagger code generator

## Overview

In this example, we will show you how to set up and use Properties in Spring via java configuration.
All properties files in this example will be loaded from an external directory. You can find the project config
files in the resources/configuration directory.

### Prerequisites

Java 8 or above

### Building

After cloning the project, you can build it from source with this command:

```
mvn clean package
```

* **1** - copy/paste config files from the resources/configuration directory to a new directory in your file system
* **2** - change the value of APP_HOME property in this classes [PropertiesApplication (sources) , InitTest(tests)] with
your full path directory.

### Built With

[Maven](https://maven.apache.org/) v3.6.0 - Dependency Management


### Running the tests

To run the junit tests :

```
mvn test
```

Or you can use the test in the runner package. We've implemented the Spring’s CommandLineRunner interface
so after you start the application the test will be executed automatically and you can check the logs after.


## Authors

* **Amdouni Mohamed Ali** - *Initial work* - [github](https://github.com/amdouni-mohamed-ali)
