package co.com.bancolombia.certification.test.userinterfaces;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;


public class PaginaPersonales {

    public static final Target TXT_NOMBRES = Target.the("Txt para  ingresar al nombre del usuario a registrar").located(By.cssSelector("input[id='firstName']"));
    public static final Target TXT_APELLIDOS = Target.the("Txt para  ingresar al apellidos del usuario a registrar").located(By.cssSelector("input[id='lastName']"));
    public static final Target TXT_CORREO = Target.the("Txt para  ingresar el correo del usuario a registrar").located(By.cssSelector("input[id='email']"));
    public static final Target SELECT_MES = Target.the("Selector para el ano de nacimiento del cliente").located(By.cssSelector("select[id='birthMonth']"));
    public static final Target SELECT_DIA = Target.the("Selector para el ano de nacimiento del cliente").located(By.cssSelector("select[id='birthDay']"));
    public static final Target SELECT_ANO = Target.the("Selector para el ano de nacimiento del cliente").located(By.cssSelector("select[id='birthYear']"));
    public static final Target BTN_SIGUIENTE = Target.the("Selector para el ano de nacimiento del cliente").located(By.cssSelector("a[class = 'btn btn-blue']"));


}
