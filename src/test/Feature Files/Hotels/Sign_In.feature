Feature: Verify that the verification message for invalid sign in is displayed

  Scenario: Sign in button automation for TC-21

    Given I am on Hotels website
    When I click on sign in menu
    And I click on sign in button
    And I enter an email in sign in page
    And I enter a password in sign in page
    And I click on the keep me signed in checkbox
    And I click on the following sign in button
    Then I verify if sign in error message is displayed
    And I quit the browser
