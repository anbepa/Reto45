package co.com.bancolombia.certification.saf.tasks.collection;

import co.com.bancolombia.certification.saf.models.collection.Data;
import co.com.bancolombia.certification.saf.userinterfaces.collection.MenuCollectionPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.DoubleClick;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.serenitybdd.screenplay.actions.MoveMouse;
import java.util.List;

import static co.com.bancolombia.certification.saf.userinterfaces.collection.ManualRecordIncomePage.*;
import static co.com.bancolombia.certification.saf.userinterfaces.collection.MenuCollectionPage.BUTTON_COLLECTION;
import static co.com.bancolombia.certification.saf.userinterfaces.collection.MenuCollectionPage.OPTION_OPERATION;
import static co.com.bancolombia.certification.saf.userinterfaces.menu.LoginPage.LOGO_BANCOLOMBIA;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class CreateCollection implements Task {
   List<Data> information;

    public CreateCollection(List<Data> information) {
        this.information = information;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(LOGO_BANCOLOMBIA, isVisible()),
                WaitUntil.the(OPTION_OPERATION, isVisible()).forNoMoreThan(200).seconds(),
                MoveMouse.to(OPTION_OPERATION),
                Click.on(MenuCollectionPage.OPTION_COLLECTION),
                WaitUntil.the(BUTTON_COLLECTION, isVisible()).forNoMoreThan(100).seconds(),
                Click.on(BUTTON_COLLECTION),
                Click.on(MenuCollectionPage.SELECT_SINGLE_LOAD),
                Click.on(MenuCollectionPage.SELECT_NEXT),
                WaitUntil.the(SELECT_DATE, isVisible()).forNoMoreThan(80).seconds(),
                Enter.theValue(information.get(0).getReceptionDate()).into(SELECT_DATE),
                Click.on(OPTION_HOUR),
                Click.on(SELECT_HOUR.of(information.get(0).getReceptionTime())),
                WaitUntil.the(OPTION_CITY, isVisible()).forNoMoreThan(80).seconds(),
                Click.on(OPTION_CITY),
                WaitUntil.the(SELECT_CITY, isVisible()).forNoMoreThan(80).seconds(),
                Click.on(SELECT_CITY),
                Click.on(CLIENT_REFERENT),
                Click.on(SELECT_CLIENT_REFERENT.of(information.get(0).getClientReferent())),
                Click.on(OPTION_CLIENT_BENEFICIARY),
                Click.on(SELECT_CLIENT_BENEFICIARY.of(information.get(0).getClientBeneficiary())),
                Click.on(OPTION_SELECT_PAYMENT),
                Click.on(SELECT_PAYMENT.of(information.get(0).getPayment())),
                Click.on(OPTION_MONEY),
                Click.on(SELECT_MONEY),
                Enter.theValue(information.get(0).getValue()).into(VALUE_COLLECTION),
                Click.on(CHANNEL_COLLECTION),
                Click.on(SELECT_JUSTIFICATION),
                Click.on(OPTION_JUSTIFICATION),
                Click.on(SELECT_CHANNEL.of(information.get(0).getCollectionChannel())),
                Click.on(REGISTRATION),
                Click.on(CONFIRMATION)
        );
    }
    public static CreateCollection withManualRegistration(List<Data> information){
        return Tasks.instrumented(CreateCollection.class,information);
    }
}
