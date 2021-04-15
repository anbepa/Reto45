package co.com.bancolombia.certification.test.tasks;

import co.com.bancolombia.certification.test.models.DatosDireccion;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static co.com.bancolombia.certification.test.userinterfaces.PaginaDireccion.*;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isPresent;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class IngresarDatosDireccion implements Task {

     private DatosDireccion  datosDireccion;

     public IngresarDatosDireccion(DatosDireccion datosDireccion) {

        this.datosDireccion = datosDireccion;
    }

    public static IngresarDatosDireccion conFormulario(DatosDireccion datosDireccion) {
        return instrumented(IngresarDatosDireccion.class,datosDireccion);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(

                WaitUntil.the(CONTENEDOR_MAPA,isVisible()).forNoMoreThan(100).seconds(),
                Enter.theValue(datosDireccion.getCiudad()).into(TXT_CIUDAD),
                Click.on(SELECTOR_CIUDAD_1.of(datosDireccion.getCiudad())),
                WaitUntil.the(TXT_CODIGOPOSTAL,isVisible()).forNoMoreThan(100).seconds(),
                Enter.theValue(datosDireccion.getCodigopostal()).into(TXT_CODIGOPOSTAL),
                Click.on(BTN_PROXIMO)

                );
    }
}
