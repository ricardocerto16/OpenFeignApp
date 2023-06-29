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


### consemeFeign
* Is a spring app that runs on localhost on port 8081 with the help of DB H2.
* Using openFeign this app is responsible for making rest requests to the personFeign app and using the data.

## Documentation:
 * [OpenFeign link 1](https://docs.spring.io/spring-cloud-openfeign/docs/current/reference/html/)
 * [OpenFeign link 2](https://spring.io/projects/spring-cloud-azure)
 * [Hexagonal Architecture link 1](https://medium.com/ssense-tech/hexagonal-architecture-there-are-always-two-sides-to-every-story-bc0780ed7d9c)
 * [Hexagonal Architecture link 2](https://netflixtechblog.com/ready-for-changes-with-hexagonal-architecture-b315ec967749)


## Next Steps: 
* put apps running in Docker
* the consemeFeign app saves and changes data received from personFeign
