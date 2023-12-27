Feature: Create new user

  @Run
  Scenario Outline: Register a new User
    Given User is on page home
    And User is click on opencart register button
    And User inserts <firstName> and <lastName> and <email> and <password>

    Examples:
      | firstName | lastName | email                   | password   |
      | sorin     | cuce     | sorin.cucereavumail.ru | sorinus123 |