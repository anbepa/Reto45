package co.com.bancolombia.certification.saf.userinterfaces.collection;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class RecordMassiveIncomePage {
    public static final Target INPUTFILE = Target.the("input file").located(By.id("input-InputConDropArea"));
    public static final Target REGISTERMASSIVE = Target.the("register masive").located(By.cssSelector("button[class='bc-mx-sm-2 bc-mx-md-4 bc-my-md-0 bc-col-lg-3 bc-col-md-6 bc-col-sm-6 bc-col-xs-12 bc-button-primary bc-button-small']"));
    public static final Target CONFIRMINGREGISTERMASSIVE = Target.the("register masive").located(By.cssSelector("button[class='bc-button-primary bc-button-small']"));

    private RecordMassiveIncomePage() {
    }

}
