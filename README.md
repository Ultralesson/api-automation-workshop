# Creating Request and Response POJOs

In the `4-creating-request-and-response-pojos` branch, we enhance the structure and maintainability of our API tests by introducing POJOs (Plain Old Java Objects) for request and response data. This approach leverages Java's object-oriented nature to model our API's data, providing a more readable, writable, and maintainable test codebase.

## What We Achieve

- **Data Model Representation**: By creating `SignupRequestModel` and `SignupResponseModel`, we effectively represent the data structures for requests and responses in our API interactions.
- **Serialization and Deserialization**: Utilizing these models allows for automatic serialization of request data into JSON and deserialization of the response JSON back into Java objects.
- **Improved Test Readability**: With POJOs, our test assertions are clearer and more concise. Data access becomes a matter of navigating through object properties rather than parsing JSON paths.
- **Reduced Boilerplate Code**: The use of annotations like `@Data` and `@Builder` from Lombok reduces the boilerplate code, making the models easier to write and maintain.

## Implementation Details

- **SignupRequestModel**: Defines the structure of the request payload with attributes for `email` and `password`.
- **SignupResponseModel**: Encapsulates the response data from the API, including nested objects for user details and session information.
- **UserClient**: Updated to use the `SignupRequestModel` for constructing the request and to return a `SignupResponseModel` object after parsing the API response.
- **UserSignupTest**: Now uses the `SignupResponseModel` to assert the correctness of the response data.

## How to Run This Test

1. Ensure you're on the `4-creating-request-and-response-pojos` branch.
2. Execute the `UserSignupTest` using your IDE or by running the following command:

   ```shell
   ./gradlew test --tests "UserSignupTest.testSuccessfulUserRegistration"
   ```