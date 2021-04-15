package co.com.bancolombia.certification.test.tasks;

import co.com.bancolombia.certification.test.models.DatosPersonales;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.SelectFromOptions;


import static co.com.bancolombia.certification.test.userinterfaces.PaginaPersonales.*;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class IngresarDatosPersonales implements Task {

    private  DatosPersonales datosPersonales;

    public IngresarDatosPersonales(DatosPersonales datosPersonales) {

        this.datosPersonales = datosPersonales;
    }

    public static IngresarDatosPersonales conFormulario(DatosPersonales datosPersonales) {
        return instrumented(IngresarDatosPersonales.class,datosPersonales);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                Enter.theValue(datosPersonales.getNombres()).into(TXT_NOMBRES),
                Enter.theValue(datosPersonales.getApellidos()).into(TXT_APELLIDOS),
                Enter.theValue(datosPersonales.getCorreo()).into(TXT_CORREO),
                SelectFromOptions.byVisibleText(datosPersonales.getMes()).from(SELECT_MES),
                SelectFromOptions.byVisibleText(datosPersonales.getDia()).from(SELECT_DIA),
                SelectFromOptions.byVisibleText(datosPersonales.getAno()).from(SELECT_ANO),
                Click.on(BTN_SIGUIENTE)
                );

    }


}
