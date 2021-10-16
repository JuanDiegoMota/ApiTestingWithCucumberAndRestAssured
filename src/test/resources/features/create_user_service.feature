Feature: Validation of Create Users.

  @GetUserDetails
  Scenario Outline: Successful verification of create user service
    When I send a request to the URL to create user
      | name           | <name> |
      | salary| <salary> |
      | age   | <age>    |
    Then the response will return for created user was success

    Examples:
      |name  |salary|age|
      |Luisa Fernanda|12400|25|