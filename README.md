**Appium Cucumber TestNG Allure Framework**

This project is a sample implementation of the Appium Cucumber TestNG Allure framework in Java. It provides a structured approach to mobile application testing using Behavior-Driven Development (BDD) techniques.

**Getting Started**
To get started with this framework, please follow the instructions below:

1. Replace the APK or IPA file of the test application in the following path: src/test/resource/app. Make sure to replace the existing file with the new application file.

2. Write all the test cases in BDD format in the feature files located at src/test/resource/features. Each feature file represents a specific functionality or scenario.

3. Corresponding BDD step definitions are defined in the path src/test/java/steps. These step definitions map the steps mentioned in the feature files to actual test code.

4. Driver instances are initialized from the MobileDriver class located at src/main/java/test using the singleton design pattern. This class provides methods to set up and manage the Appium driver instance.

5. The framework follows the Page Object Model (POM) implementation. All application-specific pages should be specified in the src/test/java/pages package. Each page class should have methods representing the actions and validations that can be performed on that page.

6. All the prerequisites and setup steps can be handled in the hooks class located at src/test/java/hooks. Hooks provide a way to run pre-test and post-test actions, such as setting up the driver, launching the application, and performing cleanup tasks.

**Running the Tests**
To run the tests using this framework, you can use a test runner class with TestNG. Configure the test runner to include the appropriate features, step definitions, and hooks. You can specify the test runner class as the entry point for your test execution.

Additionally, you can generate test reports using the Allure framework. Allure provides comprehensive reports with detailed test execution results, including screenshots and log information.

Dependencies
The following dependencies are required to use this framework:
Dependencies are mentioned in pom.xml
Appium: Version X.X.X
Cucumber: Version X.X.X
TestNG: Version X.X.X
Allure: Version X.X.X
Make sure to include these dependencies in your project's build configuration file, such as Maven's pom.xml or Gradle's build.gradle.

Contributing
If you find any issues or have suggestions for improvement, please feel free to contribute. You can submit a pull request or raise an issue in the project's repository.
