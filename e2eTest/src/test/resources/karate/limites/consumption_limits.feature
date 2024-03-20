Feature: Obtener límites de consumo de clientes

  Background:

    * url urlBase
    * def readquerys = read('classpath:karate/limites/data/data_base.json')
    * def feedbackList = read('classpath:karate/limites/data/feedback.json')
    * def config =  configbd
    * def DbUtils = Java.type('karate.infrastructure.utils.DatabaseConnection')
    * def db = new DbUtils(config)
    * def dateOfDate = karate.get('java.time.LocalDate.now().toString()')



  Scenario:Consumption limits from disbursement

    # Paso 1 : obtener limites del clientes antes del proceso
    Given path '/client/api/quotafactoring/filter'
    * params { lastApproved: true, clientDocument: '10543546372'}
    When method GET
    Then status 200
    * def responseQuotaFactoringBefore = response.data.filter(obj => obj.productName == "Confirming" && obj.modalityName == "Con recurso")
    * karate.log("Consumed  value before  test: ", responseQuotaFactoringBefore[0].consumedValue)
    * karate.log("Available value before  test: ", responseQuotaFactoringBefore[0].availableValue)

    # Paso 2 : Proceso de adecuación de datos para el test.

    Given def queryResultObligationInvoice = db.readRows(readquerys.GetObligationInvoiceId)
    And   def updateInvoiceHeader = db.update(readquerys.updateInvoiceHeader.replace('application_date =', "application_date = '" + dateOfDate + "'"))
    And   def invoice = queryResultObligationInvoice[0].invoice_id
    And   def obligation = queryResultObligationInvoice[0].obligation_id
    And   def queryInvoiceHeaderid = db.readRow('SELECT invoice_header_id from schsaf.tbl_invoice  where id = ' + invoice)
    * karate.log("Invoice id : ", invoice)
    * karate.log("Obligation id: ", obligation)
    * def queries = ['DELETE FROM schsaf.tbl_accounting_movement_detail th where th.obligation_id = ?','DELETE FROM schsaf.tbl_finance_charges a where a.obligation_id = ?','DELETE FROM schsaf.tbl_obligation_invoice b where b.obligation_id = ?','DELETE FROM schsaf.tbl_obligations p where p.id = ?']
    * eval karate.forEach(queries, function(query){var isDelete = db.delete(obligation, query);karate.log("Record is delete: ", isDelete);})


    # Paso 3: Proceso realizar reinteo desembolso.
    And   path '/disbursement/api/disbursement/' + queryInvoiceHeaderid.invoice_header_id + '/retry/'
    When method PUT
    Then status 200

# Paso 4 : Buscar desembolso en estado finalizado.
    Given path '/disbursement/api/disbursement'
    And  param applicationNumber = '23120000201'
    * configure retry = { count: 10, interval: 50000 }
    And retry until response.data[0].state == "IN_PROCESS"
    When method GET
    Then status 200
    * karate.log("disburment state: ", response.data[0].state)
    *  def valueDisbursement = response.data[0].value
    * karate.log("disburment value: ", valueDisbursement)

    # Paso 5:  obtener limites del clientes despues proceso

    Given path '/client/api/quotafactoring/filter'
    * params { lastApproved: true, clientDocument: '10543546372'}
    When method GET
    Then status 200
    * def responseQuotaFactoringAfter = response.data.filter(obj => obj.productName == "Confirming" && obj.modalityName == "Con recurso")
    * karate.log("Consumed  value before  test: ", responseQuotaFactoringAfter[0].consumedValue)
    * karate.log("Available value before  test: ", responseQuotaFactoringAfter[0].availableValue)

    # Paso 6: Validar los límites después del desembolso

    And match (responseQuotaFactoringBefore[0].consumedValue  + valueDisbursement)  == responseQuotaFactoringAfter[0].consumedValue
    And match (responseQuotaFactoringBefore[0].availableValue - valueDisbursement)  == responseQuotaFactoringAfter[0].availableValue













