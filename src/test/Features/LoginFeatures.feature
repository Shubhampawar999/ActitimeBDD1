
Feature: Login Feature

  Scenario: Verify user is able to login to application with valid credentials
    Given I login to application with valid username and password
    When I enter username "admin" and password "manager"
    And perform click operation
    Then I verify user is logged in to application successfully









