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
    When User registers with success
    Then User log-out

    Examples:
      | password | username |
      | 123      | vandam1  |
#      | 123      | supri2   |
#      | 123      | supri3   |



  @UI
  Scenario Outline: Add already existing user
    Given User is on main home page
    When User clicks on 'Register' button
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
    Then User registers with error message


    Examples:
      | password | username |
      | 123      | vandam1  |
      | 123      | supri2   |
