# api-directors
API for listing directors with their movies.

This api is a Spring Boot application that shows a list of directors who have more movies than the parameter(threshold) given.

## Features ##
-Exposes a Rest endpoint : 'http://localhost:[port]/api/directors?threshold=x'
-Sort the list of directors.
-Use of Feign client for cummunication
-Contain unit tests for service and controller clases.
-Properties file has the url https://directa24-movies.wiremockapi.cloud
-Swagger Url: http://localhost:8080/swagger-ui/index.html

## NOTE ##
I consumed the endpoint several times, however, time later, I got a the next message:
{
  "errors" : [ "Monthly request quota has been exceeded. Visit https://app.wiremock.cloud/account/subscriptions to upgrade." ]
}

So, I couldn't made a lot of test with real data.

Feel free to modify this project to better your project's specifics.
