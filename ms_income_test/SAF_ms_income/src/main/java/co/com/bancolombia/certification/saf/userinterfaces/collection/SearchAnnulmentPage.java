package co.com.bancolombia.certification.saf.userinterfaces.collection;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class SearchAnnulmentPage {
    public static final Target OPTION_ANNULMENT = Target.the("Option Annulment").located(By.xpath("(//em[@class='bc-dropdown-toggle bc-icon bc-sm'])[1]"));
    public static final Target CLICK_ANNULMENT = Target.the("Click Annulment").located(By.id("ANNULATION"));
    public static final Target OPTION_INSTRUCCION = Target.the("Option Intruccion").located(By.xpath("(//em[@class='bc-input-select-toggle'])[2]"));
    public static final Target TEXT_INSTRUCCION = Target.the("Text Instruccion").locatedBy("//ul[@id='type-annulment-container']/li/span[contains(text(),'{0}')]");
    public static final Target ANNULMENT_DESCRIPTION = Target.the("Annulment Description").located(By.id("annulment-description"));
    public static final Target  BUTTON_CONTINUE = Target.the("Button Continue").located(By.cssSelector("button[class='bc-col-5 bc-mx-2 bc-button-primary bc-button-small']"));
    public static final Target  TEXT_STATE_INCOME = Target.the("text number income").located(By.cssSelector("td[class='bc-table-fixed-column-left']"));
    public static final Target  SELECT_NUMBER_APPLICATION = Target.the("select number application").located(By.id("select-number-application-payment-input"));
    public static final Target  BUTTON_NUMBER_APPLICATION = Target.the("button number application").located(By.xpath("(//em[@class='bc-input-select-toggle'])[1]"));
    public static final Target  SELECT_NUMBER_APPLICATION_ANNULMENT = Target.the("select referent client ").locatedBy("((//li[@class='bc-input-select-item'])/span[contains(text(),'{0}')])");

    private SearchAnnulmentPage() {
    }

}
