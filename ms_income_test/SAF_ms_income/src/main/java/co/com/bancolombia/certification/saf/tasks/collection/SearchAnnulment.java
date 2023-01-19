package co.com.bancolombia.certification.saf.tasks.collection;

import co.com.bancolombia.certification.saf.interactions.Wait;
import co.com.bancolombia.certification.saf.models.collection.Data;
import co.com.bancolombia.certification.saf.userinterfaces.collection.MenuCollectionPage;
import co.com.bancolombia.certification.saf.userinterfaces.collection.SearchAnnulmentPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.DoubleClick;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.MoveMouse;
import net.serenitybdd.screenplay.waits.WaitUntil;

import java.util.List;

import static co.com.bancolombia.certification.saf.userinterfaces.collection.ManualRecordIncomePage.SELECT_CLIENT_REFERENT;
import static co.com.bancolombia.certification.saf.userinterfaces.collection.MenuCollectionPage.*;
import static co.com.bancolombia.certification.saf.userinterfaces.collection.SearchAnnulmentPage.*;
import static co.com.bancolombia.certification.saf.userinterfaces.collection.SearchIncomePage.BTN_SELECT_REFERENT;
import static co.com.bancolombia.certification.saf.userinterfaces.menu.LoginPage.LOGO_BANCOLOMBIA;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class SearchAnnulment implements Task {
    List<Data> information;
    String numberIncome ;




    public SearchAnnulment(List<Data> information,String numberIncome) {

        this.information = information;
        this.numberIncome = numberIncome;
    }



    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                //Wait.aTime(15000),
                WaitUntil.the(LOGO_BANCOLOMBIA, isVisible()),
                WaitUntil.the(OPTION_OPERATION, isVisible()).forNoMoreThan(200).seconds(),
                MoveMouse.to(OPTION_CLIENT),
                MoveMouse.to(OPTION_OPERATION),
                Click.on(MenuCollectionPage.OPTION_ANNULMENT),


                Enter.theValue(information.get(0).getIncomeDate()).into(INPUT_PAYMENT_DATE),
                //Click.on(BUTTON_NUMBER_APPLICATION),
               // Click.on(SELECT_NUMBER_APPLICATION_ANNULMENT.of(numberIncome)),
               // Enter.theValue(numberIncome).into(SELECT_NUMBER_APPLICATION),
                Click.on(BUTTON_SEARCH_ANNULMENT),
                Click.on(SearchAnnulmentPage.OPTION_ANNULMENT),
                WaitUntil.the(CLICK_ANNULMENT, isVisible()).forNoMoreThan(80).seconds(),
                Click.on(CLICK_ANNULMENT),
                Click.on(SearchAnnulmentPage.OPTION_INSTRUCCION),
                Click.on(SearchAnnulmentPage.TEXT_INSTRUCCION.of(information.get(0).getTypeAnnulment())),
                Enter.theValue(information.get(0).getReasonAnnulment()).into(SearchAnnulmentPage.ANNULMENT_DESCRIPTION),
                Click.on(SearchAnnulmentPage.BUTTON_CONTINUE)

        );
    }
    public static SearchAnnulment on(List<Data> information,String numberIncome){
        return Tasks.instrumented(SearchAnnulment.class,information,numberIncome);
    }
}
