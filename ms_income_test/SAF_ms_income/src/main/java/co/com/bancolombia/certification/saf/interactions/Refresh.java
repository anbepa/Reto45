package co.com.bancolombia.certification.saf.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;

import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getDriver;

public class Refresh implements Interaction {
    @Override
    public <T extends Actor> void performAs(T actor) {
        getDriver().navigate().refresh();
    }

    public static Refresh page() {
        return Tasks.instrumented(Refresh.class);
    }
}
