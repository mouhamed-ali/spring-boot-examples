
-- Spring loads SQL from the standard root classpath locations: schema.sql and data.sql,
-- respectively. In addition, Spring Boot processes the schema-${platform}.sql and data-${platform}.sql files (if present),
-- where platform is the value of spring.datasource.platform.

CREATE SEQUENCE my_sequence MINVALUE 10 MAXVALUE 600 INCREMENT 1 CYCLE;
DROP TABLE IF EXISTS cities;
CREATE TABLE cities(id bigint PRIMARY KEY, name VARCHAR(100), population integer, description text);