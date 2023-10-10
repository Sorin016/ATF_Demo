@Run
Feature: Check the login page

  Scenario Outline: Check the login button is displayed
    Given User open the browser
    When user is searching for website
    And user is on home page
    And user is click on login icon
    And user insert the <password> and <login>
    Then login button is displayed

    Examples:
      | password    | login                   |
      | samsungG900 | sorin.cucereavu@mail.ru |