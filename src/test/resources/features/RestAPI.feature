
Feature: Create a new Bank Account via API

  Scenario Outline: User creates new bank account
    Given User navigates to 'Register' page
    And User logins with credentials <username> and <password>
    And User with <customerId> open new account from <fromAccount>
    When User sents a transaction from <fromAccount> to <reiverAccount> with <amount>
    And User check the transaction by <fromAccount> and <date>

    Examples:
      | password | username | fromAccount | date       | reiverAccount | amount | customerId |
      | 123      | vandam1  | 14232       | 04-08-2024 | 15786         | 11     | 12989      |