@UI @Run
Feature: Add a new user

  Scenario Outline: Add new user
    Given User is on main home page
    And User clicks on 'Register' button
    And <password> and <username> is inserted
    And User inserts the few fields
      | lastName  | address     |
      | Cucereavu | Korolenko10 |
    And Not all mandatory fields are inserted error appears
      | cityIsRequired    | stateIsRequired    | zipCodeIsRequired     | socialSecurityNumberIsRequired      |
      | City is required. | State is required. | Zip Code is required. | Social Security Number is required. |
    And User inserts the rest of the mandatory fields
      | city     | state    | zipCode | phone  | ssn   |
      | Chisinau | Chisinau | 2828    | 790377 | 12345 |
    When User succesfully register
    Then User log-out

    Examples:
      | password | username |
      | 123      | superMan2 |

