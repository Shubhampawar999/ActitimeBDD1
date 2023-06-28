  Feature: Add employee in PIM module

    Background:I loggin to the orangeHrm with valid credentials
        Given I navigate to pim module in orangehrm
        When I entering username "Admin" and password "manager"
        And I click the login button


      Scenario: And the employee in pim module
          Given Navigate to the pim module
          And Click on the addemployee and add button
          When I add the new user in actitimee firstname "shubham" and lastname "pawar" and emailid "shubham@123"

      Scenario: Verify the user add into userlist
          Given Navigate to the user modulee in actitime
          When Search user for userlist
          Then Verify user add successfully in userlist












