package co.com.bancolombia.certification.saf.tasks.collection;

import co.com.bancolombia.certification.saf.interactions.Wait;
import co.com.bancolombia.certification.saf.userinterfaces.collection.MenuCollectionPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.DoubleClick;
import net.serenitybdd.screenplay.actions.SendKeys;
import net.serenitybdd.screenplay.waits.WaitUntil;

import java.io.File;
import static co.com.bancolombia.certification.saf.userinterfaces.collection.MenuCollectionPage.OPTION_OPERATION;
import static co.com.bancolombia.certification.saf.userinterfaces.collection.RecordMassiveIncomePage.*;
import static co.com.bancolombia.certification.saf.userinterfaces.menu.LoginPage.LOGO_BANCOLOMBIA;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class CreateCollectionMassive implements Task {


    @Override
    public <T extends Actor> void performAs(T actor) {

        File file =new File("src/test/resources/DataDriven/recaudos.xls");
        String path  = file.getAbsolutePath();

        actor.attemptsTo(
                WaitUntil.the(LOGO_BANCOLOMBIA, isVisible()),
                Wait.aTime(20000),
              //WaitUntil.the(OPTION_OPERATION, isVisible()).forNoMoreThan(80).seconds(),
                DoubleClick.on(OPTION_OPERATION),
                Click.on(MenuCollectionPage.OPTION_COLLECTION),
                Click.on(MenuCollectionPage.BUTTON_COLLECTION),
                Click.on(MenuCollectionPage.SELECT_SINGLE_MASSIVE_LOAD),
                Click.on(MenuCollectionPage.SELECT_NEXT),
                SendKeys.of(path).into(INPUTFILE),
                WaitUntil.the(REGISTERMASSIVE, isVisible()).forNoMoreThan(80).seconds(),
                Click.on(REGISTERMASSIVE),
                Click.on(CONFIRMINGREGISTERMASSIVE),
                Wait.aTime(10000)
        );


    }
    public static CreateCollectionMassive withFile(){
        return Tasks.instrumented(CreateCollectionMassive.class);
    }
}
