Feature: execute a query SQL into database

  Background:
    * def config =  configbd
    * def DbUtils = Java.type('com.co.bancolombia.util.DbUtils')
    * def db = new DbUtils(config)
    * def threeMonthsAgo = karate.get('threeMonthsAgo')
    * def twoDaysAgo = karate.get('twoDaysAgo')
    * def threeDaysAgo = karate.get('threeDaysAgo')





  Scenario:
    * def month = java.time.LocalDate.parse(dateOfDate).minusMonths(threeMonthsAgo).toString()
    * def day = java.time.LocalDate.parse(dateOfDate).minusDays(3).toString()
    * def updateObligation = 'UPDATE schsaf.tbl_obligations SET principal_balance = 10000, created_at= \'' + threeMonthsAgo + '\', net_due_date= \'' + twoDaysAgo + '\', total_due_date= \'' + threeDaysAgo + '\', accrued_amortized=0, accrued_remunerative=0, accrued_moratorium=0, remunerative_balance=205473.1, moratorium_balance=42.34, state=\'EXPIRED\' WHERE id = 15177'

    * def query = 'delete from '+table+' where '+whereAttr+' = ?'
    * print query
    * def estaEliminado = db.delete(id, query)
    * print estaEliminado
