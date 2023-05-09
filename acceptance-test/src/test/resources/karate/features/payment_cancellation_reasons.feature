Feature: Payment Cancellation Reasons

  Background:
    Given url urlBase

  Scenario: Get payment cancellation reasons
    Given path '/income/api/causalannulments'
    When method GET
    Then status 200

