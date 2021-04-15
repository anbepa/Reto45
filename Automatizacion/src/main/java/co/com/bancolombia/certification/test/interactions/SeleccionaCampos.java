package co.com.bancolombia.certification.test.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static co.com.bancolombia.certification.test.userinterfaces.PaginaDireccion.CONTENEDOR_MAPA;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class SeleccionaCampos implements Interaction {

    private  Target locaClick;
    private  Target locaIngresar;
    private  String dato;
    private  Target locaSeleccionar;

    public SeleccionaCampos(Target locaClick, Target locaIngresar, String dato, Target locaSeleccionar) {
        this.locaClick = locaClick;
        this.locaIngresar = locaIngresar;
        this.dato = dato;
        this.locaSeleccionar = locaSeleccionar;
    }

    public static SeleccionaCampos deFormularioDispositivos(Target locaClick,Target locaIngresar,String dato,Target locaSeleccionar) {
        return instrumented(SeleccionaCampos.class,locaClick,locaIngresar,dato,locaSeleccionar);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                WaitUntil.the(locaClick,isVisible()).forNoMoreThan(100).seconds(),
                Click.on(locaClick),
                Enter.theValue(dato).into(locaIngresar),
                Click.on(locaSeleccionar)
        );

    }
}
