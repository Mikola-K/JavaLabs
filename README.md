# Lab 9
## Task 
  1. Create REST service and implement CRUD(GET/POST/PUT/DELETE) operations on object from 8-th lab
  2. GET operation with id provided should return object with requested id, 
  3. Get operation without id provided should return list of all objects
  4. Code should be checked with checkstyle and pmd plugins
  5. Code should be in a different pull request than lab8
  6. Controller and RestApplication should be in a different packages
  7. Objects should be stored in a `Map`

## To run
  + Clone this repository with command `git clone https://github.com/Mikola-K/JavaLabs.git`
  + `cd` into folder where you stored thus repository
  + Choose branch Lab9 with command `git checkout Lab_8`
  + Run `mvn install` (you have to install maven on your system, if you haven't done so before; also you have to choose 11 version of Java)
  + Run `java -jar target/Lab9-VERSION.jar`, where `VERSION` is version of the app (can be found in `pom.xml`, under `<version>` tag)
  + Open http://localhost:8081/swagger-ui.html in your browser