Feature: Create new user


  Scenario Outline: Register a new User
    Given User is on page home
    And User is click on opencart register button
    And User inserts <firstName> and <lastName> and <email> and <password>
    When An error message appear that say that <email> format is incorect
    Then User click on newslatter button and Private Policy checkbox
    And User is click on login icon
    And User is on page home
    And User is click on opencart login icon
    And User enter the pass and log

    Examples:
      | firstName | lastName | email                  | password   |
      | sorin     | cuce     | sorin.cucereavumail.ru | sorinus123 |