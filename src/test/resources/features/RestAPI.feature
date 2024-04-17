Feature: Create a new Bank Account via API

  Scenario Outline: User create new bank account and make a transaction
    Given User navigates to 'Register' page
    And User logins with credentials <username> and <password>
    When User with <customerId> open new account from <fromAccount>
    And User sents a transaction from <fromAccount> to <reiverAccount> with <amount>
    Then User checks the transaction by <date> and <fromAccount>

    Examples:
      | password | username | fromAccount | date       | reiverAccount | amount | customerId |
      | 123      | pedros   | 17451       | 05-02-2024 | 18339         | 11     | 15986      |

#                                           MM/DD//YYYY

