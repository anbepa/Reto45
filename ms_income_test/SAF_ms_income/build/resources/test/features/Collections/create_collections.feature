Feature:Create payment application
  As a Financial Services Management
 i need create to collections on the page

  Background:
    Given That the user enter to the page

#  @UserStory=280090
#  Scenario: Realizar un pago de forma manual uno a uno para cancelar 5 obligaciones que simulen el proceso de aplicacion de pago
#    Given Que se tiene unas ogligaciones  adecuadas  "Obligation1"
#    And Se  ejecuta los cargos financieros para las obligaciones
#    When  El usuario crea un recaudo manual uno a uno con los siguientes datos
#      |value         |receptionTime        |receptionDate        |clientReferent   |clientBeneficiary  |payment  |collectionChannel       |
#      |#{E2E-Value}# |#{E2E-ReceptionTime}#|#{E2E-ReceptionDate}#|8506902438       |8506902438         |Efectivo|Sucursal virtual empresas|
#    Then Deberia de visualizar  las 5 obligaciones en estado cancelado en la base de datos de SAF
#
#  @UserStory=280090
#  Scenario: Realizar anulacion de un aplicacion de pago realizado de forma manual uno a uno que simulan el proceso de aplicacion
#    When El usuario  busca y anula  la aplicacion de pago con los siguientes datos
#      |incomeDate            |typeAnnulment                |reasonAnnulment |clientReferent |clientBeneficiary |receptionDate        |
#      |#{E2E-ReceptionDate}# |Ingreso no abonado en cuenta |Prueba          |8506902438     |8506902438        |#{E2E-ReceptionDate}#|
#    Then Deberia ver las obligaciones en sus estados iniciales antes de realizar el proceso de aplicacion de pago

  @UserStory=2800901
  Scenario: Realizar un pago de forma manual uno a uno para cancelar 5 obligaciones que simulen el proceso de aplicacion de pago
    Given Que se tiene unas ogligaciones  adecuadas  "Obligation1"
    And Se  ejecuta los cargos financieros para las obligaciones
    When  El usuario crea un recaudo manual uno a uno con los siguientes datos
      |value         |receptionTime        |receptionDate        |clientReferent   |clientBeneficiary  |payment  |collectionChannel       |
      |565404132     |12:00 A.M            |12192022             |8506902438       |8506902438         |Efectivo|Sucursal virtual empresas|
    Then Deberia de visualizar  las 5 obligaciones en estado cancelado en la base de datos de SAF

  @UserStory=280090
  Scenario: Realizar anulacion de un aplicacion de pago realizado de forma manual uno a uno que simulan el proceso de aplicacion de pago
    When El usuario  busca y anula  la aplicacion de pago con los siguientes datos
      |incomeDate            |typeAnnulment                |reasonAnnulment |clientReferent |clientBeneficiary |receptionDate        |
      |12192022              |Ingreso no abonado en cuenta |Prueba          |8506902438     |8506902438        |12192022             |
    Then Deberia ver las obligaciones en sus estados iniciales antes de realizar el proceso de aplicacion de pago
