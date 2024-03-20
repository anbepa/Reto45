Feature: execute a query SQL into database

  Background:
    * def nit = karate.get('nit')
    * def states = karate.get('states')

  Scenario:

    Given path '/client/api/clientsBlocks'
    * params { nit: '#(nit)', states: '#(states)', isAdministrativeBlock: false }
    When method GET
    Then status 200

