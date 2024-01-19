**Spring-Boot-Employee-Management-project**


All the Spring Beans defined inside this project are Singleton in order to use the server memory efficiently, and the designed classes are stateless in nature, so there will not be an issue creating all of them as Singleton. 

If, in the future, the need arises to design stateful beans, then we will need to define the bean scope as one of the following:
1. request bean scope.
2. session bean scope.

Prototype scope is not recommended here because the application will produce new objects every time the request for access is made, and that will create a memory leak error.

The following configurations are implemented into this project to make the application production ready:

1. Configured Spring Profiles for managing the application configuration across different environments.

2. Configured Spring Boot Actuator for monitoring the application in production.

3. Built as a JAR to ease the deployment process.

"Employee Management Project Results.docx" document under this repository contains captured screenshots of the REST API tests through Postman, JUnit Test results, and JUnit Coverage results.
