# Custom Deserializer for Complete API Response Handling: Status Code and Headers

This `5-custom-deserializer-for-complete-api-response-handling-status-code-and-headers` branch takes our API testing framework a step further. We incorporate a custom deserializer utility that enriches our response models with status code and headers information. This allows us to perform more comprehensive assertions in our tests, ensuring not only the correctness of the response body but also the response status and headers.

## What We Achieve

- **Enhanced Response Model**: We enhance the `SignupResponseModel` to include additional fields for status code and headers, allowing us to hold more information about the HTTP response.
- **ApiResponseDeserializer Utility**: This custom deserializer is responsible for converting the raw `Response` from Rest Assured into our rich model, including setting status code and headers.
- **Improved Assertion Capabilities**: With status code and headers available in our response model, our test assertions can now cover these critical aspects of the HTTP response.

## Custom Deserialization Explained

- **ApiResponseDeserializer**: A utility class that takes a Rest Assured `Response` object and deserializes it into a response model. It extracts the status code and headers from the `Response` and sets them in the response model if fields for them are declared.
- **UserClient**: Updated to use the `ApiResponseDeserializer` for converting the Rest Assured `Response` to our `SignupResponseModel`.

## How to Run This Test

1. Check out to the `5-custom-deserializer-for-complete-api-response-handling-status-code-and-headers` branch.
2. Execute the `UserSignupTest` using your IDE or by running:

   ```shell
   ./gradlew test --tests "UserSignupTest.testSuccessfulUserRegistration"
   ```