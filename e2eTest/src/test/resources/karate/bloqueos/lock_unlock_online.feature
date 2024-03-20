Feature: lock unlock online

  Background:
    * url urlBase
    * def readquerys = read('classpath:karate/bloqueos/data/data_base.json')
    * def config =  configbd
    * def DbUtils = Java.type('karate.infrastructure.utils.DatabaseConnection')
    * def db = new DbUtils(config)
    * def dateOfDate = karate.get('java.time.LocalDate.now().toString()')



  Scenario: Automatic blocking  due to delinquency greater than 3 days

    * def threeMonthsAgo = java.time.LocalDate.parse(dateOfDate).minusMonths(3).toString()
    * def twoDaysAgo = java.time.LocalDate.parse(dateOfDate).minusDays(8).toString()
    * def threeDaysAgo = java.time.LocalDate.parse(dateOfDate).minusDays(3).toString()
    * def updateObligation = db.update('UPDATE schsaf.tbl_obligations SET principal_balance = 10000, created_at= \'' + threeMonthsAgo + '\', net_due_date= \'' + twoDaysAgo + '\', total_due_date= \'' + threeDaysAgo + '\', accrued_amortized=0, accrued_remunerative=0, accrued_moratorium=0, remunerative_balance=205473.1, moratorium_balance=42.34, state=\'EXPIRED\' WHERE id = 15177')
    Given def getBlock = karate.callSingle('helpers/get_block.feature', { nit: '999999422', states: 'BLOCKED' })
    * def isDataEmpty = karate.match(getBlock.response.data, []).pass
    * eval
    """
      if (isDataEmpty)  {
        karate.call('helpers/apply_block.feature')
        console.log("Ingreso como desbloqueado")
       }
       else {
         var updateBlocksDetails = db.update(readquerys.updateBlocksDetails);
         var updateBlocks = db.update(readquerys.updateBlocks);
         karate.call('helpers/apply_block.feature')
         console.log("Ingreso como bloqueado")

       }
     """
    *  print isDataEmpty
    *  configure retry = { count: 8, interval: 50000 }
    *  retry until response.data[0].state == "BLOCKED"
    Given path '/client/api/clientsBlocks'
    * params { nit: '999999422', states: 'BLOCKED', isAdministrativeBlock: false }
    When method GET
    Then status 200
    And match  response.data[0].state == "BLOCKED"


  Scenario:Automatic unblocking  due to delinquency greater than 3 days
    When def applyIncome = karate.callSingle('helpers/apply_income.feature')
    And  def getIncome = karate.callSingle('helpers/get_income.feature')
    *  configure retry = { count: 8, interval: 50000 }
    *  retry until response.data[0].state == "UNLOCKED"
    Given path '/client/api/clientsBlocks'
    * params { nit: '999999422', states: 'UNLOCKED', isAdministrativeBlock: false }
    When method GET
    Then status 200
    And match  response.data[0].state == "UNLOCKED"


  Scenario:Automatic blocking due to cancellation of payment application
    When  def paymentAnnulment = karate.callSingle('helpers/payment_annulment.feature')
    And   def paymentCancel = karate.callSingle('helpers/payment_cancel.feature')
    *  configure retry = { count: 8, interval: 50000 }
    *  retry until response.data[0].state == "BLOCKED"
    Given path '/client/api/clientsBlocks'
    * params { nit: '999999422', states: 'BLOCKED', isAdministrativeBlock: false }
    When method GET
    Then status 200
    And match  response.data[0].state == "BLOCKED"



