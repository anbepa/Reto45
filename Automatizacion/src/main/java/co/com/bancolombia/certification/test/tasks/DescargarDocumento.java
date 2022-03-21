package co.com.bancolombia.certification.test.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.JavaScriptClick;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static co.com.bancolombia.certification.test.userinterfaces.DescargaPage.LINK_DESCARGARDOCUMENTO;
import static co.com.bancolombia.certification.test.userinterfaces.MenuPage.*;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;


public class DescargarDocumento implements Task {





    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(


                WaitUntil.the(LINK_DESCARGARDOCUMENTO, isVisible()).forNoMoreThan(80).seconds(),
                Click.on(LINK_DESCARGARDOCUMENTO)


                );
    }

    public static DescargarDocumento policasTratamiento() {

        return Tasks.instrumented(DescargarDocumento.class);
    }

}
