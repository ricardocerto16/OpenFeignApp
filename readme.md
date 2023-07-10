# Feign App Example


## How does Feign work?
Feign works by processing annotations into a templatized request. Arguments are applied to these templates in a straightforward fashion before output. Although Feign is limited to supporting text-based APIs, it dramatically simplifies system aspects such as replaying requests. Furthermore, Feign makes it easy to unit test your conversions knowing this.

## Description Simple App Feign:

To consume an external api using spring openfeign we use the
following website: https://jsonplaceholder.typicode.com/ .
With this requests : 
* Find All Photos: https://jsonplaceholder.typicode.com/photos/
* Find Photo By Id: https://jsonplaceholder.typicode.com/photos/1

## Description personFeign & consemeFeign:

### personFeign: 
* Is a spring app that runs on localhost on port 8080 with the help of DB H2.
* For this app we adopted a hexagonal architecture (help links in the documentation topic
* The exampleData.txt file that is in the resources already has some inserts in the table to be tested
* Tests performed on Controller and Service using Mockito
* Swagger link: http://localhost:8080/swagger-ui/index.html#/


### consemeFeign
* Is a spring app that runs on localhost on port 8081 with the help of DB H2.
* Using openFeign this app is responsible for making rest requests to the personFeign app and using the data.

## What is Swagger

Swagger is a specification for documenting REST APIs. It describes the api format including URL, method, and representation to describe REST web services. Swagger is meant to enable the service producer to update the service documentation in real time so that client and documentation systems are moving at the same pace as the server. The methods, parameters, and models description are tightly integrated into the server code, thereby maintaining the synchronization in APIs and its documentation. The specification asks you to include information like:

What are all the operations that your API supports?
What are your API’s parameters and what does it return?
Does your API need some authorization?
And even fun things like terms, contact information and license to use the API.


## Documentation:
 * [OpenFeign link 1](https://docs.spring.io/spring-cloud-openfeign/docs/current/reference/html/)
 * [OpenFeign link 2](https://spring.io/projects/spring-cloud-azure)
 * [Hexagonal Architecture link 1](https://medium.com/ssense-tech/hexagonal-architecture-there-are-always-two-sides-to-every-story-bc0780ed7d9c)
 * [Hexagonal Architecture link 2](https://netflixtechblog.com/ready-for-changes-with-hexagonal-architecture-b315ec967749)
 * [Unit tests with Mockito](https://www.vogella.com/tutorials/Mockito/article.html)
 * [JUnit 5 tutorial - Learn how to write unit tests](https://www.vogella.com/tutorials/JUnit/article.html)
 * [Integrate JUnit and Mockito, Unit Testing for Controller Layer](https://medium.com/backend-habit/integrate-junit-and-mockito-unit-testing-for-controller-layer-91bb4099c2a5)
 
## Next Steps: 
* put apps running in Docker
* the consemeFeign app saves and changes data received from personFeign
