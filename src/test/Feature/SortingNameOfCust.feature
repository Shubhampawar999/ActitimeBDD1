Feature: Sorting name of cust
@SortingCustName
  Scenario Outline: I get the cust name in ascand desc order
    Given I set up the request structure to featch all project detailss
      | sort | <value> |
    When I het the api
      | methodName | endPoint  |
      | GET        | customers |
    Then I verify cust responce is getting sorted in <order> order
    Examples:
      | value | order |
      | -name | desc  |
      | name  | asc   |

@samplefeature
  Scenario Outline: verify rick and morty api response
    Given I get the response from rick and morty api
      | status  | <status>  |
      | species | <species> |
      | gender  | <gender>  |
    Then I verify the response with status code 200
    Examples:
      | status  | species  | gender |
      | Alive   | Humanoid | Male   |
      | unknown |          | Female |
      | Alive   | Humanoid |        |


