package co.com.bancolombia.certification.test.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class PaginaInicio {
    public static final Target BTN_INICIO = Target.the("boton para ingresar al formulario de registro").located(By.cssSelector("a[href='/signup/personal'][class='unauthenticated-nav-bar__sign-up']"));


}
