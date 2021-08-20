package com.testautomation.sop.tasks;


import com.testautomation.sop.models.WidgetsFechaHoraModel;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;
import static com.testautomation.sop.userinterfaces.BuscarFechaPage.ENTRADA_FECHAHORA;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isPresent;


public class BuscarFechaHora implements Task {


    private WidgetsFechaHoraModel widgetsFechaModel;

    public BuscarFechaHora(WidgetsFechaHoraModel widgetsFechaModel) {
        this.widgetsFechaModel = widgetsFechaModel;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(

                WaitUntil.the(ENTRADA_FECHAHORA, isPresent()).forNoMoreThan(80).seconds(),
                Enter.theValue(widgetsFechaModel.getDateAndTime()).into(ENTRADA_FECHAHORA)

        );


    }

    public static BuscarFechaHora registrandoFechaHora(WidgetsFechaHoraModel widgetsFechaModel) {

        return Tasks.instrumented(BuscarFechaHora.class,widgetsFechaModel);
    }


}
