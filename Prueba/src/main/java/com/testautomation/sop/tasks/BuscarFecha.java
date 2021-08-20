package com.testautomation.sop.tasks;

import com.testautomation.sop.models.WidgetsFechaModel;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.JavaScriptClick;
import net.serenitybdd.screenplay.waits.WaitUntil;
import static com.testautomation.sop.userinterfaces.BuscarFechaPage.*;
import static com.testautomation.sop.userinterfaces.MenuPage.*;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isPresent;


public class BuscarFecha implements Task {


    private WidgetsFechaModel widgetsFechaModel;

    public BuscarFecha(WidgetsFechaModel widgetsFechaModel) {
        this.widgetsFechaModel = widgetsFechaModel;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(

                WaitUntil.the(LINK_MENU_WIDGETS, isPresent()).forNoMoreThan(80).seconds(),
                JavaScriptClick.on(LINK_MENU_WIDGETS),
                JavaScriptClick.on(LINK_MENU_DATAPICKER),
                Enter.theValue(widgetsFechaModel.getSelectDate()).into(ENTRADA_FECHA)

        );


    }

    public static BuscarFecha registrandoSoloFecha(WidgetsFechaModel widgetsFechaModel) {

        return Tasks.instrumented(BuscarFecha.class,widgetsFechaModel);
    }


}