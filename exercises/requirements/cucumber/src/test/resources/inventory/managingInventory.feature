
Feature: Managing inventory

  Scenario: Adding a product actually adds it to the inventory
    Given there are 4 sweaters in the inventory
    When I add 2 sweaters in the inventory
    Then there should be 6

  Scenario: Removing a product actually removes it from the inventory
    Given there are 4 sweaters in the inventory
    When I remove 2 sweaters from the inventory
    Then there should be 2