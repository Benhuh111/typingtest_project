Feature: Managing users

  Scenario: Creating a user
    Given A user with name "John Doe" and email "john.doe@example.com"
    When We create the user
    Then The user is saved with the specified name and email

  Scenario: Retrieving a user by ID
    Given A user with ID 1 exists
    When We retrieve the user by ID 1
    Then The retrieved user has ID 1

  Scenario: Retrieving a user by email
    Given A user with email "john.do@example.com" exists
    When We retrieve the user by email "john.doe@example.com"
    Then The retrieved user has email "john.doe@example.com"