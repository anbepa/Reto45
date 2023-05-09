Feature: Health

  Background: Define URL
    Given url urlBase

  Scenario: Check health status
    Given path '/income/api/health'
    And method Get
    Then status 200
    And match response.status == 'OK'