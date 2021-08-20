Feature: Data Picker

    Background:
      Given el usuario esta en la pagina

    @seleccionarCalendario
    Scenario Outline: seleccionar fechas
      When el usuario selecciona fecha
        |idCaso  |selectDate|
        |<idCaso>|<selectDate>|
      And fecha con hora
        |idCaso  |dateAndTime  |
        |<idCaso>|<dateAndTime>|

      Examples:
        |idCaso  |selectDate|dateAndTime             |
        |1       |08/18/2021|August 18, 2021 10:22 PM|
        |2       |08/18/2021|August 18, 2021 10:22 PM|
        |3       |08/18/2021|August 18, 2021 10:22 PM|

