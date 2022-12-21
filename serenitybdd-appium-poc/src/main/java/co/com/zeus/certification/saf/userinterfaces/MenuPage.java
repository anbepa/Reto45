package co.com.zeus.certification.saf.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class MenuPage {

    public static final Target BUTTON_GUEST_USER= Target.the("button gues user").located(By.id("com.upax.zeusgeneric:id/zlo_button_guest"));



    private MenuPage() {
    }
}
