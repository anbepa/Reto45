package com.testautomation.sop.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class TablaDatosPage {
    public static final Target BOTON_NUEVO_DATO= Target.the("boton nuevo dato").located(By.id("addNewRecordButton"));
    public static final Target ENTRADA_BUSQUEDA_DATOS= Target.the("entrada busqueda datos").located(By.id("searchBox"));
    public static final Target BOTON_ELIMINAR_DATOS= Target.the("boton eliminar datos").located(By.xpath("//span[starts-with(@id,'delete-record-')]"));



}
