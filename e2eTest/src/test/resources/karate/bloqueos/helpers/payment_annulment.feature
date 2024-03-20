Feature: execute a query SQL into database

  Background:
    * def config =  configbd
    * def DbUtils = Java.type('karate.infrastructure.utils.DatabaseConnection')
    * def db = new DbUtils(config)
    * def readQuerys = read('classpath:karate/bloqueos/data/data_base.json')
    * def requestAnnulmentPayment =  read('classpath:karate/bloqueos/data/annulment.json')
    * def paymentApplicationIds = db.readRow(readQuerys.getAplicationRecord)
    * print paymentApplicationIds
  Scenario:
    * eval requestAnnulmentPayment.paymentApplicationIds = [paymentApplicationIds.payment_application_id]
    * print 'Modified requestIncome:', requestAnnulmentPayment
    Given path '/income/api/payment-annulment'
    And request requestAnnulmentPayment
    When method POST
    Then status 200
    And match response.data != null

