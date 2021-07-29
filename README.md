## Project structure

* /api : Contain REST API classes (Spring RestControllers)
  * exception: Define API exception
  * security: Configure api security (using Spring security)
* /core : Contain core classes (domain)
* /application: Provide services
* /infrastructure: Implement external particular services or repositories, ...

## Migrate database

Using flyway to migrate the database

`./mvnw -Dflyway.configFiles=./flyway.conf flyway:migrate`

Flyway will get the database connection information (url, user, pass, ...) from the configuration file `flyway.conf`
or `pom.xml` (remove Dflyway.configFiles param)

Migration scripts are placed in the folder `./src/resources/db/migration`

Clean database (rarely):

`./mvnw -Dflyway.configFiles=./flyway.conf flyway:clean`

P/S: You can run maven tasks (Lifecycle, Plugins) from maven menu of the IDE (IntelliJ)

## Run spring boot app

Run by mvn

`./mvnw spring-boot:run`

Or package a jar file

`./mvnw clean package`

`java -jar target/social-blogging-site-0.0.1-SNAPSHOT.jar`

