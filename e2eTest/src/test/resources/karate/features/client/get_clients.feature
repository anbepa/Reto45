Feature: Get clients

  Background:

    * configure ssl = true
    * def readquerys = read('classpath:sql/Bd.json')
    * def pause = function(mil){ java.lang.Thread.sleep(mil); return 1; }
    * def config =  configbd
    * def DbUtils = Java.type('com.co.bancolombia.util.DbUtils')
    * def db = new DbUtils(config)
    * url urlBase
    *  header Authorization = 'API Key'
   *   header api-key = authkey

  Scenario: Status Ok

    # obtener limites del clientes antes del proceso
    Given path '/client/api/quotafactoring/filter'
    * params { lastApproved: true, clientDocument: '1037748708'}
    When method GET
    Then status 200
    * def GetClientLimitAntes = (response.data[2].consumedValue +100000)
    * print GetClientLimitAntes
#
#    # Proceso de limpia de datos desembolso y aplicaciones
#    Given def queryResultObligationInvoice = db.readRows(readquerys.GetObligationInvoiceId)
#    And   def updateInvoiceHeader = db.update(readquerys.updateInvoiceHeader)
#    And   def conta = queryResultObligationInvoice[0].invoice_id
#    And   print conta
#    And   def qu = db.readRow('SELECT invoice_header_id from schsaf.tbl_invoice  where id = ' + conta)
#    And   def sql = karate.callSingle('classpath:karate/helpers/reset_disbursement_fields.feature', {id: queryResultObligationInvoice[0].obligation_id})
#
#
#    And   path '/disbursement/api/disbursement/' + qu.invoice_header_id + '/retry/'
#    When method PUT
#    Then status 200
#    Given path '/disbursement/api/disbursement'
#    And  param applicationNumber = '23120000201'
#
#    * configure retry = { count: 10, interval: 50000 }
#    And retry until response.data[0].state == "ENDED"
#    When method GET
#    Then status 200
#    * print response.data[0].state
#
#       # obtener limites del clientes despues proceso
#    Given path '/client/api/quotafactoring/filter'
#    * params { lastApproved: true, clientDocument: '1037748708'}
#    When method GET
#    Then status 200
#    * def GetClientLimitDespues = response.data[2].consumedValue
#    * print GetClientLimitDespues
#    And match GetClientLimitAntes != GetClientLimitDespues


    











