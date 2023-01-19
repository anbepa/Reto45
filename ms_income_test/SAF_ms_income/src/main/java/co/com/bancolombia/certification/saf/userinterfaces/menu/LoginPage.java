package co.com.bancolombia.certification.saf.userinterfaces.menu;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class LoginPage {

    public static final Target USER = Target.the("field user").located(By.id("i0116"));
    public static final Target SIGUIENTE = Target.the("button nex").located(By.id("idSIButton9"));
    public static final Target PASS = Target.the("field pass").located(By.id("i0118"));
    public static final Target LOGO_BANCOLOMBIA = Target.the("logo bancolombia").located(By.cssSelector("bc-icon[class ='bc-3xl bc-icon']"));



    private LoginPage() {
    }
}
