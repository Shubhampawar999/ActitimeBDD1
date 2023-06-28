Feature: Get all the task and print the consol

  @GetAllTask
  Scenario: I verify the get all tasks
    Given I set up the request structure to featch all customer details
    When  I hit the api
      | method | endPoint |
      | GET    | tasks    |
   # Then I verify the all taskName is "Product documentation"

    @GetSpecificTask
    Scenario: I verify the specific task
      Given I set up the request structure to featch all customer details
      When I pass custId and hit api
        | CustId   | 82    |
        | Method   | GET   |
        | EndPoint | tasks |
      Then I verify the task "Prototype 2 deployment"

    @GetFilterTaskUsingQueryParam
    Scenario: I verify filter the task using querypara
      Given I set up the request structure and featch all the taskDetails
        | offset            | 1     |
        | includeReferenced | users |
      When I hit the api pathpara
        | method | endPoint | pathPara |
        | GET    | tasks    | 103      |
      Then I verify the projectId is 13

      @SortingTaskName
      Scenario Outline: I verify the name of task in asc and desc order
        Given I set up the request structure and featch all the taskDetails
          | sort | <value> |
        When   I hit the api
          | method | endPoint |
          | GET    | tasks    |
        Then I verify the responce the <order> sorting
          | complete |
        Examples:
          | value | order |
          | name  | asc   |
          | -name | desc  |

      @GetFilterStatus
      Scenario: I verify the filter the status using query param
        Given I set up the request structure and featch all the taskDetails
          | status           | open |
          | workflowStatusId | 4    |
        When   I hit the api
          | method | endPoint |
          | GET    | tasks    |
        Then I verufy the status is "open"

      @TaskcreatNew
      Scenario: Verify get all task api
         Given I set up the request structure
         When I hit a api
           | method | endPoint  |
           | POST   | customers |



