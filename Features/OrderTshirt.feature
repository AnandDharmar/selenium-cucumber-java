Feature: Order T-Shirt

  @Test
  Scenario: Order T-Shirt and verify Order Details
    Given User enters a valid credentials
    And Customer clicks on the T-Shirt category
    And Selects a T-Shirt and proceeds to checkout
    And agree to the terms and conditions
    And proceeds to pay by the available payment options
    And Customer Confirms his order
    When Customer navigates his order history page
    Then Order history should reflect this order for a T-Shirt