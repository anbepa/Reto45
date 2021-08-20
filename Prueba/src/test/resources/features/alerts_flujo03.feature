Feature: Alerts Frames

    Background:
      Given el usuario esta en la pagina


    Scenario Outline: interactuar con ventanas emergentes
      When usuario interactua con las  ventanas emergentes activando y desactivando <"idCaso">
      Examples:
        |idCaso  |
        |1       |


