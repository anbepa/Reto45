Feature: Payment Search

  Background:
    * def fn = function(rsp) { return Object.keys(rsp.payments[0]) }
    * def response_payment_json = read('classpath:data/response.json')
    * def event = read('classpath:data/payment_search.json')
    Given url urlBase


  Scenario: Validate status of connection API MS_INCOME
    Given path '/income/api/payments/search'
    And request event
    When method Post
    Then status 200

  Scenario: Validate structure from response
    Given path '/income/api/payments/search'
    And request event
    When method Post
    Then status 200
    And match fn(response.data) contains response_payment_json.keys