package co.com.bancolombia.certification.saf.userinterfaces.collection;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class CollectionAnnulmentPage {
    public static final Target COLLECTION_ANNULMENT = Target.the("button  annulment payment").located(By.xpath("(//div[@class='bc-table-extra-info-row-content-actions']/button)[3]"));

    private CollectionAnnulmentPage() {
    }

}
