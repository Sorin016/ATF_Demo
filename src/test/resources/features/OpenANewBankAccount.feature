@UI
Feature: Create a new Bank Account

  Scenario Outline: User create new bank account
    Given User login with valid credentials <pass> and <log>
    When User clicks on 'Open new accout'
    And User select <type> of account
    And User open new account details
    And Using new account transfer <amount> to another amount
    Then User navigates and check that transfer was with success and check that transfer was with success

    Examples:
      | pass | log     | type     | amount |
      | 123  | vandam1 | SAVINGS  | 5      |
      | 123  | vandam1 | CHECKING | 5      |

  @UI @Run
  Scenario Outline: Pay bill
    Given User login with valid credentials <pass> and <log>
    And User clicks on 'Bill Pay' button
    And User inserts all of the mandatory fields
      | Payee Name | Address   | City     | State | Zip Code | Phone | Account | Verify Account | Amount |
      | Sorin      | Korolenko | Chisinau | 2828  | 790377   | 12345 |         |                |   23     |

    Examples:
      | pass | log     |
      | 123  | vandam1 |