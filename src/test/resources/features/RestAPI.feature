
Feature: Create a new Bank Account via API

  Scenario Outline: User create new bank account and make a transaction
    Given User navigates to 'Register' page
    And User login with credentials <username> and <password>
    When User with <customerId> open new account from <fromAccount>
    And User sent a transaction from <fromAccount> to <reiverAccount> with <amount>
    Then User checks the transaction by <date> and <fromAccount>

    Examples:
      | password | username | fromAccount | date       | reiverAccount | amount | customerId |
      | 123      | sad      | 14454       | 04-03-2024 | 14565         | 11     | 13100      |

#                      MM/DD//YYYY

