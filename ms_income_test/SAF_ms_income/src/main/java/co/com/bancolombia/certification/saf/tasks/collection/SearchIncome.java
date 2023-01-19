package co.com.bancolombia.certification.saf.tasks.collection;

import co.com.bancolombia.certification.saf.interactions.Wait;
import co.com.bancolombia.certification.saf.models.collection.Data;
import co.com.bancolombia.certification.saf.questions.collection.StatusText;
import co.com.bancolombia.certification.saf.userinterfaces.collection.MenuCollectionPage;
import co.com.bancolombia.certification.saf.userinterfaces.collection.SearchIncomePage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.*;
import net.serenitybdd.screenplay.waits.WaitUntil;

import java.util.List;
import static co.com.bancolombia.certification.saf.userinterfaces.collection.ManualRecordIncomePage.*;
import static co.com.bancolombia.certification.saf.userinterfaces.collection.MenuCollectionPage.OPTION_OPERATION;
import static co.com.bancolombia.certification.saf.userinterfaces.collection.SearchAnnulmentPage.TEXT_STATE_INCOME;
import static co.com.bancolombia.certification.saf.userinterfaces.collection.SearchIncomePage.*;
import static co.com.bancolombia.certification.saf.userinterfaces.menu.LoginPage.LOGO_BANCOLOMBIA;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class SearchIncome implements Task {
List<Data> information;

    public SearchIncome(List<Data> information) {
        this.information = information;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                Wait.aTime(2000),
                WaitUntil.the(LOGO_BANCOLOMBIA, isVisible()),
                WaitUntil.the(OPTION_OPERATION, isVisible()).forNoMoreThan(200).seconds(),
                MoveMouse.to(OPTION_OPERATION),
                Click.on(MenuCollectionPage.OPTION_COLLECTION),
                WaitUntil.the(SELECT_DATE_INCOME, isVisible()).forNoMoreThan(80).seconds(),
                Enter.theValue(information.get(0).getReceptionDate()).into(SELECT_DATE_INCOME),
                Click.on(BTN_SELECT_REFERENT),
                Click.on(SELECT_CLIENT_REFERENT.of(information.get(0).getClientReferent().trim())),
                Click.on(BTN_SELECT_BENEFICIARY),
                Click.on(SELECT_CLIENT_BENEFICIARY.of(information.get(0).getClientBeneficiary())),
                Click.on(OPTION_SEARCH_ADVANCED),
                Click.on(BTN_SELECT_STATE),
                Click.on(SELECT_STATE_ANNULMNET),
                WaitUntil.the(SEARCH, isClickable()).forNoMoreThan(80).seconds(),
                JavaScriptClick.on(SearchIncomePage.SEARCH)

        );
        Wait.aTime(1000);
        theActorInTheSpotlight().attemptsTo(WaitUntil.the(TEXT_STATE_INCOME, isVisible()).forNoMoreThan(200).seconds());
        theActorInTheSpotlight().remember("textIncome",StatusText.income(TEXT_STATE_INCOME));

    }
    public static SearchIncome on(List<Data> information){

        return Tasks.instrumented(SearchIncome.class,information);
    }

}
