
##**README SERENITY APPIUM**

##**Run tests with gradle:**

```
./gradlew clean test
```



##**Antes de ejecutar tener las siguientes consideraciones:**

```
1. cambiar la ruta  donde esta el apk, el apk esta ubicado en archivo serenity.properties
Ejemplo:
C:\\Users\\22\\Documents\\appium\\serenitybdd-appium-poc\\src\\test\\resources\\Tareas Zeus_6.1.6_Apkpure.apk
cambiar "C:\\Users\\22\\Documents\\appium\\" por la ruta absolute del pc donde se ejecute el Scrips

2. se debe descargar apk de Zeus ya que al tiene un gran tamaño para subir a git

3. despues descargado guardar el archivo en la ruta del proyecto : serenitybdd-appium-poc\\src\\test\\resources\\

2. despues por consola ejecutar el siguiente comando ./gradlew clean test en caso que no  tenga gradle instalado
ejecutar la clase runner CucumberTestSuite
```

