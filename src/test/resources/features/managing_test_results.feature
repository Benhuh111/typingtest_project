Feature: Managing test results

  Scenario: Submitting a test result
    Given A user with ID 1
    When The user submits a test result with 50 WPM and 95.5% accuracy
    Then The test result is saved with the user's ID, WPM, accuracy, and the current date

  Scenario: Retrieving test results by user ID
    Given A user with ID 1 has submitted test results
    When We retrieve test results for user ID 1
    Then The retrieved test results list is not empty