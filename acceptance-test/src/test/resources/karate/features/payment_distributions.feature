Feature: Payment Distributions

  Background:
    * def fn = function(rsp) { return Object.keys(rsp.payments[0]) }
    * def payment_data_update = read('classpath:data/payment_distributions_update.json')
    Given url urlBase


  Scenario: Get Payment Distribution
    Given path '/income/api/distribution/174'
    When method GET
    Then status 200

  Scenario: Get all payments to be distributed
    Given param distributed = true
    Given path '/income/api/distribution/search/payments'
    When method Get
    Then status 200
    * print karate.pretty(response)

  Scenario: Get distribution by payment id
    Given param distributed = true
    Given path '/income/api/distribution/search/payments'
    When method Get
    Then status 200
    * def paymentId = response[0].id
    * print karate.pretty(response[0].id)

    Given path '/income/api/distribution/payment/'+ paymentId
    When method Get
    Then status 200
    And match response.status == 'OK'
