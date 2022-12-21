package co.com.zeus.certification.saf.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

import static co.com.zeus.certification.saf.userinterfaces.LoginPage.*;


public class Login implements Task {

    private String name;
    private String mail;
    private String pass;

    public Login(String name, String mail, String pass) {
        this.name = name;
        this.mail = mail;
        this.pass = pass;
    }




    @Override
    public <T extends Actor> void performAs(T actor) {


        actor.attemptsTo(


                Enter.theValue(name).into(NAME),
                Enter.theValue(mail).into(MAIL),
                Enter.theValue(pass).into(PASS),
                Click.on(BUTTON_LOGIN)

                );
    }

    public static Login guest(String name, String mail, String pass) {

        return Tasks.instrumented(Login.class,name,mail,pass);
    }

}
