package co.com.bancolombia.certification.test.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class MenuPage {

    public static final Target LINK_MENU_ACERCANOSOTROS = Target.the("link product").located(By.id("header-nosotros"));
    public static final Target LINK_MENU_INFORMACIONCORPO = Target.the("link product").located(By.id("serv"));
    public static final Target LINK_MENU_PROVEEDORES = Target.the("link product").located(By.cssSelector("a[href='/wps/portal/acerca-de/informacion-corporativa/proveedores/']"));


   private MenuPage(){
    }
}
