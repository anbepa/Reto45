package co.com.zeus.certification.saf.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SelectOption implements Interaction {
    private String option;
    private Target list;



    public SelectOption(Target list, String option) {
        this.list = list;
        this.option = option;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        List<WebElement> listaElementos = list.resolveFor(actor).findElements(By.tagName("li"));
        for (int i = 0; i < listaElementos.size(); i++) {
            if (listaElementos.get(i).getText().equalsIgnoreCase(option)) {
                listaElementos.get(i).click();
                break;
            }
        }
    }



    public static SelectOption ofType(Target list, String option) {
        return Tasks.instrumented(SelectOption.class, list, option);
    }
}
