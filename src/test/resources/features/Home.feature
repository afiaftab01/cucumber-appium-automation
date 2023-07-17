@sanity
Feature: Validate all the home page and landing page  applications

  @webview
  Scenario: Verify the landing page carousal and its text fields
    Given user launched application
    When user click on the landing click button
    Then user verifies the landing text
    And navigate to webview

  @login
  Scenario: Verify the application login
    Given user launched application
    When user skip and login