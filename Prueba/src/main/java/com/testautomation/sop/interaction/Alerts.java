package com.testautomation.sop.interaction;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.JavaScriptClick;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static com.testautomation.sop.utils.EnvironmentConstants.ENTRADA_TEXTO_ALERTA;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getDriver;

public class Alerts implements Interaction {


    private Target elemento;
    String nombreAlerta;


    public Alerts(Target elemento,String nombreAlerta) {
        this.elemento = elemento;
        this.nombreAlerta = nombreAlerta;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                WaitUntil.the(elemento, isVisible()).forNoMoreThan(80).seconds(),
                JavaScriptClick.on(elemento));
        try {
            cambiarAlertas(nombreAlerta);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public static Alerts deTipo(Target elemento,String nombreAlerta){

        return Tasks.instrumented(Alerts.class,elemento,nombreAlerta);
    }

    public void cambiarAlertas(String nombreAlerta) throws InterruptedException {

        switch (nombreAlerta){
            case "Click" :
                getDriver().switchTo().alert().accept();
                break;

            case "ClickTime" :
                Thread.sleep(6000);
                getDriver().switchTo().alert().accept();
                break;

            case "confirm" :
                getDriver().switchTo().alert().dismiss();
                break;

            case "box" :
                getDriver().switchTo().alert().sendKeys(ENTRADA_TEXTO_ALERTA);
                getDriver().switchTo().alert().accept();
                break;

        }
    }


}
