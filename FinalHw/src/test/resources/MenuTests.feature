Feature: Going through all the menu tabs

  Scenario: The user can press click on SpringTab/HomeTab from the menu
    Given The user goes on the PetClinic Site
    When The user clicks on the SpringTab
    Then The home page is displayed

  Scenario: The user can press click on HomeTab from the menu
    Given The user goes on the PetClinic Site
    When The user clicks on the HomeTab
    Then The home page is displayed

  Scenario: The user can press click on OwnersTab from the menu
    Given The user goes on the PetClinic Site
    When The user clicks on the OwnersTab
    Then A dropdownlist for owners with All and Add New Buttons is displayed

  Scenario: The user can press click on VeterinariansTab from the menu
    Given The user goes on the PetClinic Site
    When The user clicks on the VeterinariansTab
    Then A dropdownlist for vets with All and Add New Buttons is displayed

  Scenario: The user can press click on PetTypeTab from the menu
    Given The user goes on the PetClinic Site
    When The user clicks on the PetTypesTab
    Then The PetType page is displayed

  Scenario: The user can press click on SpecialtiesTab from the menu
    Given The user goes on the PetClinic Site
    When The user clicks on the SpecialtiesTab
    Then The Specialties page is displayed
