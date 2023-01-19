package co.com.bancolombia.certification.saf.tasks.login;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;
import static co.com.bancolombia.certification.saf.userinterfaces.menu.LoginPage.*;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;


public class Login implements Task {





    @Override
    public <T extends Actor> void performAs(T actor) {


        String  user = System.getProperty("login.user");
        String  pass = System.getProperty("login.pass");

        actor.attemptsTo(


                WaitUntil.the(USER, isVisible()).forNoMoreThan(3000).seconds(),
                Enter.theValue(user).into(USER),
                Click.on(SIGUIENTE),
                WaitUntil.the(PASS, isVisible()).forNoMoreThan(80).seconds(),
                Enter.theValue(pass).into(PASS),
                Click.on(SIGUIENTE)
                );
    }

    public static Login byDocument() {

        return Tasks.instrumented(Login.class);
    }

}
