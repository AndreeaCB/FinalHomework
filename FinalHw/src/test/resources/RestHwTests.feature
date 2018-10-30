Feature: This is the RestAssured part for the Final Homework

  Scenario: The user wants to check if he has access as a owner_admin using the credentials for owner
    Given The user has the credentials as username: "ownerTest" and password: "@test" AND wants to perform a GET request
    When The user goes on the "/owners"
    Then The status will be "200"

  Scenario: The user wants to check if he has access as a vet_admin using the credentials for owner
    Given The user has the credentials as username: "ownerTest" and password: "@test" AND wants to perform a GET request
    When The user goes on the "/vets"
    Then The status will be "400"

  Scenario: The user wants to check if he has access as a vet_admin using the credentials for vet
    Given The user has the credentials as username: "testtt" and password: "@test" AND wants to perform a GET request
    When The user goes on the "/vets"
    Then The status will be "200"

  Scenario: The user wants to check if he has access as a owner_admin using the credentials for vet
    Given The user has the credentials as username: "testtt" and password: "@test" AND wants to perform a GET request
    When The user goes on the "/owners"
    Then The status will be "400"

  Scenario: The user wants a POST request by adding a new vet
    Given The user wants a POST request by filling with the vets credentials as username: "testtt" and password: "@test"
    When The user performs a post request to "/vets"
    Then The status will be "201"

  Scenario: The user wants a DELETE request on owners
    Given The user wants a DELETE request by filling with the credentials for owner as username: "ownerTest" and password: "@test"
    When The user performs a DELETE request to "/owners/{ownerId}"
    Then The status will be "204"

