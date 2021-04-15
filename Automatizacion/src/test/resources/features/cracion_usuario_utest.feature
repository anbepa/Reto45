# language: es
  Característica: yo como usuario de Utest
    necesito registrarme  en la pagina de Utest
    para poder gestionar la cuenta

Escenario:creacion de un nuevo usuario en utest
   Dado que el usuario debe estar pagina de creacion
   Cuando el usuario diligencia el formulario con los datos personales
    |nombres       |apellidos      |correo               |mes        |dia|ano |
    |Andres Antonio|Bernal Padilla |andro11anto@gmail.com|September  |2  |1991|
   Cuando el usuario diligencia el formulario de direccion
     |ciudad       |codigopostal|
     |Barranquilla  |214        |
   Cuando el usuario diligencia el formulario de dispositivos
    |computador       |version |lenguaje|dispositivo|modelo|sistema|
    |Windows          |2000    |Arabic  |Apple      |iPhone|iOS 2.0|
  Cuando el usuario crea la contrasena

   Entonces deberia  visualizar mensaje de creacion



