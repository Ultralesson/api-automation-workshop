# Writing a Test Case for User Signup API

In this branch, `2-writing-a-test-case-for-user-signup-api`, we focus on developing a test case to validate the user signup process. The goal is to ensure that when new users register, they receive the correct HTTP response status, appropriate user details, and a non-null access token, which is crucial for a secure and functional user experience.

## What We Achieve

- **Automated Testing for User Registration**: We implement an automated test case that verifies successful user registration using a randomly generated email to avoid conflicts with existing data.
- **Test Isolation and Independence**: By using a UUID for the email, each test run is independent, allowing for repeated testing without manual intervention.
- **Response Validation**: We validate multiple aspects of the response to ensure the signup process behaves as expected:
    - HTTP Status Code 201: Indicates successful resource creation (user registration).
    - Email Confirmation: Ensures the response contains the correct email that was used to sign up.
    - Role Verification: Checks if the new user is assigned the "authenticated" role by default.
    - Access Token Presence: Verifies that a non-null access token is generated, which is required for user authentication post-registration.

## Test Case Breakdown

- **Arrange**: Set up test data, such as a unique email and a password, and define the API endpoint and request body.
- **Act**: Execute the API call using the POST method with the `RestAssured` library to simulate the user signup process.
- **Assert**: Use assertions to verify that the API response contains the expected status code, email, role, and a valid access token.

## How to Run This Test

1. Ensure you are on the correct branch `2-writing-a-test-case-for-user-signup-api`.
2. Set up your test environment as per the configuration instructions in branch `1-setting-up-base-test-configuration`.
3. Execute the test using your IDE or via the command line with Gradle:
   ```shell
   ./gradlew test --tests "UserSignupTest.testSuccessfulUserRegistration"
   ```