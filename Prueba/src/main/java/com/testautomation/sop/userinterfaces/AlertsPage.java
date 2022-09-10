package com.testautomation.sop.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class AlertsPage {
    public static final Target BOTON_ALERTA= Target.the("boton alerta").located(By.id("alertButton"));
    public static final Target BOTON_ALERTA_TIEMPO= Target.the("boton alerta tiempo").located(By.id("timerAlertButton"));
    public static final Target BOTON_ALERTA_CONFIRMAR= Target.the("boton alerta confirmar").located(By.id("confirmButton"));
    public static final Target BOTON_ALERTA_ENTRADA= Target.the("boton alerta entrada").located(By.id("promtButton"));
    private AlertsPage(){}
}


