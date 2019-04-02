$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("src/test/resources/features/PostApiTest.feature");
formatter.feature({
  "line": 1,
  "name": "Api Test",
  "description": "As a test automation developer \nI get a list of blog posts using the API endpoint\nuser should have posts and\neach blog post should have a unique ID",
  "id": "api-test",
  "keyword": "Feature"
});
formatter.scenario({
  "line": 17,
  "name": "Unique ID per post",
  "description": "",
  "id": "api-test;unique-id-per-post",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 16,
      "name": "@uniqueIdPerPost"
    }
  ]
});
formatter.step({
  "line": 18,
  "name": "I get a list of blog posts using the API endpoint",
  "keyword": "When "
});
formatter.step({
  "line": 19,
  "name": "each blog post should have a unique ID",
  "keyword": "Then "
});
formatter.match({
  "location": "ApiTestSteps.getListOfBlogPost()"
});
formatter.result({
  "duration": 14245770324,
  "status": "passed"
});
formatter.match({
  "location": "ApiTestSteps.getAndCheckPostIdIsUnique()"
});
formatter.result({
  "duration": 727776036,
  "status": "passed"
});
});