Feature:Create payment application
  As a Financial Services Management
 i need create to collections on the page

  Background:
    Given That the user enter to the page


  @PaymentAplication@PaymentManual
  Scenario: Se realizará un pago por valor de $ 720.283.974,01 con el fin de simular la cancelación de 8 obligaciones que abarquen los 5 primeros escenarios de aplicaciones de pago
    Given Que se tiene una ogligacion  adecuada  con el siguientes query "Obligation1"
    And Se  ejecuta los cargos financiero para las obligaciones
    When  El usuario crea un pago de forma uno a uno
    Then Deberia cancelar todas las obligaciones

  @PaymentAplication@PaymentManual
  Scenario: Se realizará un pago por valor de $ 720.283.974,01 con el fin de simular la cancelación de 8 obligaciones que abarquen los 5 primeros escenarios de aplicaciones de pago
    Given Que se tiene una ogligacion  adecuada  con el siguientes query "Obligation1"
    And Se  ejecuta los cargos financiero para las obligaciones
    When  El usuario crea un pago de forma uno a uno
    Then Deberia ver movimientos contables de la aplicacion de pago

  @PaymentAplication@PaymentManual
  Scenario: Se realizará un pago por valor de $ 720.283.974,01 con el fin de simular la cancelación de 8 obligaciones que abarquen los 5 primeros escenarios de aplicaciones de pago
    Given Que se tiene una ogligacion  adecuada  con el siguientes query "Obligation1"
    And Se  ejecuta los cargos financiero para las obligaciones
    When  El usuario crea un pago de forma uno a uno
    Then Deberia ver anulacion de la aplicacion de pago

  @PaymentAplication@PaymentManual
  Scenario: Se realizará un pago por valor de $ 720.283.974,01 con el fin de simular la cancelación de 8 obligaciones que abarquen los 5 primeros escenarios de aplicaciones de pago
    Given Que se tiene una ogligacion  adecuada  con el siguientes query "Obligation1"
    And Se  ejecuta los cargos financiero para las obligaciones
    When  El usuario crea un pago de forma uno a uno
    Then Deberia ver movimientos contables de la anulacion


  @PaymentAplication@PaymentManual
  Scenario: se realizará un segundo pago para simular el escenario 6 de aplicaciones de pago
    Given Que se tiene una ogligacion  adecuada  con el siguientes query "Obligation1"
    And Se  ejecuta los cargos financiero para las obligaciones
    When  El usuario crea un pago de forma uno a uno
    Then Deberia ver la obligacion cancelada
    And la Ultima obligacion con el valor de tolerancia

  @PaymentAplication@PaymentManual
  Scenario: se realizará un segundo pago para simular el escenario 6 de aplicaciones de pago
    Given Que se tiene una ogligacion  adecuada  con el siguientes query "Obligation1"
    And Se  ejecuta los cargos financiero para las obligaciones
    When  El usuario crea un pago de forma uno a uno
    Then Deberia ver movimientos contables de la apliacion del escenario 6

  @PaymentAplication@PaymentManual
  Scenario: se realizará un segundo pago para simular el escenario 6 de aplicaciones de pago
    Given Que se tiene una ogligacion  adecuada  con el siguientes query "Obligation1"
    And Se  ejecuta los cargos financiero para las obligaciones
    When  El usuario crea un pago de forma uno a uno
    Then Deberia ver la obligacion con los  valores originales

  @PaymentAplication@PaymentManual
  Scenario: se realizará un segundo pago para simular el escenario 6 de aplicaciones de pago
    Given Que se tiene una ogligacion  adecuada  con el siguientes query "Obligation1"
    And Se  ejecuta los cargos financiero para las obligaciones
    When  El usuario crea un pago de forma uno a uno
    Then Deberia ver movimientos contables  anulacion de la apliacion del escenario 6



  @PaymentAplication@PaymentManual
  Scenario: se realizará un segundo pago para simular el escenario 7 de aplicaciones de pago
    Given Que se tiene una ogligacion  adecuada  con el siguientes query "Obligation1"
    And Se  ejecuta los cargos financiero para las obligaciones
    When  El usuario crea un pago de forma uno a uno
    Then Deberia ver aplicacion de pago

  @PaymentAplication@PaymentManual
  Scenario: se realizará un segundo pago para simular el escenario 7 de aplicaciones de pago
    Given Que se tiene una ogligacion  adecuada  con el siguientes query "Obligation1"
    And Se  ejecuta los cargos financiero para las obligaciones
    When  El usuario crea un pago de forma uno a uno
    Then Deberia ver la obligacion con los  valores originales

  @PaymentAplication@PaymentManual
  Scenario: se realizará un segundo pago para simular el escenario 7 de aplicaciones de pago
    Given Que se tiene una ogligacion  adecuada  con el siguientes query "Obligation1"
    And Se  ejecuta los cargos financiero para las obligaciones
    When  El usuario crea un pago de forma uno a uno
    Then Deberia ver movimientos contables  anulacion de la apliacion del escenario 6


  @PaymentAplication@PaymentManual
  Scenario: se realizará un segundo pago para simular el escenario 8 de aplicaciones de pago
    Given Que se tiene una ogligacion  adecuada  con el siguientes query "Obligation1"
    And Se  ejecuta los cargos financiero para las obligaciones
    When  El usuario crea un pago de forma uno a uno
    Then Deberia ver movimientos contables de la apliacion del escenario 6

  @PaymentAplication@PaymentManual
  Scenario: se realizará un segundo pago para simular el escenario 8 de aplicaciones de pago
    Given Que se tiene una ogligacion  adecuada  con el siguientes query "Obligation1"
    And Se  ejecuta los cargos financiero para las obligaciones
    When  El usuario crea un pago de forma uno a uno
    Then Deberia ver la obligacion con los  valores originales

  @PaymentAplication@PaymentManual
  Scenario: se realizará un segundo pago para simular el escenario 8 de aplicaciones de pago
    Given Que se tiene una ogligacion  adecuada  con el siguientes query "Obligation1"
    And Se  ejecuta los cargos financiero para las obligaciones
    When  El usuario crea un pago de forma uno a uno
    Then Deberia ver movimientos contables  anulacion de la apliacion del escenario 6






