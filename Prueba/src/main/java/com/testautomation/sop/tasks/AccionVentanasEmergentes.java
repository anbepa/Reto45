package com.testautomation.sop.tasks;


import com.testautomation.sop.interaction.Alerts;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.JavaScriptClick;
import net.serenitybdd.screenplay.waits.WaitUntil;
import static com.testautomation.sop.userinterfaces.AlertsPage.*;
import static com.testautomation.sop.userinterfaces.MenuPage.*;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isPresent;


public class AccionVentanasEmergentes implements Task {


    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(

                WaitUntil.the(LINK_MENU_ALERTSFRAME, isPresent()).forNoMoreThan(80).seconds(),
                JavaScriptClick.on(LINK_MENU_ALERTSFRAME),
                JavaScriptClick.on(LINK_MENU_ALERTS),
                  Alerts.deTipo(BOTON_ALERTA,"Click"),
                  Alerts.deTipo(BOTON_ALERTA_TIEMPO, "ClickTime"),
                  Alerts.deTipo(BOTON_ALERTA_CONFIRMAR,"confirm"),
                  Alerts.deTipo(BOTON_ALERTA_ENTRADA, "box")


        );


    }

    public static AccionVentanasEmergentes conDespliegueVentanas() {

        return Tasks.instrumented(AccionVentanasEmergentes.class);
    }


}
