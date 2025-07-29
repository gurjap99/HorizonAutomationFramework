Horizon Automation Framework
This project contains automation tests developed using Selenium, Cucumber, and Maven, with reporting capabilities provided by Allure and Masterthought Cucumber Reporting.

Project Setup
Make sure you have Java Development Kit (JDK) 21 and Apache Maven installed on your system.

Running Tests and Generating Reports
Use the following Maven commands to execute tests and generate various reports.

1. Clean Project (Delete old results)
   Before running tests, it's good practice to clean up previous build artifacts and test results.

mvn clean

This command will delete the target folder, which contains compiled classes, test results, and generated reports from previous runs.

2. Run Tests and Generate Reports
   You can run tests based on tags, the entire test suite, or a specific feature file. The commands below will execute the tests, generate a cucumber.json report, timestamped Allure results, Masterthought Cucumber HTML reports, and then automatically open the Allure report in your browser.

Important: The pom.xml is configured to create timestamped allure-results and allure-report directories (e.g., allure-results_YYYYMMDD_HHmmss) for each full build.

Run tests with a specific tag (e.g., @Smoke):

mvn clean test '-Dcucumber.filter.tags="@Smoke"' allure:report allure:serve

This command runs scenarios tagged with @Smoke and generates reports.

Run the entire test suite (all features):

mvn clean test allure:report allure:serve

This command executes all scenarios in your feature files and generates reports.

Run a specific feature file:

mvn clean test '-Dcucumber.features="src/test/resources/features/home.feature"' allure:report allure:serve

Replace src/test/resources/features/home.feature with the path to your desired feature file.

3. Generate UI Report for Existing Executed Results (Allure)
   If you have already executed tests and have timestamped allure-results directories in your target folder, you can generate and serve an HTML report for any specific run.

First, identify the exact allure-results_<timestamp> directory you want to view from your target folder (e.g., allure-results_20250729_115345).

Then, use the allure serve command, specifying the path to that particular results directory:

allure serve target/allure-results_YOUR_SPECIFIC_TIMESTAMP

Example:

allure serve target/allure-results_20250729_115345

This command requires the Allure command-line tool to be installed and accessible in your system's PATH. It will process the specified results and open the Allure HTML report in your default web browser.