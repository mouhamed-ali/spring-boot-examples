# Project Title

Spring boot jpa multiple data sources example

## Overview

In this example, we will use show you how to use and configure multiple date sources spring boot jpa. the used databases are H2 and postgres.

### Building

After cloning the project, you can build it from source with this command:

```shell script
$ mvn clean package
```

### Running the application

Before running the app you have to configure a postgres database. Check the `application-dev.yml` for the connexion parameters. If you already don't have
a database , it doesn't matter, you can run this command to create a new postgres container :

```shell script
$ docker run --rm -d --name postgres -p 15432:5432 -e POSTGRES_USER='admin' -e POSTGRES_PASSWORD='password' -e POSTGRES_DB='postgres' postgres:9.6.9 postgres -c listen_addresses=*
```

or this one which uses volumes (in case you want to store your data) :

```shell script
$ docker run --rm -d --name postgres -p 15432:5432 -e POSTGRES_USER='admin' -e POSTGRES_PASSWORD='password' -e POSTGRES_DB='postgres' -e PGDATA='/data/postgres' -v postgres-volume:/data/postgres postgres:9.6.9 postgres -c listen_addresses=*
```

It will take a while until the database starts up. Run this command :

```shell script
$ docker logs -f postgres
```

and wait for these logs to be show :

```log
PostgreSQL init process complete; ready for start up.

LOG:  database system was shut down at 2020-02-27 14:20:07 UTC
LOG:  MultiXact member wraparound protections are now enabled
LOG:  autovacuum launcher started
LOG:  database system is ready to accept connections
```

Now you can run this application using java -jar, as shown in the following example:

```shell script
$ java -jar target/2-persistnce-context-multi-ds-0.0.1-SNAPSHOT.jar
```

or using the spring boot maven plugin :

```shell script
$ mvn spring-boot:run
```

### Built With

[Maven](https://maven.apache.org/) v3.6.0 - Dependency Management


### Running the tests

We've created our test in the runner package. We've implemented the Spring’s CommandLineRunner interface so after you start the application the test will be executed automatically and you can check the logs after.

If everything went well, you'll have this log :

```log
2020-02-27 15:34:24.558  INFO 18967 --- [           main] o.s.boot.examples.jpa.runner.AppRunner   : ### Create a H2 employee : 
2020-02-27 15:34:24.634  INFO 18967 --- [           main] o.s.boot.examples.jpa.runner.AppRunner   : ### Create a postgres employee : 
2020-02-27 15:34:24.660  INFO 18967 --- [           main] o.s.boot.examples.jpa.runner.AppRunner   : ### List of H2 employees : 
2020-02-27 15:34:24.670  INFO 18967 --- [           main] o.h.h.i.QueryTranslatorFactoryInitiator  : HHH000397: Using ASTQueryTranslatorFactory
2020-02-27 15:34:24.732  INFO 18967 --- [           main] o.s.boot.examples.jpa.runner.AppRunner   : Employee{id=1, name='Paul', salary=35.8, deg='Developer'}
2020-02-27 15:34:24.732  INFO 18967 --- [           main] o.s.boot.examples.jpa.runner.AppRunner   : ### List of Postgres employees : 
2020-02-27 15:34:24.732  INFO 18967 --- [           main] o.h.h.i.QueryTranslatorFactoryInitiator  : HHH000397: Using ASTQueryTranslatorFactory
2020-02-27 15:34:24.734  INFO 18967 --- [           main] o.s.boot.examples.jpa.runner.AppRunner   : Employee{id=1, name='John', salary=45.8, deg='Technical Manager'}
2020-02-27 15:34:24.734  INFO 18967 --- [           main] o.s.boot.examples.jpa.runner.AppRunner   : ### The operation ended successfully
```

We've also provided junit tests that can be launched using this command :

```shell script
$ mvn test
```

## Authors

* **Amdouni Mohamed Ali** - *Initial work* - [github](https://github.com/amdouni-mohamed-ali)
