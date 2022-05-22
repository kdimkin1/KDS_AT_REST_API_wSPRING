# Automation Tests (Spring Boot based simple Rest application with Swagger and Rest-Assured tests)

## Technology Stack
| <a href="https://www.jetbrains.com/idea/"><img src="images/IDEA-logo.svg" width="40" height="40"  alt="IDEA"/></a> | <a href="https://www.jetbrains.com/idea/"><img src="images/java-logo.svg" width="40" height="40"  alt="Java"/></a> | <a href="https://www.jetbrains.com/idea/"><img src="images/git-logo.svg" width="40" height="40"  alt="git-logo"/></a> | <img src="images/junit5-logo.svg" width="40" height="40"  alt="JUnite"/> | <img src="https://spring.io/images/spring-logo-9146a4d3298760c2e7e49595184e1975.svg" width="100" height="40"  alt="Spring"/> | <img src="images/swagger-logo.png" width="40" height="40"  alt="Swagger"/> | <img src="images/rest-assured-logo.png" width="40" height="40"  alt="Rest-Assured"/> |
|:---------------------------------------------------------------------------------------------------------------------------------------------------------:| :---------: |:---------------------------------------------------------------------------------------------------------------------:|:------------------------------------------------------------------------:|:----------------------------------------------------------------------------------------------------------------------------:|:--------------------------------------------------------------------------:|:------------------------------------------------------------------------------------:|
|                                                                           IDEA                                                                            | Java |                                                          Git                                                          |                                  JUnite                                  |                                                         Spring Boot                                                          |                                  Swagger                                   |                                     Rest-Assured                                     |

## 1) App start (run main):

```bash
src/main/java/kds/at/restbackend/RestBackendApplication.java
```
![image](images/1_Application_run.png)
## 2) Swagger:
### http://localhost:8081/swagger-ui/
![image](images/2_Swagger.png)

## 3) Tests run:
```bash
src/test/java/kds/at/restbackend/ShipsControllerTests.java

```
![image](images/3_OK_tests_runs.png)

## Common links&notes:
```bash
Spting boot:
src/main/resources/application.properties
server.port=8081

Swagger:
https://www.baeldung.com/swagger-2-documentation-for-spring-rest-api
3.1. Spring Boot Dependency
4.1. Java Configuration

```

