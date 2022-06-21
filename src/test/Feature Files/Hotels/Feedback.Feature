Feature: Feedback button
  Scenario: Verify "Tell us how we can improve our site" and share feedback button is displayed at the end of search results
    Given I am on Hotels Website
    When I click on the search bar
    And I type in 'bora' as the destination
    And I click on 'Bora Bora' from the suggestions
    And I click on the Check In option
    And I select the date as August 1, 2022
    And I select the checkout date as August 10, 2022
    And I click on the calendar done button
    And I click on search button
    Then I verify 'Tell us how we can improve our site' is displayed
    Then I verify the share feedback button is displayed
    And I quit the browser




