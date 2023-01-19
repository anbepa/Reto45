package co.com.bancolombia.certification.saf.tasks.collection;

import co.com.bancolombia.certification.saf.interactions.Wait;
import co.com.bancolombia.certification.saf.models.collection.Data;
import co.com.bancolombia.certification.saf.userinterfaces.collection.MenuCollectionPage;
import co.com.bancolombia.certification.saf.userinterfaces.collection.SearchAnnulmentPage;
import co.com.bancolombia.certification.saf.userinterfaces.collection.SearchIncomePage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.*;
import net.serenitybdd.screenplay.waits.WaitUntil;

import java.util.List;

import static co.com.bancolombia.certification.saf.userinterfaces.collection.CollectionAnnulmentPage.COLLECTION_ANNULMENT;
import static co.com.bancolombia.certification.saf.userinterfaces.collection.ManualRecordIncomePage.SELECT_CLIENT_BENEFICIARY;
import static co.com.bancolombia.certification.saf.userinterfaces.collection.ManualRecordIncomePage.SELECT_CLIENT_REFERENT;
import static co.com.bancolombia.certification.saf.userinterfaces.collection.MenuCollectionPage.*;
import static co.com.bancolombia.certification.saf.userinterfaces.collection.SearchAnnulmentPage.CLICK_ANNULMENT;
import static co.com.bancolombia.certification.saf.userinterfaces.collection.SearchAnnulmentPage.SELECT_NUMBER_APPLICATION;
import static co.com.bancolombia.certification.saf.userinterfaces.collection.SearchIncomePage.*;
import static co.com.bancolombia.certification.saf.userinterfaces.collection.SearchIncomePage.SELECT_STATE_ANNULMNET;
import static co.com.bancolombia.certification.saf.userinterfaces.menu.LoginPage.LOGO_BANCOLOMBIA;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class CollectionAnnulment implements Task {

    String numberIncome ;




    public CollectionAnnulment( String numberIncome) {

        this.numberIncome = numberIncome;
    }



    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(LOGO_BANCOLOMBIA, isVisible()),
                WaitUntil.the(OPTION_OPERATION, isVisible()).forNoMoreThan(200).seconds(),
                MoveMouse.to(OPTION_CLIENT),
                MoveMouse.to(OPTION_OPERATION),
                WaitUntil.the(OPTION_COLLECTION, isVisible()),
                Click.on(MenuCollectionPage.OPTION_COLLECTION),
                WaitUntil.the(OPTION_SEARCH_ADVANCED, isVisible()),
                Click.on(OPTION_SEARCH_ADVANCED),
                WaitUntil.the(SearchIncomePage.NUMBER_COLLECTION, isVisible()).forNoMoreThan(100).seconds(),
                Enter.theValue(numberIncome).into(SearchIncomePage.NUMBER_COLLECTION),
                Click.on(SearchIncomePage.SEARCH),
                WaitUntil.the(SearchIncomePage.BUTTON_ANNULMENT_INCOME, isVisible()),
                Scroll.to(SCROLL_),
                Click.on(BUTTON_ANNULMENT_INCOME),
                Click.on(SearchIncomePage.APPLY_ANNULMET),
                Click.on(BUTTON_SELECT_CAUSAL),
                Click.on(SELECT_CAUSAL),
                //Enter.theValue("prueba").into(TEXT_CAUSAL),
                Click.on(BUTTON_ANNULMENT_PAYMENT_APLYCATION),
                Click.on(BUTTON_CONFIR_ANNULMENT_PAYMENT_APLYCATION)

        );
    }
    public static CollectionAnnulment on(String numberIncome){
        return Tasks.instrumented(CollectionAnnulment.class,numberIncome);
    }
}
