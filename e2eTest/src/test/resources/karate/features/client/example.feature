Feature: Get clients paginate whit filter

  Background:

    * configure ssl = true
    * def fn = function(rsp) { return Object.keys(rsp.data[0]) }
    * def pause = function(mil){ java.lang.Thread.sleep(mil); return 1; }
    * def bodyRequest= read('classpath:data/adp_login.json')
  Scenario: Status Ok
    * print bodyRequest
    * def config =  configbd
    * def DbUtils = Java.type('com.co.bancolombia.util.DbUtils')
    * def db = new DbUtils(config)
    * def assertPago = db.readRows(bodyRequest.obligation)
    * print assertPago







