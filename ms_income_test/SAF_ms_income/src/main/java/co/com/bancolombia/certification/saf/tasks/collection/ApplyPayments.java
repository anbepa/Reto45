package co.com.bancolombia.certification.saf.tasks.collection;

import co.com.bancolombia.certification.saf.interactions.Wait;
import co.com.bancolombia.certification.saf.userinterfaces.collection.SearchIncomePage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static co.com.bancolombia.certification.saf.userinterfaces.collection.SearchIncomePage.OPTION;
import static co.com.bancolombia.certification.saf.userinterfaces.menu.LoginPage.LOGO_BANCOLOMBIA;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class ApplyPayments implements Task {


    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                WaitUntil.the(LOGO_BANCOLOMBIA, isVisible()),
                WaitUntil.the(SearchIncomePage.OPTION, isVisible()).forNoMoreThan(100).seconds(),
                Click.on(OPTION),
                Click.on(SearchIncomePage.APPLY_COLLECTION),
                Click.on(SearchIncomePage.OPTION_APPLY),
                Click.on(SearchIncomePage.SELECT_OPTION),
                Click.on(SearchIncomePage.BUTTON_APPLY),
                Wait.aTime(20000)
        );
    }
    public static ApplyPayments onScenarios(){

        return Tasks.instrumented(ApplyPayments.class);
    }
}
