## Migrate database

Using flyway to migrate the database

`./mvnw -Dflyway.configFiles=./flyway.conf flyway:migrate`

Flyway will get the database connection information (url, user, pass, ...) from the configuration file `flyway.conf`

Migration scripts are placed in the folder `./src/resources/db/migration`

## Run spring boot app

Run by mvn

`./mvnw spring-boot:run`

Or package a jar file

`./mvnw clean package`

`java -jar target/social-blogging-site-0.0.1-SNAPSHOT.jar`

