@UI @Run
Feature: Create a new Bank Account

  Scenario Outline: User create new bank account
    Given User logins with valid credentials <pass> and <log>
    And User clicks on 'Open new accout'
    And User selects <type> of account
    When User opens new account details
    And Using new account transfer <amount> to another amount
    Then User navigates and check that transfer was with success

    Examples:
      | pass | log   | type     | amount |
      | 123  | sup | SAVINGS  | 3      |
      | 123  | sup | CHECKING | 5      |