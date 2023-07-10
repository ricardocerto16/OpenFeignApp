# API Test Automatition - Using Postman

## What is API test automation?
API test automation is the process of using a testing tool to programmatically execute API tests at certain times or frequencies, or in CI/CD pipelines. It is particularly important for agile development teams, as it enables them to maintain fast-paced development cycles while continuously and systematically verifying that their API is working as expected. API test automation helps prevent breaking changes from reaching production, and it is intended to augment—rather than replace—the manual approach. Teams that automate their API tests are able to deliver new features quickly and confidently while conserving developer bandwidth.

## What are some of the benefits of API test automation?
Like manual API testing, API test automation enables teams to confirm that their API is working as expected. However, it also offers several additional benefits that improve developer workflows and support rapid iteration. By automating API tests, teams can:

* Detect issues as soon as they are introduced:


Test automation enables developers to surface issues while they work. For instance, teams can configure their CI/CD pipeline to automatically execute API tests after every code push, which provides immediate feedback while the code is still in progress. If the tests identify an issue, the developer can fix it immediately—before it gets deployed to production and causes user-facing issues.

* Save time and resources

  
Testing at the very end of a development cycle puts enormous strain on QA teams, who are often responsible for vetting every piece of functionality on a tight schedule. This approach requires a significant amount of time and effort, and it can also result in delays as development teams work to fix unexpected issues. Automated API testing distributes the testing load across the API lifecycle, which shortens feedback loops, improves efficiency, and enables teams to bring new features to market as quickly as possible.


## Example of some tests in Person API
These tests are made to the API to verify if, in case of success or failure of the request, the return of the request is equal to what we expected when developing the code.


### Sucessfull Requests

* Find All Persons: http://localhost:8080/api/person
```
pm.test("Status test", function () {
    pm.response.to.have.status(200);
});

pm.test("Response must be valid and have a body", function () {
     pm.response.to.be.ok;
     pm.response.to.be.withBody;
     pm.response.to.be.json;
});

const jsonData = pm.response.json();
pm.test("Test data type of the response", () => {
  pm.expect(jsonData).to.be.an("array");
  pm.expect(jsonData[0].name).to.be.a("string");
  pm.expect(jsonData[0].id).to.be.a("number");
  pm.expect(jsonData[0].country).to.be.a("string");
});


pm.test("Content-Type header is present", () => {
  pm.response.to.have.header("Content-Type");
});

pm.test("Response time is less than 700ms", () => {
  pm.expect(pm.response.responseTime).to.be.below(700);
});

pm.test("Response property matches environment variable", function () {
  pm.expect(pm.response.json().name).to.eql(pm.environment.get("$content.name"));
});

```



### Insucessfull Request
