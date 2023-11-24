
Feature: Check the login page

  Scenario Outline: Check the login button is displayed
    Given User open the browser
    When User is searching for website
    And User is on home page
    And User is click on login icon
    And User insert the <password> and <login>
    Then Login button is displayed and clicked

    Examples:
      | password    | login                   |
      | samsungG900 | sorin.cucereavu@mail.ru |