# API Endpoint and Data Externalization in Rest Assured Tests

In this `7-api-endpoint-and-data-externalizing-in-rest-assured-tests` branch, we focus on enhancing the maintainability and flexibility of our tests by externalizing API endpoints and test data. This approach allows us to update our testing configuration without the need to change the test code directly, facilitating easier management of different testing environments and data sets.

## What We Achieve

- **Endpoints Configuration**: API endpoints are now stored in a JSON file, `endpoints.json`, and can be accessed programmatically using the `EndpointsConfig` utility class. This allows for a centralized location for managing API paths.
- **Dynamic Test Data Management**: Test data such as passwords, product IDs, and quantities are externalized to JSON files within the `data` directory. The `DataLoader` utility class reads this data and serves it to our tests.
- **Decoupling Configuration from Code**: By separating configuration and data from the test code, we can easily adapt to changes in our API without modifying the tests themselves.

## Externalization Explained

- **EndpointsConfig**: Reads API endpoint paths from `endpoints.json` and provides methods to retrieve them based on keys.
- **DataLoader**: Fetches test data from JSON files located in the `data` folder, allowing tests to use dynamic data.
- **Refactored Test**: The `AddToCartTest` now consumes endpoint paths and test data from the externalized sources.

## How to Run This Test

1. Switch to the `7-api-endpoint-and-data-externalizing-in-rest-assured-tests` branch.
2. Run the `AddToCartTest` test case through your IDE or via command line:

   ```shell
   ./gradlew test --tests "AddToCartTest.addItemToCart"
   ```