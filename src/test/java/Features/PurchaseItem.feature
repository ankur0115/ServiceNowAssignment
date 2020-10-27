Feature: Purchase an item from automationpractice website

  Scenario: Purchase the item with the lowest cost
    Given User is on the automation practice homepage
    When user enters "printed" in global search
    And user selects lowest price value from dropdown
    And user selects the lowest price dress and adds to the cart
    And user proceeds to checkout
    And user enters username and password
    And user selects default delivery address
    And user proceeds to shipping confirmation
    And user selects payment method and confirms payment
    Then order gets successfully placed
    And browser is closed




