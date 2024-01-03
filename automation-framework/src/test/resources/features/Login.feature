@login

Feature: WebDriver University - Login

  Background:
    Given I access the WebDriver University login page

  Scenario: Validate successful login

  Scenario: Validate unsuccessful login

  Scenario Outline: Validate - Successful & Unsuccessful Login
    When I enter a specific username <username>
    And I enter a specific password <password>
    And I click on the login button
    Then I should be presented with a <loginStatus> login message
    Examples:
      | username  | password        | loginStatus  |
      | webdriver | webdriver123    | successful   |
      | pedrito   | cualquiercosaxd | unsuccessful |