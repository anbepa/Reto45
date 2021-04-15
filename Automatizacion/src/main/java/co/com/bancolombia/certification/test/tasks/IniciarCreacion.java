package co.com.bancolombia.certification.test.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

import static co.com.bancolombia.certification.test.userinterfaces.PaginaInicio.BTN_INICIO;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class IniciarCreacion implements Task {


    public static IniciarCreacion enHomePage() {

        return instrumented(IniciarCreacion.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(BTN_INICIO)
        );

    }
}
