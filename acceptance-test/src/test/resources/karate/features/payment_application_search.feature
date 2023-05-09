Feature: Payment Application

  Background:
    Given url urlBase
    * def payment = read('classpath:data/payment_search.json')

  Scenario: Payment application success
    * set payment.number_payment = '202212700001'
    Given path '/income/api/payments/search'
    And request payment
    When method Post
    Then status 200
    And match response.status == 'OK'

  Scenario: Search payment application by payment id
    Given path '/income/api/payments/search'
    And request payment
    When method Post
    Then status 200
    And match response.status == 'OK'
    * def paymentId = response.data.payments[0].id
    * print paymentId

    Given param payment_id = paymentId
    Given path '/income/api/application/payment/search'
    When method Get
    Then status 200
    And match response.data[0].id == paymentId

  Scenario: Search payment application failed by payment id
    Given path '/income/api/payments/search'
    And request payment
    When method Post
    Then status 200
    And match response.status == 'OK'
    * def paymentId = response.data.payments[0].id

    Given param payment_id = paymentId
    Given path '/income/api/application/paymentapplication'
    When method Get
    Then status 200
