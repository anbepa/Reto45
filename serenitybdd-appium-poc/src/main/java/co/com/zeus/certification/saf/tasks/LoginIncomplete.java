package co.com.zeus.certification.saf.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;

import static co.com.zeus.certification.saf.userinterfaces.LoginPage.*;


public class LoginIncomplete implements Task {


    @Override
    public <T extends Actor> void performAs(T actor) {


        actor.attemptsTo(

                Click.on(BUTTON_LOGIN)

                );
    }

    public static LoginIncomplete form() {

        return Tasks.instrumented(LoginIncomplete.class);
    }

}
