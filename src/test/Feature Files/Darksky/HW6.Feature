
  Scenario: Verify Current Date is highlighted in Time Machine's Calendar
    Given I am on Darksky landing page
    When I click on TimeMachine
    Then I verify the dates match


  Scenario: Open Facebook pay, oculus, instagram, portal and bulletin HW5 example
    Given I am on Facebook
    When I open Facebook pay, oculus, instagram, portal, and bulletin
    And I close all windows except Instagram
    Then I verify number of window handles
    Then I verify Page title is Instagram
    Then I verify log in button is disabled

  Scenario: Verify destination error displayed if search with no destination
    Given I am on Hotels website
    When I click on search button without destination
    Then I verify if error is displayed


  Scenario: Verify enter-children's age error is displayed, and error is not displayed as soon as user enters child's age
    Given I am on Hotels landing page
    When I click on Travelers
    And I click on add child
    Then I verify age error is displayed
    Then I click on child dropdown
    And I click on child's age
    Then I verify if error is no longer displayed
