Feature: Yo como analista necestio realziar busqueda de informacion

  Scenario: Descargar informacion modulo acerca de nosotros
    Given El usuario deber estar en la pagina de busqyeda
    When Descargar documento Pdf
    Then  Validar que la descarga sea exitosa


