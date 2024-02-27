
Feature: Create a new Bank Account

  Scenario Outline: User create new bank account
    Given User navigates to 'Register' page
    And User login with credentials <username> and <password>
    And User open new account from <customerId>
    When User sent a transaction from <fromAccount> to <reiverAccount> with <amount>
    And User selects check the transaction by <fromAccount> and <date>

    Examples:
      | password | username  | fromAccount | date       | reiverAccount | amount | customerId |
      | 123      | superMan2 | 16119       | 02-28-2024 | 18006         | 13     | 13988      |