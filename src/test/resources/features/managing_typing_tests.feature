Feature: Managing typing tests

  Scenario: Creating a typing test
    Given A typing test with difficulty "easy" and some text
    When We create the typing test
    Then The typing test is saved with the specified difficulty and text

  Scenario: Retrieving a typing test by difficulty
    Given A typing test with difficulty "easy" exists
    When We retrieve the typing test by difficulty "easy"
    Then The retrieved typing test has difficulty "easy"