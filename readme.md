# Feign App Example


## How does Feign work?
Feign works by processing annotations into a templatized request. Arguments are applied to these templates in a straightforward fashion before output. Although Feign is limited to supporting text-based APIs, it dramatically simplifies system aspects such as replaying requests. Furthermore, Feign makes it easy to unit test your conversions knowing this.

## What is Swagger

Swagger is a specification for documenting REST APIs. It describes the api format including URL, method, and representation to describe REST web services. Swagger is meant to enable the service producer to update the service documentation in real time so that client and documentation systems are moving at the same pace as the server. The methods, parameters, and models description are tightly integrated into the server code, thereby maintaining the synchronization in APIs and its documentation. The specification asks you to include information like:

- What are all the operations that your API supports?
- What are your API’s parameters and what does it return?
- Does your API need some authorization?
- And even fun things like terms, contact information and license to use the API.

### To integrate Swagger with Spring Boot we need to include the following maven dependencies in our pom.xml file.
```
<!-- swagger dependencies -->
<dependency>
	<groupId>org.springdoc</groupId>
	<artifactId>springdoc-openapi-starter-webmvc-ui</artifactId>
	<version>2.1.0</version>
</dependency>
<dependency>
	<groupId>org.springframework.boot</groupId>
	<artifactId>spring-boot-starter-validation</artifactId>
</dependency>
```
## What is API test automation? (Via Postman)
API test automation is the process of using a testing tool to programmatically execute API tests at certain times or frequencies, or in CI/CD pipelines. It is particularly important for agile development teams, as it enables them to maintain fast-paced development cycles while continuously and systematically verifying that their API is working as expected. API test automation helps prevent breaking changes from reaching production, and it is intended to augment—rather than replace—the manual approach. Teams that automate their API tests are able to deliver new features quickly and confidently while conserving developer bandwidth.


More detailed information on this topic at the following [link](https://github.com/ricardocerto16/OpenFeignApp/blob/main/Postman/readme.md) with examples from the repository


## Description Simple App Feign:

To consume an external api using spring openfeign we use the
following website: https://jsonplaceholder.typicode.com/ .
With this requests : 
* Find All Photos: https://jsonplaceholder.typicode.com/photos/
* Find Photo By Id: https://jsonplaceholder.typicode.com/photos/1

## Description personFeign & consemeFeign:

### personFeign: 
* Is a spring app that runs on localhost on port 8080 with the help of DB H2. (http://localhost:8080/h2-console/)
* For this app we adopted a hexagonal architecture (help links in the documentation topic
* The exampleData.txt file that is in the resources already has some inserts in the table to be tested
* Tests performed on Controller and Service using Mockito
* Swagger link: http://localhost:8080/swagger-ui/index.html#/  (The project needs to be running to access the link)


### consemeFeign
* Is a spring app that runs on localhost on port 8081 with the help of DB H2.
* Using openFeign this app is responsible for making rest requests to the personFeign app and using the data.
* Swagger link: http://localhost:8081/swagger-ui/index.html#/  (The project needs to be running to access the link)




## Documentation:
 * [OpenFeign link 1](https://docs.spring.io/spring-cloud-openfeign/docs/current/reference/html/)
 * [OpenFeign link 2](https://spring.io/projects/spring-cloud-azure)
 * [Hexagonal Architecture link 1](https://medium.com/ssense-tech/hexagonal-architecture-there-are-always-two-sides-to-every-story-bc0780ed7d9c)
 * [Hexagonal Architecture link 2](https://netflixtechblog.com/ready-for-changes-with-hexagonal-architecture-b315ec967749)
 * [Unit tests with Mockito](https://www.vogella.com/tutorials/Mockito/article.html)
 * [JUnit 5 tutorial - Learn how to write unit tests](https://www.vogella.com/tutorials/JUnit/article.html)
 * [Integrate JUnit and Mockito, Unit Testing for Controller Layer](https://medium.com/backend-habit/integrate-junit-and-mockito-unit-testing-for-controller-layer-91bb4099c2a5)
 * [Swagger](https://www.baeldung.com/spring-rest-openapi-documentation)
 * [Postman - Writting Tests](https://learning.postman.com/docs/writing-scripts/test-scripts/)
 * [Postman - Test script examples](https://learning.postman.com/docs/writing-scripts/script-references/test-examples/)
 * [What is API test automation?](https://www.postman.com/api-platform/api-test-automation/)
 
## Next Steps: 
* put apps running in Docker
* the consemeFeign app saves and changes data received from personFeign
