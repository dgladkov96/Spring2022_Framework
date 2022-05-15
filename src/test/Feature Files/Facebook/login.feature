Feature: Facebook login                                                   #Feature Name

  Scenario: Verify user cannot login with invalid credentials             #Scenario Name
    #Gherkin Steps
    Given I am on facebook landing page
    When I enter $%^&*( in login username
      And I enter abcd@1234 in login password
      And I click on login button
    Then I verify error is displayed



  Scenario: Verify user can login with valid credentials
      Given I am on facebook landing page
      When I enter validUser@gmail.com in login username
        And I enter abcdvalidPass@1234 in login password
        And I click on login button
      Then I verify Facebook Homepage is displayed



  Scenario: Verify user cannot login with empty credentials
    Given I am on facebook landing page
      And I click on login button
    Then I verify error is displayed

  #Comment in feature flie
  # valid user credentials not available