Feature: execute a query SQL into database

  Background:
    * def config =  configbd
    * def DbUtils = Java.type('karate.infrastructure.utils.DatabaseConnection')
    * def db = new DbUtils(config)
    * def readQuerys = read('classpath:karate/bloqueos/data/data_base.json')
    * def requestGetIncome =  read('classpath:karate/bloqueos/data/get_income.json')
    * def numberPayment = db.readRow(readQuerys.getIncome)
    * print numberPayment
  Scenario:
    * eval requestGetIncome.number_payment = numberPayment.consecutive_payment
    * print 'Modified requestIncome:', requestGetIncome
    Given path '/income/api/payments/search'
    And request requestGetIncome
    * configure retry = { count: 8, interval: 5000 }
    And retry until response.data.payments[0].status == "APLICACION_PAGO"
    When method POST
    Then status 200
    * match  response.data.payments[0].status == "APLICACION_PAGO"
