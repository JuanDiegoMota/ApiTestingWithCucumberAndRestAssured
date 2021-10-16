Feature: Validation of get users information

  @GetUserDetails
  Scenario Outline: Successful verification of get user information service
    When I send a request to the URL to get user details
    Then the response will return all employed information
      | id             | <id>              |
      | employee_salary| <employee_salary> |
      | employee_name  | <employee_name>   |
      | employee_age   | <employee_age>    |
      | message        |  <message>        |

    Examples:
      |id  |employee_salary|employee_name |employee_age  |message                                  |
      |1   |320800         |Tiger Nixon   |61            |Successfully! Record has been fetched.   |