Feature: Flujos automatizados

  Background:
    Given el usuario esta en la pagina


  Scenario Outline: Interactuar con ventanas emergentes
    When usuario interactua con las  ventanas emergentes activando y desactivando <"idCaso">
    Examples:
      |idCaso|
      |1     |
      |2     |


  Scenario Outline: Agregar y eliminar  registros de una tabla
    When el usuario agrega un nuevo registro en la tabla diligenciando el formulario con los campos <idEscenario> <Csv>
    And  el usuario pueda eliminar cualquier registro que este en la tabla <idEscenario> <Csv>
    Examples:
      |idEscenario |Csv            |
      |1           |DatosPruebaForm|
      |2           |DatosPruebaForm|



  Scenario Outline: Seleccionar fechas
    When el usuario selecciona fecha <idEscenario> <Csv>
    And fecha con hora <idEscenario> <Csv>
    Examples:
      |idEscenario |Csv            |
      |1           |DatosPruebaForm|
      |2           |DatosPruebaForm|




