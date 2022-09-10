package com.testautomation.sop.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class BuscarFechaPage {
    public static final Target ENTRADA_FECHA= Target.the("entrada fecha").located(By.id("datePickerMonthYearInput"));
    public static final Target ENTRADA_FECHAHORA= Target.the("entrada fecha y  hora").located(By.id("dateAndTimePickerInput"));
    private BuscarFechaPage(){}


}
