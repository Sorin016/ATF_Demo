Feature: Create new user and check that item is displayed

  @Run
  Scenario Outline: adsfadf
    Given User is on page home
    And User is click on opencart login icon
    And User insert <password> and <login>
    When Login button is clicked and displayed
    And User is redirect to homepage
    And Click on the first item
    And User see the item imeges
    Then Add the item in cart
#    And Leave a review from <login> for the selected item

    Examples:
      | password | login          |
      | 12345    | s.cuce@aro.com |