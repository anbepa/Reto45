package com.testautomation.sop.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class CrearDatosPage {
    public static final Target ENTRADA_NOMBRE= Target.the("entrada nombre").located(By.id("firstName"));
    public static final Target ENTRADA_APELLIDO= Target.the("entrada apellido").located(By.id("lastName"));
    public static final Target ENTRADA_CORREO= Target.the("entrada correo").located(By.id("userEmail"));
    public static final Target ENTRADA_EDAD= Target.the("entrada edad").located(By.id("age"));
    public static final Target ENTRADA_SALARIO= Target.the("entrada salario").located(By.id("salary"));
    public static final Target ENTRADA_DEPARTAMENTO= Target.the("entrada departamento").located(By.id("department"));
    public static final Target BOTON_GUARDAR_DATOS= Target.the("boton guardar datos").located(By.id("submit"));
    private CrearDatosPage(){}
}
