Feature: Going through the adding owner process


  Scenario: The user goes on the New Owner page in order to add a new owner
    Given The user goes to the Pet Clinic Site
    When The user clicks on  Add New Owner Button
    Then The new owners page should be displayed

  Scenario: The user is adding a new owner by completing the form in the most happy case
    Given The user is on the New Owner page
    When The user completes the form by filling all the required fields as firstname: "Andreea Cucumber", lastname: "CB Cucumber", address: "Address Cucumber", city:"City Cucumber", telephone:"0123456"
    Then The new owner is created AND the owner as "Andreea Cucumber CB Cucumber" exists on the All Owners page

  Scenario: The user is filling the fields by completing the telephone field with characters, not numbers
    Given The user is on the New Owner page
    When The user completes the form by filling all the required fields as firstname: "Andreea Cucumber", lastname: "CB Cucumber", address: "Address Cucumber", city:"City Cucumber", telephone:"characters"
    Then An error message is displayed

  Scenario: The user is filling the FirstName with only one character
    Given The user is on the New Owner page
    When The user completes the form by filling all the required fields as firstname: "A", lastname: "CB Cucumber", address: "Address Cucumber", city:"City Cucumber", telephone:"0123456"
    Then An error message for the firstName field is displayed

  Scenario: The user is filling the LastName with only one character
    Given The user is on the New Owner page
    When The user completes the form by filling all the required fields as firstname: "Andreea Cucumber", lastname: "C", address: "Address Cucumber", city:"City Cucumber", telephone:"0123456"
    Then An error message for the LastName field is displayed

  Scenario: The user doesn't complete the fields at all
    Given The user is on the New Owner page
    When The user completes the form by filling all the required fields as firstname: "", lastname: "", address: "", city:"", telephone:""
    Then The AddOwner button is inactive

  Scenario: The user completes the fields, but only one remains unfilled
    Given The user is on the New Owner page
    When The user completes the form by filling all the required fields as firstname: "Andreea Cucumber", lastname: "CB Cucumber", address: "", city:"City Cucumber", telephone:"0123456"
    Then The AddOwner button is inactive

  Scenario: The user completes the all fields with spaces
    Given The user is on the New Owner page
    When The user completes the form by filling all the required fields as firstname: "   ", lastname: "   ", address: "   ", city:"   ", telephone:"   "
    Then An error message is displayed

  Scenario: The user wants to find out if a specified owner has a pet (true if the owner doesn't have pets)
    Given The user is on the All Owners page
    When The user goes through all the owners list and asks for a specific owner as "Peter McTavish"
    Then The browser should say if the specified owner as "Peter McTavish" has pets

  Scenario: The user is searching for the just added owner
    Given The user is on the All Owners page
    When The user goes through all the owners list and asks for a specific owner as "Andreea Cucumber CB Cucumber"
    Then The browser should find that owner as "Andreea Cucumber CB Cucumber"