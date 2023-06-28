Feature: Add User Three times

  Scenario: Add new user 3 times
    Given I lauch browser
    Given Add new user 3 timee
      | firstName | lastName | emailId     |
      | shubham   | pawar    | shubahm@123 |
    Then I verify added new three user