package co.com.bancolombia.certification.test.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class DescargaPage {

    public static final Target LINK_DESCARGARDOCUMENTO = Target.the("link product").located(By.cssSelector("#wizard2 > div > div:nth-child(3) > div > div.col-sm-6.izquierda > div > p:nth-child(3) > a"));


   private DescargaPage(){
    }
}
