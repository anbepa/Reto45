Feature: Web Tables

    Background:
      Given el usuario esta en la pagina

    @agregarYeliminar
    Scenario Outline: agregar y eliminar  registros de una tabla
      When el usuario agrega un nuevo registro en la tabla diligenciando el formulario con los campos
      |idCaso  |firstName  |lastName  |email  |age   |salary  |department   |
      |<idCaso>|<firstName>|<lastName>|<email>|<age> |<salary>|<department> |
      And  el usuario pueda eliminar cualquier registro que este en la tabla
        |idCaso  |typeSearch  |
        |<idCaso>|<typeSearch>|
      Examples:
        |idCaso  |firstName|lastName  |email                |age|salary  |department|typeSearch|
        |1       |Andres   |Bernal    |andro11anto@gmail.com|30 |5500000 |Magdalena |Cierra    |
        |2       |Felipe   |Bernal    |andro11anto@gmail.com|30 |5500000 |Magdalena |Alden    |
        |3       |Carlos   |Bernal    |andro11anto@gmail.com|30 |5500000 |Magdalena |Carlos    |
