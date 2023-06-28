Feature: Verify the customer

  @GetAllCustem
  Scenario: {{url}}/api/v1/customers using this api getting all cust
    Given I set up the request structure to featch all customer details
    When I hit a apii
      | MethodName | GET       |
      | EndPoint   | customers |
    Then Verify all custname

    @GetSpecificCustId
    Scenario: {{url}}/api/v1/customers/{{customerId}} using this url get specific custId
      Given I set up the request structure to featch all customer details
      When I pass custId and hit api
        | CustId   | 10         |
        | Method   | GET       |
        | EndPoint | customers |
      Then verify custId
