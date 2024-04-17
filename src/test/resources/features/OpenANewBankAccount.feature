@UI @Run
Feature: Create a new Bank Account

  Scenario Outline: User create new bank account
    Given User login with valid credentials <pass> and <log>
    When User clicks on 'Open new accout'
    And User selects <type> of account
    And User opens new account details
    And Using new account transfer <amount> to another amount
    Then User navigates and check that transfer was with success

    Examples:
      | pass | log | type     | amount |
      | 123  | hh  | SAVINGS  | 5      |
      | 123  | hh  | CHECKING | 5      |

  @UI
  Scenario Outline: Pay bill
    Given User login with valid credentials <pass> and <log>
    And User clicks on 'Bill Pay'
    And User inserts the mandatory fields
      | payeeName | address   | city     | state | zipCode | phone | account | verifyAccount | amount |
      | Sorin     | Korolenko | Chisinau | 2828  | 790377  | 12345 | 10      | 10            | 23.00  |
    And User sends another <amount> Bill Pay via API call for <pass> and <log>
    Then User navigates and check that bill pay was with success


    Examples:
      | pass | log | amount |
      | 123  | hh  | 12     |