package co.com.bancolombia.certification.test.tasks;

import co.com.bancolombia.certification.test.models.DatosContrasena;
import co.com.bancolombia.certification.test.models.DatosDireccion;
import co.com.bancolombia.certification.test.models.DatosDispositivos;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static co.com.bancolombia.certification.test.userinterfaces.PaginaContrasena.*;
import static co.com.bancolombia.certification.test.userinterfaces.PaginaDireccion.*;
import static co.com.bancolombia.certification.test.userinterfaces.PaginaInicio.BTN_INICIO;
import static co.com.bancolombia.certification.test.userinterfaces.PaginaPersonales.BTN_SIGUIENTE;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isPresent;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class CreacionContrasena implements Task {

     private String contrasena;

    public CreacionContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public static CreacionContrasena conFormulario(String contrasena) {
        return instrumented(CreacionContrasena.class,contrasena);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                Enter.theValue(contrasena).into(TXT_CONTRASENA),
                Enter.theValue(contrasena).into(TXT_CONFIRMACION_CONTRASENA),
                Click.on(TERMINOS_USO),
                Click.on(PRIVACIDAD),
                WaitUntil.the(BTN_SIGUIENTE,isVisible()).forNoMoreThan(100).seconds(),
                Click.on(BTN_SIGUIENTE)

                );

        System.out.println(contrasena);

    }
}
