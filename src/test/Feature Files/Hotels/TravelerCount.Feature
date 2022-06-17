Feature: Traveler Count

Scenario: Verify Traveler count is correct

  Given I am on Hotels landing page
  When I click on travelers count menu
  And I select 6 adults
  And I select 2 children
  And I set the first child's age to 4
  And I set the second child's age to under 1
  And I click done
  Then I verify total number of guests is the sum of adults and children
  And I quit my browser
