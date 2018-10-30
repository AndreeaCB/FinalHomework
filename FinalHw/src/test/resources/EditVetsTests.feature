Feature: The user goes through the All Vets page

  Scenario: The user wants to edit a specified vet
    Given The user is on the All Vets page
    When The user iterates through the all vets list and wants a specific vet as "Helen Leary"
    Then The user clicks on the fields as fallows: firstName: "first edited", lastName: "last edited" AND chooses a favourite type AND clicks on the edit button in order to edit the vet

  Scenario: The user wants to delete a specified vet
    Given The user is on the All Vets page
    When The user iterates through the all vets list and wants to find a specific vet as "Helen Leary" AND clicks delete on that vet
    Then The browser is searching for the vet called "Helen Leary" and if it doesn't find it, it shuts down