Feature: This feature will be used to test CRUD operations on employee springboot application using RestAssured

  Scenario: This scenario will test the GetEmployee operation
    Given I have the endpoint as "http://3.84.15.226:8088/employees"
    When I perform the get operation
    Then I should get the response as 200

  Scenario: This scenario will create a new employee
    Given I have the post endpoint as "http://3.84.15.226:8088/employees"
    When I give the body as
      | firstName | Sonal               |
      | lastName  | Krish             |
      | salary    |            100000 |
      | email     | sonal@abc.com |
    And I perform the post operation
    Then I should get the post response code as 201
    And The first name should be "Sonal"
    And The email should be "sonal@abc.com"
