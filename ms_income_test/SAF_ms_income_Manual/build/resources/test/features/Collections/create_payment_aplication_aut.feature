Feature:Create payment application
  As a Financial Services Management
  i need create to collections on the page

  Background:
    Given That the user enter to the page


  @PaymentAplication@Automatization@PaymentAutomatic
  Scenario: Realizar pago forma automatica por el total de las obligaciones
    Given Que se tiene unas ogligaciones  adecuadas  con el siguiente query "Obligation1"
    And Se  ejecuta los cargos financieros para las obligaciones
    When  El usuario crea un pago de forma automatica con los siguiente datos
      |value  |receptionTime|receptionDate|clientReferent|clientBeneficiary|payment |collectionChannel|
      |1730000|05:00 A.M    |07292022     |NIT 220000105 |NIT 220000105    |Efectivo|PSE              |
    And Genera una aplicacion de pago al vencimiento
    Then Deberia ver las obligaciones  canceladas  en su totalidad

  @PaymentAplication@Automatization@PaymentAutomatic
  Scenario: Realizar pago forma automatica por un valor menor al total de las obligaciones
    Given Que se tiene unas ogligaciones  adecuadas  con el siguiente query "Obligation1"
    And  Se  ejecuta los cargos financieros para las obligaciones
    When  El usuario crea un pago de forma automatica con los siguiente datos
      |value  |receptionTime|receptionDate|clientReferent|clientBeneficiary|payment |collectionChannel|
      |1730000|05:00 A.M    |07292022     |NIT 220000105 |NIT 220000105    |Efectivo|PSE              |
    And Genera una aplicacion de pago al vencimiento
    Then Deberia ver las obligaciones  canceladas  parcialmente

  @PaymentAplication@Manual@PaymentAutomatic
  Scenario: Realizar pago forma automatica por  valor mayor al total de  las obligaciones
    Given Que se tiene unas ogligaciones  adecuadas  con el siguiente query "Obligation1"
    And Se  ejecuta los cargos financieros para las obligaciones
    When  El usuario crea un pago de forma automatica con los siguiente datos
      |value  |receptionTime|receptionDate|clientReferent|clientBeneficiary|payment |collectionChannel|
      |1730000|05:00 A.M    |07292022     |NIT 220000105 |NIT 220000105    |Efectivo|PSE              |
    And Genera una aplicacion de pago al vencimiento
    Then Deberia ver las obligaciones  canceladas  en su totalidad
    And  Deberia validar el sobrante de la aplicacion de pago

  @PaymentAplication@Manual@PaymentAutomatic
  Scenario: Realizar pago forma automatica por el valor total a la obligacion con mas dia de mora
    Given Que se tienen unas ogligaciones  adecuadas  con el siguiente query "Obligation1"
    And Se  ejecuta los cargos financieros para las obligaciones
    When  El usuario crea un pago de forma automatica con los siguiente datos
      |value  |receptionTime|receptionDate|clientReferent|clientBeneficiary|payment |collectionChannel|
      |1730000|05:00 A.M    |07292022     |NIT 220000105 |NIT 220000105    |Efectivo|PSE              |
    And Genera una aplicacion de pago al vencimiento
    Then Deberia ver la  obligacion  con mas dias de mora cancelada totalmente
    And  Deberia ver las demas obligaciones sin cancelar


  @PaymentAplication@Manual@PaymentAutomatic
  Scenario: Realizar pago forma automatica por el valor total de las dos obligaciones con mas dias de mora
    Given Que se tienen unas ogligaciones  adecuadas  con el siguiente query "Obligation1"
    And Se  ejecuta los cargos financieros para las obligaciones
    When  El usuario crea un pago de forma automatica con los siguiente datos
      |value  |receptionTime|receptionDate|clientReferent|clientBeneficiary|payment |collectionChannel|
      |1730000|05:00 A.M    |07292022     |NIT 220000105 |NIT 220000105    |Efectivo|PSE              |
    And Genera una aplicacion de pago al vencimiento
    Then Deberia ver las dos  obligaciones  con mas dias de mora cancelada totalmente
    And  Deberia ver las demas obligaciones sin cancelar


  @PaymentAplication@Manual@PaymentAutomatic
  Scenario: Realizar pago forma automatica por la mitad del valor de todas de las obligaciones
    Given Que se tienen unas ogligaciones  adecuadas  con el siguiente query "Obligation1"
    And Se  ejecuta los cargos financieros para las obligaciones
    When  El usuario crea un pago de forma automatica con los siguiente datos
      |value  |receptionTime|receptionDate|clientReferent|clientBeneficiary|payment |collectionChannel|
      |1730000|05:00 A.M    |07292022     |NIT 220000105 |NIT 220000105    |Efectivo|PSE              |
    And Genera una aplicacion de pago al vencimiento
    Then Deberia ver las obligaciones  canceladas  parcialmente


  @PaymentAplication@Manual@PaymentAutomatic
  Scenario: Hacer un pago de forma automatica con una fecha diferente a la fecha de ejecución del proceso y sin cancelar el total de capital, a una obligación que este vencida
    Given Que se tienen unas ogligaciones  adecuadas  con el siguiente query "Obligation2"
    And Se  ejecuta los cargos financieros un dia antes para la obligacion
    When  El usuario crea un pago de forma automatica con los siguiente datos un dia despues
      |value  |receptionTime|receptionDate|clientReferent|clientBeneficiary|payment |collectionChannel|
      |1730000|05:00 A.M    |07292022     |NIT 220000105 |NIT 220000105    |Efectivo|PSE              |
    And Genera una aplicacion de pago al vencimiento
    Then Deberia ver las obligacion en estado inicial
    And Deberia ver un movimiento contable de descausacion de interes de mora

  @PaymentAplication@Manual@PaymentAutomatic
  Scenario: Hacer pago de forma automatica con una fecha diferente a la fecha de ejecución del proceso y sin cancelar el total de capital a una obligación que este entre la fecha neta y fecha vencimiento total
    Given Que se tienen unas ogligaciones  adecuadas  con el siguiente query "Obligation2"
    And Se  ejecuta los cargos financieros un dia antes para la obligaciones
    When  El usuario crea un pago de forma automatica con los siguiente datos un dia despues
      |value  |receptionTime|receptionDate|clientReferent|clientBeneficiary|payment |collectionChannel|
      |1730000|05:00 A.M    |07292022     |NIT 220000105 |NIT 220000105    |Efectivo|PSE              |
    And Genera una aplicacion de pago al vencimiento
    Then Deberia ver las obligacion en estado inicial
    And Deberia ver un movimiento contable de descausacion de interes remuneratorios


  @PaymentAplication@Manual@PaymentAutomatic
  Scenario: Generar un pago con obligaciones que tengan misma  tiempo en mora y con fecha de vencimiento total igual
    Given Que se tienen unas ogligaciones  adecuadas  con el siguiente query "Obligation3"
    And Se  ejecuta los cargos financieros para las obligaciones
    When  El usuario crea un pago de forma automatica con los siguiente datos un dia despues
      |value  |receptionTime|receptionDate|clientReferent|clientBeneficiary|payment |collectionChannel|
      |1730000|05:00 A.M    |07292022     |NIT 220000105 |NIT 220000105    |Efectivo|PSE              |
    And Genera una aplicacion de pago al vencimiento
    Then Deberia ver las obligaciones canceladas
    And Deberia  validar el orden de aplicacion

  @PaymentAplication@Manual@PaymentAutomatic
  Scenario: Generar un pago con obligaciones que tengan misma  tiempo en mora y con fecha de vencimiento neto y total igual
    Given Que se tienen unas ogligaciones  adecuadas  con el siguiente query "Obligation4"
    And Se  ejecuta los cargos financieros para las obligaciones
    When  El usuario crea un pago de forma automatica con los siguiente datos un dia despues
      |value  |receptionTime|receptionDate|clientReferent|clientBeneficiary|payment |collectionChannel|
      |1730000|05:00 A.M    |07292022     |NIT 220000105 |NIT 220000105    |Efectivo|PSE              |
    And Genera una aplicacion de pago al vencimiento
    Then Deberia ver las obligaciones canceladas
    And Deberia  validar el orden de aplicacion


  @PaymentAplication@Manual@PaymentAutomatic
  Scenario: Generar un pago con obligaciones que tengan misma  tiempo en mora y con fecha de vencimiento neto y total igual  ademas con fecha desembolso igual
    Given Que se tienen unas ogligaciones  adecuadas  con el siguiente query "Obligation4"
    And Se  ejecuta los cargos financieros para las obligaciones
    When  El usuario crea un pago de forma automatica con los siguiente datos un dia despues
      |value  |receptionTime|receptionDate|clientReferent|clientBeneficiary|payment |collectionChannel|
      |1730000|05:00 A.M    |07292022     |NIT 220000105 |NIT 220000105    |Efectivo|PSE              |
    And Genera una aplicacion de pago al vencimiento
    Then Deberia ver las obligaciones canceladas
    And Deberia  validar el orden de aplicacion


  @PaymentAplication@Manual@PaymentAutomatic
  Scenario: Cancelar una obligacion 100 % antes del fecha del vencimiento neto con descuento por pronto pago compartido con el pagador
    Given Que se tiene una ogligacion  adecuada  con el siguiente query "Obligation5"
    And Se  ejecuta los cargos financieros para las obligacion
    When  El usuario crea un pago de forma automatica con los siguiente datos
      |value  |receptionTime|receptionDate|clientReferent|clientBeneficiary|payment |collectionChannel|
      |1730000|05:00 A.M    |07292022     |NIT 220000105 |NIT 220000105    |Efectivo|PSE              |
    And Genera una aplicacion de pago al vencimiento
    Then Deberia ver las obligaciones canceladas
    And Deberia validar el cobro GMF del dinero de descuento por pronto pago del pagador

  @PaymentAplication@Manual@PaymentAutomatic
  Scenario: Cancelar una obligacion 100 % antes del fecha del vencimiento neto con descuento por pronto pago compartido con el proveedor
    Given Que se tienen unas ogligaciones  adecuadas  con el siguiente query "Obligation6"
    And Se  ejecuta los cargos financieros para las obligaciones
    When  El usuario crea un pago de forma automatica con los siguiente datos un dia despues
      |value  |receptionTime|receptionDate|clientReferent|clientBeneficiary|payment |collectionChannel|
      |1730000|05:00 A.M    |07292022     |NIT 220000105 |NIT 220000105    |Efectivo|PSE              |
    And Genera una aplicacion de pago al vencimiento
    Then Deberia ver las obligaciones canceladas
    And Deberia validar el  dinero de descuento por pronto pago del proveedor