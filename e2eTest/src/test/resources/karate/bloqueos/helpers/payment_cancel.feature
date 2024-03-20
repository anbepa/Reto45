Feature: execute a query SQL into database

  Background:
    * def config =  configbd
    * def DbUtils = Java.type('karate.infrastructure.utils.DatabaseConnection')
    * def db = new DbUtils(config)
    * def readQuerys = read('classpath:karate/bloqueos/data/data_base.json')
    * def requestCancelPayment =  read('classpath:karate/bloqueos/data/cancel.json')
    * def paymentIdString = db.readRow(readQuerys.getPaymentRecord)
    * print paymentIdString
  Scenario:
    * eval requestCancelPayment.payment_cancel[0].payment_id = paymentIdString.payment_id
    * print 'Modified requestIncome:', requestCancelPayment
    Given path '/income/api/payments/cancel'
    And request requestCancelPayment
    When method POST
    Then status 200
