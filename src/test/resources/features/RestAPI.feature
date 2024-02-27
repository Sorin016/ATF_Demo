
Feature: Create a new Bank Account

  Scenario Outline: User create new bank account
    Given User navigate to 'Register' page
    And User login with credentials <username> and <password>
    And User open new account from <customerId>
    When User sent a transaction from <account> to <reiverAccount> with <amount>
    And User select check the transaction by <account> and <date>

    Examples:
      | password | username | account | date       | reiverAccount | amount | customerId |
      | 123      | dd       | 21669   | 02-23-2024 | 14676         | 13     | 16985      |