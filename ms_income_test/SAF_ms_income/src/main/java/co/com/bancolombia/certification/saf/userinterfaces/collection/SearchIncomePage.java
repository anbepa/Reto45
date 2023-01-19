package co.com.bancolombia.certification.saf.userinterfaces.collection;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class SearchIncomePage {
    public static final Target OPTION_SEARCH = Target.the("SearchCollection").located(By.xpath("(//em[@class='bc-input-select-toggle'])[1]"));
    public static final Target OPTION_SEARCH_ADVANCED = Target.the("option search advanced").located(By.xpath("(//bc-icon[@id='arrow-advanced-search'])"));
    public static final Target NUMBER_COLLECTION= Target.the("InputNumberColection").located(By.id("number-payment-main"));
    public static final Target SEARCH = Target.the("button search").located(By.cssSelector("bc-icon[aria-label='search']"));
    public static final Target OPTION = Target.the("button deploy apply payment").located(By.xpath("(//em[@class='bc-icon bc-sm bc-dropdown-toggle'])[2]"));
    public static final Target APPLY_COLLECTION = Target.the("button  appply payment").located(By.xpath("(//div[@class='bc-table-extra-info-row-content-actions']/button)[2]"));
    public static final Target APPLY_ANNULMET = Target.the("button  annulment  income").located(By.id("anulate"));
    public static final Target SCROLL_ = Target.the("button  annulment  income").located(By.xpath("(//div[@class='bc-paginator-pages-info']/span)[2]"));

    public static final Target BUTTON_ANNULMENT_INCOME = Target.the("button  annulment  income").located(By.cssSelector("em[class='bc-dropdown-toggle bc-icon bc-sm']"));

    public static final Target BUTTON_SELECT_CAUSAL = Target.the("button  select causal annulment").located(By.xpath("(//em[@class='bc-input-select-toggle'])[7]"));
    public static final Target SELECT_CAUSAL = Target.the("select causal annulment").located(By.xpath("//ul[@id='select-causal-container']/li/span[contains(text(),'INGRESO DOBLE')]"));
    public static final Target TEXT_CAUSAL = Target.the("text causal annulment").located(By.xpath("//textarea[@class='ng-pristine ng-invalid bc-input bc-input-error ng-touched"));
    public static final Target BUTTON_ANNULMENT_PAYMENT_APLYCATION = Target.the("button  annulment payment aplication").located(By.xpath("(//button[@class='bc-button-primary bc-button-small'])[contains(text(),'Anular')][2]"));
    public static final Target BUTTON_CONFIR_ANNULMENT_PAYMENT_APLYCATION = Target.the("button  annulment payment aplication").located(By.xpath("(//button[@class='bc-button-primary bc-button-small'])[contains(text(),'Anular')][1]"));
    public static final Target OPTION_APPLY = Target.the("select option appply expiration payment").located(By.xpath("//div[@id='select-type-application']/em"));
    public static final Target SELECT_OPTION = Target.the("select option apply income the expiration").located(By.xpath("//li[@class='bc-input-select-item']/span[contains(text(),'Al vencimiento')]"));
    public static final Target BUTTON_APPLY = Target.the("Button for aply payment").located(By.xpath("(//button[@class='bc-button-primary bc-button-small'])[contains(text(),'Aplicar pago')]"));
    public static final Target ESTATE = Target.the("ButtonForApplyPayment").locatedBy("#MyNewAlert > section.bc-alert-body > section > p.bc-alert-title");
    public static final Target BTN_SELECT_REFERENT = Target.the("button referent client").located(By.xpath("(//em[@class='bc-input-select-toggle'])[1]"));
    public static final Target BTN_SELECT_STATE = Target.the("button state obligation").located(By.xpath("(//em[@class='bc-input-select-toggle'])[6]"));
    public static final Target SELECT_STATE = Target.the("select state obligation").located(By.xpath("//li[@class='bc-input-select-item']/label[contains(text(),'Distribuir o aplicar')]/ancestor::li"));
    public static final Target SELECT_STATE_ANNULMNET = Target.the("select state obligation").located(By.xpath("(//li[@class='bc-input-select-item']/label[contains(text(),'Aplicado')]/ancestor::li)[1]"));

    public static final Target BTN_SELECT_BENEFICIARY = Target.the("button beneficiary client").located(By.xpath("(//em[@class='bc-input-select-toggle'])[2]"));
    public static final Target SELECT_DATE_INCOME = Target.the("date income field").located(By.id("collection-date"));

    private SearchIncomePage() {
    }
}
