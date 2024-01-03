@login

Feature: WebDriver University - Login Page

  Scenario: Validate successful login
    Given I access the WebDriver University login page
    When I enter a specific username "webdriver"
    And I enter a specific password "webdriver123"
    And I click on the login button
    Then I should be presented with a successful login message

  Scenario: Validate unsuccessful login
    Given I access the WebDriver University login page
    When I enter a specific username "webdriver"
    And I enter a specific password "webdriver12"
    And I click on the login button
    Then I should be presented with a unsuccessful login message
