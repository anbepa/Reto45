package co.com.zeus.certification.saf.tasks;

import co.com.zeus.certification.saf.userinterfaces.MenuPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;


public class AccessMenu implements Task {





    @Override
    public <T extends Actor> void performAs(T actor) {


        actor.attemptsTo(


                WaitUntil.the(MenuPage.BUTTON_GUEST_USER, isVisible()).forNoMoreThan(3000).seconds(),
                Click.on(MenuPage.BUTTON_GUEST_USER)

                );
    }

    public static AccessMenu byGuest() {

        return Tasks.instrumented(AccessMenu.class);
    }

}
