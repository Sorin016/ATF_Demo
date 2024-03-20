
Feature: Create a new Bank Account

  Scenario Outline: User create new bank account
    Given User navigates to 'Register' page
    And User login with credentials <username> and <password>
    And User with <customerId> open new account from <fromAccount>
    When User sent a transaction from <fromAccount> to <reiverAccount> with <amount>
    And User selects check the transaction by <fromAccount> and <date>

    Examples:
      | password | username | fromAccount | date       | reiverAccount | amount | customerId |
      | 123      | superM   | 16341       | 03-20-2024 | 16563         | 11     | 14765      |