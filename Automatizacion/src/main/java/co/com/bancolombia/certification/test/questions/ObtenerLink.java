
package co.com.bancolombia.certification.test.questions;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import org.openqa.selenium.By;
import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getDriver;


public class ObtenerLink implements Question<String> {

 public static ObtenerLink textoDashboard(){
      return new ObtenerLink();
 }

    @Override
    public String answeredBy(Actor actor) {

     String link = getDriver().findElement(By.cssSelector("#wizard2 > div > div:nth-child(3) > div > div.col-sm-6.izquierda > div > p:nth-child(3) > a")).getAttribute("href");
     return link;
    }
}

