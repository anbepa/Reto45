Feature: execute a query SQL into database

  Background:
    * def config =  configbd
    * def DbUtils = Java.type('com.co.bancolombia.util.DbUtils')
    * def db = new DbUtils(config)
    * def id = karate.get('id')
    * print id

  Scenario:
    * def queries = ['DELETE FROM schsaf.tbl_accounting_movement_detail th where th.obligation_id = ?','DELETE FROM schsaf.tbl_finance_charges a where a.obligation_id = ?','DELETE FROM schsaf.tbl_obligation_invoice b where b.obligation_id = ?','DELETE FROM schsaf.tbl_obligations p where p.id = ?']
  # Iterar a través de las consultas y llamar a db.delete con cada una
    * eval karate.forEach(queries, function(query){var estaEliminado = db.delete(id, query);karate.log("Esta eliminado: ", estaEliminado);})