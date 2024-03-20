Feature: Get clients paginate whit filter

  Background:

    * configure ssl = true
    * def fn = function(rsp) { return Object.keys(rsp.data[0]) }
    * def pause = function(mil){ java.lang.Thread.sleep(mil); return 1; }






  Scenario: Status Ok
    Given url urlBase+'/clients/paginated?page=0&size=5'
    And header Authorization = 'API Key'
    And header api-key = authkey
    When method GET
    Then status 200
    And  match response.status == 'OK'

  Scenario: Filter by id
    Given url urlBase+'/clients/paginated?filter=176766727&page=0&size=5'
    And header Authorization = 'API Key'
    And header api-key = authkey
    When method GET
    Then status 200
    And  match response.status == 'OK'





