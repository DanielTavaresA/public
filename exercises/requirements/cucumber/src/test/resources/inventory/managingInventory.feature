Feature: Managing inventory

  Scenario: Adding a product actually adds it to the inventory
    Given there are 4 sweaters in the inventory
    When I add 2 sweaters in the invetory
    Then there should be 6