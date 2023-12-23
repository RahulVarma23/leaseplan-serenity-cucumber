# Getting started with Serenity and Cucumber

Serenity BDD is a library that makes it easier to write high quality automated acceptance tests, with powerful reporting and living documentation features. It has strong support for both web testing with Selenium, and API testing using RestAssured.
Serenity strongly encourages good test automation design, and supports several design patterns, including classic Page Objects, the newer Lean Page Objects/ Action Classes approach, and the more sophisticated and flexible Screenplay pattern.

## The starter project
The best place to start with Serenity and Cucumber is to clone or download the starter project on Github ([https://github.com/serenity-bdd/serenity-cucumber-starter](https://github.com/serenity-bdd/serenity-cucumber-starter)). This project gives you a basic project setup, along with some sample tests and supporting classes. There are two versions to choose from. The master branch uses a more classic approach, using action classes and lightweight page objects, whereas the **[screenplay](https://github.com/serenity-bdd/serenity-cucumber-starter/tree/screenplay)** branch shows the same sample test implemented using Screenplay.

### The project directory structure
The project has build scripts for both Maven and Gradle, and follows the standard directory structure used in most Serenity projects:
```Gherkin

src
  + test
    + java                          Test runners and supporting code
        + common                    Package for API calls and common steps
            CommonSteps             All common actions across all the domain models
            SearchProductSteps      API calls of search product
        + config                    Package for all common actions and steps
             RequestSpec            Common Request Spec for the API calls
        + stepdefinitions           Step definitions for the BDD feature
        Test Runner                 TestSuite 
    + resources
      + features                    Feature files directory
        +search                     feature files directory for search product functionality
          search_product.feature    Feature containing BDD scenarios
      Serenity.conf                 Configurations file

## Refactored code:

1. feature file: converted scenario to scenario outline to run test for multiple products
2. SearchStepDefinitions: added reusable step to verify positive and negative results
3. TestRunner: added glue option under Cucumber option to specify path of step definitions
4. pom.xml: added **<groupId>org.apache.maven.plugins</groupId>** for maven-surefire-plugin
5. pom.xml: groupId and artifactId: Change the project identifier
6. Remove gradle setting: Since we will use Maven
7. pom.xml: Remove some setting in pox.xml: for clean up
8. pom.xml: Upgrade serenity:Use the latest since we start a new project
9. Restructure code: for better maintenance

## Executing the tests:

Run this from the command line : mvn clean verify
The test results will be recorded here **target/site/serenity/index.html.**

## Additional configurations

Additional command line parameters can be passed for switching the application environment.
Run mvn clean verify -Denvironment=qa
Configurations to for different environments are set in the test/resources/serenity.conf file. In real time projects each environment can be configured with its baseurl to run the tests based on different environments.

environments {
  default {
    baseurl = "https://waarkoop-server.herokuapp.com"
  }
  dev {
    baseurl = "https://waarkoop-server.herokuapp.com"
  }
  qa {
    baseurl = "https://waarkoop-server.herokuapp.com"
  }
}

