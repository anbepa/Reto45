package co.com.bancolombia.certification.test.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class PaginaContrasena {
    public static final Target TXT_CONTRASENA = Target.the("Txt para  ingresar al nombre del usuario a registrar").located(By.id("password"));
    public static final Target TXT_CONFIRMACION_CONTRASENA = Target.the("Txt para  ingresar al nombre del usuario a registrar").located(By.id("confirmPassword"));
    public static final Target TERMINOS_USO= Target.the("Txt para  ingresar al nombre del usuario a registrar").located(By.id("termOfUse"));
    public static final Target PRIVACIDAD= Target.the("Txt para  ingresar al nombre del usuario a registrar").located(By.id("privacySetting"));
    public static final Target PRESENCIA= Target.the("Txt para  ingresar al nombre del usuario a registrar").located(By.cssSelector("div[class='image-box-header']"));




}
