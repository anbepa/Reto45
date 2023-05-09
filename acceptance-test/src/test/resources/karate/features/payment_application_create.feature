Feature: Payment Application Create

  Background:
    * def payment_data = read('classpath:data/payment_add.json')
    * def payment_data_update = read('classpath:data/payment_update.json')
    * def fn = function(rsp) { return Object.keys(rsp.data) }
    * def response_payment_json = read('classpath:data/response.json')
    Given url urlBase



  Scenario: Get payment application
    * def sleep = function(pause){ java.lang.Thread.sleep(pause) }
    * eval sleep(2000)
    Given path '/income/api/payment-application'
    * params  1
    * params  40
    When method GET
    Then status 200


  Scenario: Get payment application report
    * def sleep = function(pause){ java.lang.Thread.sleep(pause) }
    * eval sleep(2000)
    Given path '/income/api/payment-application/report'
    * param page = 1
    * param size = 10
    When method GET
    Then status 200


  Scenario: Get payment application short names
    * def sleep = function(pause){ java.lang.Thread.sleep(pause) }
    * eval sleep(2000)
    Given path '/income/api/payment-application/short-names'
    When method GET
    Then status 200

  Scenario: Get payment application identification numbers
    * def sleep = function(pause){ java.lang.Thread.sleep(pause) }
    * eval sleep(2000)
    Given path '/income/api/payment-application/identifications'
    When method GET
    Then status 200

  Scenario: Get payment application numbers
    * def sleep = function(pause){ java.lang.Thread.sleep(pause) }
    * eval sleep(2000)
    Given path '/income/api/payment-application/applications'
    When method GET
    Then status 200



