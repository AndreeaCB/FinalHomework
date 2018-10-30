Feature: The user goes through specialties page

  Scenario: The user goes to the Specialty page
    Given The user is on the petclinic site
    When The user wants to access the Specialties tab
    Then The specified page is displayed

  Scenario: The user adds a specialty(happy case)
    Given The user is on the specialties page
    When The user presses click on the add specialty button and fills the name field as "new specialty"
    Then the user clicks on the save button

  Scenario: The user adds a specialty by not completing the name field
    Given The user is on the specialties page
    When The user presses click on the add specialty button and fills the name field as ""
    Then the user clicks on the save button

  Scenario: The user adds a specialty by completing the name field with numbers
    Given The user is on the specialties page
    When The user presses click on the add specialty button and fills the name field as "123"
    Then the user clicks on the save button

  Scenario: The user adds a specialty by completing the name field with only one character
    Given The user is on the specialties page
    When The user presses click on the add specialty button and fills the name field as "a"
    Then the user clicks on the save button
