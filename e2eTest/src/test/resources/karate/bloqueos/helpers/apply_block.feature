Feature: execute a query SQL into database

  Background:
    * def dateOfDate = karate.get('java.time.LocalDate.now().toString()')

  Scenario:
    # obtener limites del clientes antes del proceso
    Given path '/obligation/api/process'
    * params { PROCESS: 'OBLIGATION_DEFAULT_3_BLOCK', executionDate: #(dateOfDate) }
    When method POST
    Then status 200
    * print response
    And match response == 'Proceso_exitoso'

