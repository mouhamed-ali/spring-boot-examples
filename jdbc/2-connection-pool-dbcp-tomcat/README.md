# Project Title

DBCP connection pool

## Overview

In this example, we will configure an DBCP connection pool using spring boot.

### References
https://www.baeldung.com/spring-boot-tomcat-connection-pool<br/>
https://www.javainterviewpoint.com/spring-boot-jdbc-connection-pool-example/<br/>
https://javadeveloperzone.com/spring-boot/spring-boot-common-dbcp2-connection-pool/<br/>
https://commons.apache.org/proper/commons-dbcp/configuration.html<br/>
https://commons.apache.org/proper/commons-dbcp/configuration.html<br/>
http://masterspringboot.com/configuration/web-server/configuring-tomcat-connection-pool-on-spring-boot<br/>

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

Now you can run this application using java -jar, as shown in the following example:

```
java -jar target/2-connection-pool-dbcp-tomcat-0.0.1-SNAPSHOT.jar
```

or using the spring boot maven plugin :

```
mvn spring-boot:run
```

```log
2020-02-27 16:43:34.243  INFO 27857 --- [           main] o.hibernate.annotations.common.Version   : HCANN000001: Hibernate Commons Annotations {5.0.4.Final}
2020-02-27 16:43:34.325  INFO 27857 --- [           main] org.hibernate.dialect.Dialect            : HHH000400: Using dialect: org.hibernate.dialect.PostgreSQL95Dialect
2020-02-27 16:43:34.414  INFO 27857 --- [           main] o.h.e.j.e.i.LobCreatorBuilderImpl        : HHH000421: Disabling contextual LOB creation as hibernate.jdbc.lob.non_contextual_creation is true
2020-02-27 16:43:34.418  INFO 27857 --- [           main] org.hibernate.type.BasicTypeRegistry     : HHH000270: Type registration [java.util.UUID] overrides previous : org.hibernate.type.UUIDBinaryType@36ddaebf
2020-02-27 16:43:34.520  INFO 27857 --- [           main] j.LocalContainerEntityManagerFactoryBean : Initialized JPA EntityManagerFactory for persistence unit 'default'
2020-02-27 16:43:34.629  INFO 27857 --- [           main] o.s.boot.examples.jdbc.dbcp.Application  : Started Application in 1.887 seconds (JVM running for 2.135)
org.apache.tomcat.jdbc.pool.DataSource@10650953{ConnectionPool[defaultAutoCommit=true; defaultReadOnly=null; defaultTransactionIsolation=-1; defaultCatalog=null; driverClassName=org.postgresql.Driver; maxActive=50; maxIdle=15; minIdle=8; initialSize=15; maxWait=2000; testOnBorrow=true; testOnReturn=false; timeBetweenEvictionRunsMillis=5000; numTestsPerEvictionRun=0; minEvictableIdleTimeMillis=60000; testWhileIdle=false; testOnConnect=false; password=********; url=jdbc:postgresql://localhost:15432/postgres; username=admin; validationQuery=SELECT 1; validationQueryTimeout=-1; validatorClassName=null; validationInterval=3000; accessToUnderlyingConnectionAllowed=true; removeAbandoned=false; removeAbandonedTimeout=60; logAbandoned=false; connectionProperties=null; initSQL=null; jdbcInterceptors=null; jmxEnabled=true; fairQueue=true; useEquals=true; abandonWhenPercentageFull=0; maxAge=0; useLock=false; dataSource=null; dataSourceJNDI=null; suspectTimeout=0; alternateUsernameAllowed=false; commitOnReturn=false; rollbackOnReturn=false; useDisposableConnectionFacade=true; logValidationErrors=false; propagateInterruptState=false; ignoreExceptionOnPreLoad=false; useStatementFacade=true; }
2020-02-27 16:43:34.633  INFO 27857 --- [           main] j.LocalContainerEntityManagerFactoryBean : Closing JPA EntityManagerFactory for persistence unit 'default'
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
