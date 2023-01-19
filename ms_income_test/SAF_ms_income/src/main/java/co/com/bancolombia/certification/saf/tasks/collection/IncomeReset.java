package co.com.bancolombia.certification.saf.tasks.collection;

import co.com.bancolombia.certification.saf.models.collection.Data;
import co.com.bancolombia.certification.saf.userinterfaces.collection.SearchIncomePage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;

import java.util.List;
import static co.com.bancolombia.certification.saf.userinterfaces.collection.SearchIncomePage.*;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class IncomeReset implements Task {
    List<Data> information ;

    public IncomeReset(List<Data> information) {
        this.information = information;
    }



    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(


                SearchIncome.on(information),
                WaitUntil.the(SearchIncomePage.OPTION, isVisible()).forNoMoreThan(100).seconds(),
                Click.on(OPTION),
                Click.on(SearchIncomePage.APPLY_ANNULMET),
                Click.on(BUTTON_SELECT_CAUSAL),
                Click.on(SELECT_CAUSAL),
                //Enter.theValue("prueba").into(TEXT_CAUSAL),
                Click.on(BUTTON_ANNULMENT_PAYMENT_APLYCATION),
                Click.on(BUTTON_CONFIR_ANNULMENT_PAYMENT_APLYCATION)

        );
    }
    public static IncomeReset withTheAnnulment(List<Data> information){
        return Tasks.instrumented(IncomeReset.class,information);
    }
}
