
Feature: Add items to the cart

  Scenario Outline: Add few items to the cart and check if they are present there
    Given User open the browser
    When User is searching for website
    And User is on home page
    And User is click on login icon
    And User insert the <password> and <login>
    And Login button is displayed and clicked
    And User navigate to Mens Shoes
    And Choose the <mens_size> and <color> and <price>
    And Choose the first item and add them to the cart
    Then Check that all selected items are present in cart

    Examples:
      | password    | login                   | mens_size | color | price            |
      | samsungG900 | sorin.cucereavu@mail.ru | 9.5       | Black | $35.00 and Under |
