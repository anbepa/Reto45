package com.testautomation.sop.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import static com.testautomation.sop.userinterfaces.TablaDatosPage.BOTON_ELIMINAR_DATOS;


public class EliminarDatosTabla implements Task {


    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(

                Click.on(BOTON_ELIMINAR_DATOS)

        );

    }

    public static EliminarDatosTabla conBoton() {

        return Tasks.instrumented(EliminarDatosTabla.class);
    }


}
