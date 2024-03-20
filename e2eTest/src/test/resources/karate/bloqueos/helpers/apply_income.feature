Feature: execute a query SQL into database

  Background:
    * def nit = karate.get('nit')
    * def states = karate.get('states')
    * def requestIncome = read('classpath:karate/bloqueos/data/income.json')
    * def paymentReception = karate.get('java.time.LocalDate.now().toString()')


  Scenario:
    * eval requestIncome.payment_reception = paymentReception
    * print 'Modified requestIncome:', requestIncome
    Given path '/income/api/payments'
    And request requestIncome
    When method POST
    Then status 200
    And match response.data != null
