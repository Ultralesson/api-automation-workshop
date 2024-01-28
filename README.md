# Setting Up Base Test Configuration

In this branch, `1-setting-up-base-test-configuration`, we establish the foundational setup necessary for running API tests using Rest Assured. This step ensures that all the automated tests have access to a consistent and configurable environment, which is key for reliable test execution.

## What We Achieve

- **External Configuration Management**: We set up a `PropertyFileUtils` utility class that allows us to manage our test configurations externally. This keeps our test environment dynamic and our code clean.
- **Base Test Setup**: The `BaseAPITest` class acts as a launchpad for all our tests, fetching the base URL from the configuration file and setting up the Rest Assured `baseURI`.
- **Environment Health Check**: With `EnvironmentCheckTest`, we verify that our API environment is up and running correctly. This is a preliminary check that ensures our API is responsive before we proceed with more complex test scenarios.

## Test Case Breakdown

- **Arrange**: We arrange our test environment by setting up a base URL in the `config.properties` file and fetching it in our `BaseAPITest` class.
- **Act**: The act phase is implemented in the `EnvironmentCheckTest` where we make a GET request to the `/health-check` endpoint.
- **Assert**: We assert that the response status code is 200 and the message is "ok", confirming that our environment is properly set up and ready for further testing.

## How to Run This Test

1. Make sure you are checked out to the `1-setting-up-base-test-configuration` branch.
2. Run the environment check test using your IDE or the following command line instruction:

   ```shell
   ./gradlew test --tests "EnvironmentCheckTest.testEnvironmentSetup"
   ```