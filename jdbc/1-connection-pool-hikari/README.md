# Project Title

Hikari connection pool

## Overview

In this example, we will configure an Hikari connection pool using spring boot. You can find the datasource and the pool of connexions configuration in the `application.yml` file :

```yaml
spring:
  datasource:
    initialization-mode: always
    url: jdbc:postgresql://localhost:15432/postgres
    username: admin
    password: password
    schema: classpath:db/sql/create-db.sql
    type: com.zaxxer.hikari.HikariDataSource # the fully-qualified name of the DataSource implementation we want to use
    hikari:
      connectionTimeout: 3000
      idleTimeout: 600000 # This property controls the maximum amount of time that a connection is allowed to sit idle in the pool.
      # This setting only applies when minimumIdle is defined to be less than maximumPoolSize.
      maxLifetime: 1800000 # This property controls the maximum lifetime of a connection in the pool. An in-use connection
      # will never be retired, only when it is closed will it then be removed.
      validationTimeout: 60000 # This property controls the maximum amount of time that a connection will be tested for aliveness.
      # This value must be less than the connectionTimeout. Lowest acceptable validation timeout is 250 ms. Default: 5000
```

### References
https://www.baeldung.com/spring-boot-hikari<br/>
https://github.com/brettwooldridge/HikariCP#configuration-knobs-baby<br/>
https://javadeveloperzone.com/spring-boot/spring-boot-common-dbcp2-connection-pool/<br/>
https://www.javainterviewpoint.com/spring-boot-jdbc-connection-pool-example/<br/>
https://commons.apache.org/proper/commons-dbcp/configuration.html<br/>

### Building

After cloning the project, you can build it from sources using this command:

```shell script
$ mvn clean package
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

```shell script
$ mvn test
```

output:
```log

Results :

Tests run: 3, Failures: 0, Errors: 0, Skipped: 0

[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  11.757 s
[INFO] Finished at: 2020-02-27T17:40:31+01:00
[INFO] ------------------------------------------------------------------------

```

