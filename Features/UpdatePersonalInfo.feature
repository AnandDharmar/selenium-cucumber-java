Feature: Update PersonalInformation

 @Test
  Scenario: Update Firstname in the MyAccount
    Given User enters a valid credentials
    And User clicks on My Personal Information
    When User updates the lastname and saves
    Then Success message should be displayed
