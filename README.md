# Establishing a Client Layer for API Calls

In this branch, `3-establishing-a-client-layer-for-api-calls`, we introduce a client layer to our API testing framework. The client layer encapsulates the complexity of making API calls, thereby simplifying the test cases that depend on these calls. This abstraction not only makes the test cases cleaner but also promotes code reuse and maintainability.

## What We Achieve

- **Encapsulation of API Calls**: By creating a `UserClient` class, we encapsulate the details of making API requests. This class provides a `createUser` method that handles the user signup process, hiding the specifics of the RESTful request construction.
- **Cleaner Test Cases**: With the client layer in place, our `UserSignupTest` focuses purely on the test logic without being cluttered by the API call details.
- **Reusability**: The `UserClient` can be used across multiple test cases wherever user creation is required, avoiding the repetition of request setup code and following the DRY (Don't Repeat Yourself) principle.
- **Maintainability**: Any changes to the API call logic, such as endpoint modification or request structure, now only need to be updated in the `UserClient`, rather than in each individual test.

## Client Layer Implementation

- **UserClient**: A dedicated client class that offers a method to perform user signup. It takes user credentials as parameters and returns the `Response` object.
- **UserSignupTest**: An updated test case that utilizes the `UserClient` to register a new user and validates the response.

## How to Run This Test

1. Confirm that you're on the `3-establishing-a-client-layer-for-api-calls` branch.
2. Run the `UserSignupTest` test case using your preferred IDE or by executing the following command in your terminal:

   ```shell
   ./gradlew test --tests "UserSignupTest.testSuccessfulUserRegistration"
   ```