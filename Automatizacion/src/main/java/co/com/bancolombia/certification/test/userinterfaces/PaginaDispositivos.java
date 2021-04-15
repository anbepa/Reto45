package co.com.bancolombia.certification.test.userinterfaces;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class PaginaDispositivos {
    public static final Target _COMPUTADOR = Target.the("Txt para  ingresar al nombre del usuario a registrar").located(By.cssSelector("div[name='osId']"));
    public static final Target TXT_COMPUTADOR = Target.the("Txt para  ingresar al nombre del usuario a registrar").located(By.cssSelector("div[name='osId']>input[type='search']"));
    public static final Target SELECCIONAR_COMPUTADOR = Target.the("Txt para  ingresar al nombre del usuario a registrar").located(By.cssSelector("div[ng-bind-html='device.name | highlight: $select.search']"));


    public static final Target _VERSION = Target.the("Txt para  ingresar al nombre del usuario a registrar").located(By.cssSelector("div[name='osVersionId']"));
    public static final Target TXT_VERSION = Target.the("Txt para  ingresar al nombre del usuario a registrar").located(By.cssSelector("div[name='osVersionId']>input[type='search']"));
    public static final Target SELECCIONAR_VERSION = Target.the("Txt para  ingresar al nombre del usuario a registrar").located(By.cssSelector("div[ng-bind-html='version.name | highlight: $select.search']"));


    public static final Target _LENGUAJE= Target.the("Txt para  ingresar al nombre del usuario a registrar").located(By.cssSelector("div[name='osLanguageId']"));
    public static final Target TXT_LENGUAJE = Target.the("Txt para  ingresar al nombre del usuario a registrar").located(By.cssSelector("div[name='osLanguageId']>input[type='search']"));
    public static final Target SELECCIONAR_LENGUAJE = Target.the("Txt para  ingresar al nombre del usuario a registrar").located(By.cssSelector("div[ng-bind-html='language.name | highlight: $select.search']"));

    public static final Target _DISPOSITIVO = Target.the("Txt para  ingresar al nombre del usuario a registrar").located(By.cssSelector("div[name='handsetMakerId'"));
    public static final Target TXT_DISPOSITIVO = Target.the("Txt para  ingresar al nombre del usuario a registrar").located(By.cssSelector("div[name='handsetMakerId']>input[type='search']"));
    public static final Target SELECCIONAR_DISPOSITIVO = Target.the("Txt para  ingresar al nombre del usuario a registrar").located(By.cssSelector("div[ng-bind-html='device.name | highlight: $select.search']"));

    public static final Target _MODELO = Target.the("Txt para  ingresar al nombre del usuario a registrar").located(By.cssSelector("div[name='handsetModelId']"));
    public static final Target TXT_MODELO = Target.the("Txt para  ingresar al nombre del usuario a registrar").located(By.cssSelector("div[name='handsetModelId']>input[type='search']"));
    public static final Target SELECCIONAR_MODELO = Target.the("Txt para  ingresar al nombre del usuario a registrar").located(By.cssSelector("div[ng-bind-html='model.name | highlight: $select.search']"));

    public static final Target _SISTEMA = Target.the("Txt para  ingresar al nombre del usuario a registrar").located(By.cssSelector("div[name='handsetOSId']"));
    public static final Target TXT_SISTEMA = Target.the("Txt para  ingresar al nombre del usuario a registrar").located(By.cssSelector("div[name='handsetOSId']>input[type='search']"));
    public static final Target SELECCIONAR_SISTEMA = Target.the("Txt para  ingresar al nombre del usuario a registrar").located(By.cssSelector("div[ng-bind-html='osVersion.name | highlight: $select.search']"));


}
