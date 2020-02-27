# Spring Boot Examples

```
  .   ____          _            __ _ _
 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
  '  |____| .__|_| |_|_| |_\__, | / / / /
 =========|_|==============|___/=/_/_/_/
 :: Spring Boot ::        (v2.1.4.RELEASE)

```

This repository contains example projects for the different Spring boot modules to showcase the framework
and how to use the features provided by the different modules.

We have separate folders for each module :

```
spring4-examples
│
└─── caching
└─── commun
└─── emails
|    └─── gmail
|    └─── send-grid
└─── jdbc
|    └─── 1-connection-pool-hikari
|    └─── 2-connection-pool-dbcp-tomcat
└─── multithreading
|    └─── 1-async-method
└─── orm
|    └─── jpa
|    |    └─── 1-persistence-context
|    |    └─── 2-persistnce-context-multi-ds
|    └─── orm-entities
|    |    └─── customer-entities
|    |    └─── employee-entities
|    |    └─── github-user-entities
└─── packaging
|    └─── 1-ext-config-files-jar
|    └─── 2-ext-config-files-war
|    └─── 3-properties-launcher-jar
|    └─── 4-properties-launcher-loader-config
└─── profiles
|    └─── 1-maven-profiles-example
|    └─── 2-spring-profiles-example
└─── properties
|    └─── 1-load-internal-prop
|    └─── 2-load-external-prop
└─── testing
|    └─── 1-override-project-config
|    └─── 2-test-rest-api-mockito
└─── web
|    └─── http
|    |    └─── 1-jvm-by-pass-ssl
|    └─── rest
|    |    └─── rest-consumer
|    |    |    └─── 1-by-pass-ssl
|    |    └─── rest-producer
|    |    |    └─── 1-secure-api-jwt
|    |    |    └─── 2-secure-api-oauth2
|    |    └─── swagger
|    |    |    └─── 1-code-generator
|    |    |    └─── 2-code-generator-openapi
|    |    |    └─── 3-swagger-api-documentation
|    └─── soap
|    |    └─── consumer
|    |    |    └─── 1-calculator-ws
|    |    |    └─── 2-book-ws-basic-auth
|    |    |    └─── 3-by-pass-ssl
|    |    └─── producer
|    |    |    └─── 1-book-ws-basic-auth
```

### Prerequisites

To create your development environment, you will need to :

- install java 8 (or above)
- install maven
- install git to clone the project
- you favorite IDE (i'm using intellij) 
- install docker on your machine

### Installing

To clone the project, run this command :

```shell script
$ git clone https://github.com/amdouni-mohamed-ali/spring-boot-examples.git
$ cd spring-boot-examples
```

And run this to make that the project compiles :

```shell script
$ mvn clean install
```

If everything turns out alright, you should end up with this result :

```log
[INFO] ------------------------------------------------------------------------
[INFO] Reactor Summary:
[INFO] 
[INFO] spring-boot-examples 0.0.1-SNAPSHOT ................ SUCCESS [  0.878 s]
[INFO] commun 0.0.1-SNAPSHOT .............................. SUCCESS [  0.085 s]
[INFO] profiles 0.0.1-SNAPSHOT ............................ SUCCESS [  0.022 s]
[INFO] 1-maven-profiles-example 0.0.1-SNAPSHOT ............ SUCCESS [  1.259 s]
[INFO] 2-spring-profiles-example 0.0.1-SNAPSHOT ........... SUCCESS [  0.154 s]
[INFO] caching 0.0.1-SNAPSHOT ............................. SUCCESS [  0.020 s]
[INFO] orm 0.0.1-SNAPSHOT ................................. SUCCESS [  0.022 s]
[INFO] orm-entities 0.0.1-SNAPSHOT ........................ SUCCESS [  0.018 s]
[INFO] customer-entities 0.0.1-SNAPSHOT ................... SUCCESS [  0.281 s]
[INFO] jpa 0.0.1-SNAPSHOT ................................. SUCCESS [  0.039 s]
[INFO] 1-persistence-context 0.0.1-SNAPSHOT ............... SUCCESS [  4.738 s]
[INFO] employee-entities 0.0.1-SNAPSHOT ................... SUCCESS [  0.085 s]
[INFO] 2-persistnce-context-multi-ds 0.0.1-SNAPSHOT ....... SUCCESS [  4.805 s]
[INFO] github-user-entities 0.0.1-SNAPSHOT ................ SUCCESS [  0.222 s]
[INFO] testing 0.0.1-SNAPSHOT ............................. SUCCESS [  0.009 s]
[INFO] 1-override-project-config 0.0.1-SNAPSHOT ........... SUCCESS [  3.222 s]
[INFO] 2-test-rest-api-mockito 0.0.1-SNAPSHOT ............. SUCCESS [  7.045 s]
[INFO] web 0.0.1-SNAPSHOT ................................. SUCCESS [  0.017 s]
[INFO] soap 0.0.1-SNAPSHOT ................................ SUCCESS [  0.010 s]
[INFO] consumer 0.0.1-SNAPSHOT ............................ SUCCESS [  0.009 s]
[INFO] 1-calculator-ws 0.0.1-SNAPSHOT ..................... SUCCESS [  0.870 s]
[INFO] 3-by-pass-ssl 0.0.1-SNAPSHOT ....................... SUCCESS [  0.597 s]
[INFO] 2-book-ws-basic-auth 0.0.1-SNAPSHOT ................ SUCCESS [  0.432 s]
[INFO] producer 0.0.1-SNAPSHOT ............................ SUCCESS [  0.010 s]
[INFO] 1-book-ws-basic-auth 0.0.1-SNAPSHOT ................ SUCCESS [  0.322 s]
[INFO] rest 0.0.1-SNAPSHOT ................................ SUCCESS [  0.094 s]
[INFO] swagger 0.0.1-SNAPSHOT ............................. SUCCESS [  0.009 s]
[INFO] 1-code-generator 0.0.1-SNAPSHOT .................... SUCCESS [  1.453 s]
[INFO] 2-code-generator-openapi 0.0.1-SNAPSHOT ............ SUCCESS [  2.095 s]
[INFO] 3-swagger-api-documentation 0.0.1-SNAPSHOT ......... SUCCESS [  0.847 s]
[INFO] rest-consumer 0.0.1-SNAPSHOT ....................... SUCCESS [  0.045 s]
[INFO] 1-by-pass-ssl 0.0.1-SNAPSHOT ....................... SUCCESS [  0.265 s]
[INFO] rest-producer 0.0.1-SNAPSHOT ....................... SUCCESS [  0.009 s]
[INFO] 1-secure-api-jwt 0.0.1-SNAPSHOT .................... SUCCESS [  0.908 s]
[INFO] 2-secure-api-oauth2 0.0.1-SNAPSHOT ................. SUCCESS [  0.385 s]
[INFO] http 0.0.1-SNAPSHOT ................................ SUCCESS [  0.006 s]
[INFO] 1-jvm-by-pass-ssl 0.0.1-SNAPSHOT ................... SUCCESS [  0.346 s]
[INFO] multithreading 0.0.1-SNAPSHOT ...................... SUCCESS [  0.027 s]
[INFO] 1-async-method 0.0.1-SNAPSHOT ...................... SUCCESS [  0.129 s]
[INFO] properties 1.0-SNAPSHOT ............................ SUCCESS [  0.017 s]
[INFO] 1-load-internal-prop 1.0-SNAPSHOT .................. SUCCESS [  1.868 s]
[INFO] 2-load-external-prop 1.0-SNAPSHOT .................. SUCCESS [  1.882 s]
[INFO] packaging 0.0.1-SNAPSHOT ........................... SUCCESS [  0.026 s]
[INFO] 1-ext-config-files-jar 0.0.1-SNAPSHOT .............. SUCCESS [  0.073 s]
[INFO] 2-ext-config-files-war 0.0.1-SNAPSHOT .............. SUCCESS [  2.566 s]
[INFO] 3-properties-launcher-jar 0.0.1-SNAPSHOT ........... SUCCESS [  1.658 s]
[INFO] 4-properties-launcher-loader-config 0.0.1-SNAPSHOT . SUCCESS [  1.137 s]
[INFO] jdbc 0.0.1-SNAPSHOT ................................ SUCCESS [  0.021 s]
[INFO] 1-connection-pool-hikari 0.0.1-SNAPSHOT ............ SUCCESS [  9.167 s]
[INFO] 2-connection-pool-dbcp-tomcat 0.0.1-SNAPSHOT ....... SUCCESS [  8.633 s]
[INFO] emails 0.0.1-SNAPSHOT .............................. SUCCESS [  0.012 s]
[INFO] gmail 0.0.1-SNAPSHOT ............................... SUCCESS [  0.188 s]
[INFO] send-grid 0.0.1-SNAPSHOT ........................... SUCCESS [  0.204 s]
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  59.984 s
[INFO] Finished at: 2020-02-27T17:01:11+01:00
[INFO] ------------------------------------------------------------------------
```

You'll find a readme file in each module and project to show you how you can deploy the example and how to test it.

## Built With

* [Java](https://openjdk.java.net/) - openjdk version "1.8.0_232"
* [Maven](https://maven.apache.org/) - Dependency Management (version 3.6.0)
* [Intellij](https://www.jetbrains.com/) - IDE (version 11.0.5)
* [Docker](https://www.docker.com/) - To create, deploy, and run applications using containers

## Authors

* **Mohamed Ali AMDOUNI** - *Initial work* - [github](https://github.com/amdouni-mohamed-ali)

![spring-boot](https://user-images.githubusercontent.com/16627692/75462360-6ef00400-5984-11ea-860f-0869802c3521.png)

