# Setting Up GitHub Actions for Automated Test Execution

The `9-setting-up-github-actions-for-automated-test-execution` branch introduces a Continuous Integration (CI) workflow using GitHub Actions. This workflow automates the execution of the API test suite upon every push to the `main` branch.

## Workflow Explanation

- **Workflow Name**: Defined as "API Test Suite Execution," which is the name that will appear on GitHub when the action runs.

- **Trigger**: The workflow is configured to trigger on every `push` event to the `main` branch.

- **Jobs**:
    - **execute-api-tests**: The single job defined in the workflow, named "Execute API Tests," which will run on the latest Ubuntu runner provided by GitHub Actions.

- **Steps**:
    - **Checkout Repository**: Uses the `checkout` action to clone the repository into the runner's filesystem.

    - **Set Up JDK 11**: Uses the `setup-java` action to set up Java Development Kit version 11, which is necessary to compile and execute Java-based tests.

    - **Configure Gradle**: Utilizes the `gradle-build-action` to configure Gradle, a build automation tool, in the GitHub Actions runner environment.

    - **Build Project with Gradle**: Executes the `./gradlew build` command to build the project, which compiles the Java code and ensures there are no compilation errors.

    - **Execute Test Suite**: Runs `./gradlew test` to execute the test suite defined in the project, leveraging the Rest Assured framework.

    - **Collect Test Results**: Uses shell commands to count the number of passed and failed test cases by searching the generated XML test result files. The counts are then set as output parameters for potential use in subsequent steps or jobs.

    - **Upload Allure Test Report Artifacts**: After tests are executed, the Allure test report artifacts are uploaded using the `upload-artifact` action. This allows anyone reviewing the CI run to download and view a detailed test report.

## Benefits of the CI Workflow

- **Automated Testing**: Ensures tests are run automatically, providing immediate feedback on the health of the codebase with each change.

- **Consistent Environment**: Tests are executed in a clean, standardized environment, eliminating "works on my machine" problems.

- **Visibility**: Makes test results visible to the team, enhancing collaboration and accountability.

- **Quality Assurance**: Helps prevent the merging of code changes that would break the existing functionality.

## Viewing Reports

After the CI run, you can view the Allure report by downloading the uploaded artifact from the GitHub Actions run page. You can then serve the report locally using the Allure command-line tools or view the results directly if integrated with a GitHub Pages site or other hosting solutions.
