Feature:Create a new Custmer in actitime application


   @GetProject
     Scenario Outline: Get the specific cust in and get the all projectname
       Given I set up the request structure to featch all customer detailss
       When I hit the apii
         | methodName     | <methodName>     |
         | endPoint       | <endPoint>       |
         | queryParameter | <queryParameter> |
       Examples:
         | methodName | endPoint | queryParameter |
         | GET        | projects | 6              |
       Then Verify