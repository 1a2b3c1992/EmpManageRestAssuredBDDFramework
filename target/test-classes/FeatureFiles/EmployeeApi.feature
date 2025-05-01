Feature: Test Employee all Endpoints

  Background: 
    Given set base uri

  Scenario: create a new employee Entity
    Given get the request specification object
    And attach request payload to http post request
    When select http post request
    Then get employee id from response payload
    And get validatable response object
    And validate status code 201
    And validate status line "Created"
    And validate time below 5000 ms
    And validate "Content-Type" and "application/json" header
    And validate "Date" and current time header
    And validate json schema
    And generate response logs