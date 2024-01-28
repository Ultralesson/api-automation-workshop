# Enhancing Test Reporting Mechanism with Allure

In the `8-enhancing-test-reporting-mechanism` branch, our API Automation Workshop is equipped with Allure, an open-source framework designed to improve test reports by providing clear and detailed execution results. Allure annotations are utilized to categorize and provide additional context to the test executions.

## What We Achieve

- **Rich Reporting**: Integrate Allure to generate comprehensive and interactive test reports, providing insights into test executions.
- **Test Categorization**: Use Allure annotations to categorize tests into epics, features, and stories, giving a hierarchical structure to the test cases.
- **Severity Indication**: Indicate the severity of each test case using Allure's severity levels, which helps in prioritizing issues.
- **Command-Line Reporting**: Implement a command to serve the Allure report locally, allowing stakeholders to view the results easily.

## Allure Integration Details

- **Gradle Configuration**: Update the `build.gradle` file to include the Allure plugin and dependencies for generating reports.
- **Annotated Test Cases**: Augment test methods with Allure annotations like `@Epic`, `@Feature`, `@Story`, and `@Severity` to enrich the report with additional metadata.
- **Execution of Tests**: Run tests using the standard Gradle test command.
- **Serving Reports**: Use the `./gradlew test allureServe` command to generate and serve the Allure report locally.

## How to Run Tests and Generate Reports

1. Ensure you are on the `8-enhancing-test-reporting-mechanism` branch.
2. Run your tests using Gradle:

   ```shell
   ./gradlew test allureServe
   ```

   This command will run tests and serve the Allure report on a local server and open it in your default web browser.
