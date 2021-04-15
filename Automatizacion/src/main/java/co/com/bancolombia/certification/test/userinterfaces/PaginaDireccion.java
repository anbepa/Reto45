package co.com.bancolombia.certification.test.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class PaginaDireccion {
    public static final Target TXT_CIUDAD = Target.the("Txt para  ingresar al nombre del usuario a registrar").located(By.cssSelector("input[id= 'city']"));
    public static final Target SELECTOR_CIUDAD = Target.the("Txt para  ingresar al nombre del usuario a registrar").locatedBy("//span[@class='pac-matched'][contains(text(),'Barranquilla')]");
    public static final Target SELECTOR_CIUDAD_1 = Target.the("Txt para  ingresar al nombre del usuario a registrar").locatedBy("//span[@class='pac-matched'][contains(text(),'{0}')]");


    public static final Target TXT_CODIGOPOSTAL = Target.the("insertPostalCode").located(By.id("zip"));
    public static final Target SELECTOR_PAIS = Target.the("Txt para  ingresar al nombre del usuario a registrar").locatedBy("//div[@ng-bind-html='country.name | highlight: $select.search'][contains(text(),'{0}')]");
    public static final Target CONTENEDOR_MAPA = Target.the("Txt para  ingresar al nombre del usuario a registrar").located(By.cssSelector("    div[style='z-index: 3; position: absolute; height: 100%; width: 100%; padding: 0px; border-width: 0px; margin: 0px; left: 0px; top: 0px; touch-action: pan-x pan-y;']\n"));
    public static final Target CONTENEDOR_PAIS = Target.the("Txt para  ingresar al nombre del usuario a registrar").located(By.cssSelector("input[class='form-control ui-select-search ng-pristine ng-valid ng-empty ng-touched']"));
    public static final Target BTN_PROXIMO = Target.the("Txt para  ingresar al nombre del usuario a registrar").located(By.cssSelector("a[class = 'btn btn-blue pull-right']"));

}
