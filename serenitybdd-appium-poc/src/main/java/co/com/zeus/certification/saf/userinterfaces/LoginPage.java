package co.com.zeus.certification.saf.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class LoginPage {

    public static final Target NAME= Target.the("button gues user").located(By.id("com.upax.zeusgeneric:id/zlo_edittext_name"));
    public static final Target MAIL= Target.the("button gues user").located(By.id("com.upax.zeusgeneric:id/zlo_edittext_email"));
    public static final Target PASS= Target.the("button gues user").located(By.id("com.upax.zeusgeneric:id/zlo_edittext_password"));
    public static final Target BUTTON_LOGIN= Target.the("button gues user").located(By.id("com.upax.zeusgeneric:id/zlo_button_login_guest"));
    public static final Target CONTAINER= Target.the("button gues user").located(By.id("com.google.android.apps.nexuslauncher:id/universal_smartspace_container"));
    public static final Target TEXT_ELEMENT= Target.the("button gues user").located(By.xpath("/hierarchy/android.widget.Toast"));



    private LoginPage() {
    }
}
