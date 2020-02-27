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

### Building

After cloning the project, you can build it from source with this command:

```
mvn clean package
```

### Installing

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

you can now run this application using java -jar, as shown in the following example:

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
