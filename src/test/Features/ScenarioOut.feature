Feature: to pass the multiple input

  Scenario Outline: Verify the firstname lastname and emailid text  field in actitime application
    Given Navigate to   actitime applicatione
   When Add the multiple inputee
  | firstName | <firstName> |
     | lastName  | <lastName>  |
     | emailId   | <emailId>   |
    Then Verify error msgee
    Examples:
      | firstName | lastName | emailId |
      | cyber     | success  | cyber@123 |
      |           | success  | cyber@123 |
     | cyber     |          | cyber@123 |
    | cyber     | success  |           |

  Scenario: AddNew the user in actitime application and delete the a added user
    Given I lauch browser
    When I add the new user
      | firstName | MiddleName | LastName  | emailId   |
      | CYBER     | SUCCESS    | INSTITUDE | CYBER@123 |
    And Verify added value
    Then Added new employee deleted

  Scenario: Pass the data in the form of data table in cucumber
    Given I lauch browser
    When I pass the data in form of dataTable class
      | firstName | middleName | LastName   | emailId     |
      | cyber     | success    | institude  | cyber@123   |
      | cyber1    | success1   | institude1 | cyber@1233  |
      | cyber2    | success2   | institude2 | cyber@1234  |
      | cyber3    | success3   | institude3 | cyber@12345 |
    And I removing the added new user
    Then Verify added new user successfully delet

  @color1
  Scenario: Input multiple colr
    Given I give a input in list format

  @color1 @color2
  Scenario: I give the multiple name in list format
    Given I give the name in list format
      | firstname | LastName |
      | Shubham   | Pawar    |





