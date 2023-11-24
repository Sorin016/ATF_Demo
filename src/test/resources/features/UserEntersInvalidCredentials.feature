Feature: User introduces wrong credentials for the login page

  Background:User is Logged In
    Given User open the browser
    When User is searching for website
    And User is on home page
    And User is click on login icon

  Scenario Outline: User introduce wrong password
    And User populate the <corectFieldName> with correct <correctValue>
    And User populate the <wrongField> with wrong <wrongValue>
    Then Login button is displayed and clicked
    And The error message appears

    Examples:
      | corectFieldName | correctValue            | wrongField | wrongValue |
      | login           | sorin.cucereavu@mail.ru | password   | samsungG90 |


#  Scenario Outline: User introduce wrong login
#    And User populate the <field> with wrong <value>
#    And User insert the <login>
#    Then Login button is displayed and clicked
#    And The error message appears
#
#    Examples:
#      | password   | value                  | field    |
#      | samsungG90 | sorin.cucereavu@mail.r | password |
