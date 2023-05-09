Feature: payment Add

  Background:
    Given url urlBase
    * def payment = read('classpath:data/create_payment.json')
    * def searchPay = read('classpath:data/payment_search.json')
    * def getTime =
      """
      function() {
        let today = new Date();
        return String(today.getHours()).padStart(2, "0") + ":" + String(today.getMinutes()).padStart(2, "0");
      }
      """

  Scenario: Add an existing payment
    * def payment_data = read('classpath:data/payment_add.json')
    * def sleep = function(pause){ java.lang.Thread.sleep(pause) }
    * eval sleep(2000)
    Given path '/income/api/payments'
    And request payment_data
    When method Post
    Then status 400

  Scenario: Trying to add payment with an after date
    * def getDate = function() {return new Date(Date.now() + (3600 * 1000 * 24)).toJSON().slice(0, 10);}
    * set payment.payment_reception = getDate()
    * set payment.payment_time = getTime()
    * print payment
    * def sleep = function(pause){ java.lang.Thread.sleep(pause) }
    * eval sleep(2000)
    Given path '/income/api/payments'
    And request payment
    When method Post
    Then status 400
