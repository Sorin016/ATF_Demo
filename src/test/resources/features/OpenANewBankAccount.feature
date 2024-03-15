@UI
Feature: Create a new Bank Account

  Scenario Outline: User create new bank account
    Given User login with valid credentials <pass> and <log>
    When User clicks on 'Open new accout'
    And User select <type> of account
    And User open new account details
    And Using new account transfer <amount> to another amount
    Then User navigate and check that transfer was with success

    Examples:
      | pass | log       | type    | amount |
      | 123  | superMan2 | SAVINGS | 5      |