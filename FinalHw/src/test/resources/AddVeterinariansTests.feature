Feature: Going through the Veterinarians page

  Scenario: The user goes on the New Veterinarians page in order to add a new vet
    Given The user goes on Pet Clinic Site
    When The user clicks on the Add New Owner Button
    Then The add vet page should be displayed

  Scenario: The user adds a new vet by completing all the fields(happy case)
    Given The user is on the Add New Vet page
    When The user fills the fields as firstName: "And", lastName: "CB" AND clicks on Type field AND chooses a type from the dropdown list
    Then The Save button should be pressed

  Scenario: The user adds a new vet by completing all the fields, except the First name field which has only one character
    Given The user is on the Add New Vet page
    When The user fills the fields as firstName: "A", lastName: "CB" AND clicks on Type field AND chooses a type from the dropdown list
    Then An error message should be displayed AND the save button can be pressed

  Scenario: The user adds a new vet by completing all the fields, except the Last name field which has only one character
    Given The user is on the Add New Vet page
    When The user fills the fields as firstName: "And", lastName: "C" AND clicks on Type field AND chooses a type from the dropdown list
    Then An error message should be displayed for the last name field AND the save button can be pressed
