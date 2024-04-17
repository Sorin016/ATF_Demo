Feature: Create a new Bank Account via API

  Scenario Outline: User create new bank account and make a transaction
    Given User navigates to 'Register' page
    And User logins with credentials <username> and <password>
    When User with <customerId> open new account from <fromAccount>
    And User sents a transaction from <fromAccount> to <reiverAccount> with <amount>
    Then User checks the transaction by <date> and <fromAccount>

    Examples:
      | password | username | fromAccount | date       | reiverAccount | amount | customerId |
      | 123      | ff       | 13788       | 04-17-2024 | 13899         | 11     | 12545      |

#                      MM/DD//YYYY

