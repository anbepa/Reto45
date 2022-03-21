package co.com.bancolombia.certification.test.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static co.com.bancolombia.certification.test.userinterfaces.MenuPage.*;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getDriver;


public class IngresarModulo implements Task {





    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(


                WaitUntil.the(LINK_MENU_ACERCANOSOTROS, isVisible()).forNoMoreThan(80).seconds(),
                Click.on(LINK_MENU_ACERCANOSOTROS),
                WaitUntil.the(LINK_MENU_INFORMACIONCORPO, isVisible()).forNoMoreThan(80).seconds(),
                Click.on(LINK_MENU_INFORMACIONCORPO),
                WaitUntil.the(LINK_MENU_PROVEEDORES, isVisible()).forNoMoreThan(80).seconds(),
                Click.on(LINK_MENU_PROVEEDORES)

                );
    }

    public static IngresarModulo porOpcionMenuNosotros() {

        return Tasks.instrumented(IngresarModulo.class);
    }

}
