package co.com.bancolombia.certification.saf.userinterfaces.collection;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class MenuCollectionPage {
    public static final Target OPTION_OPERATION = Target.the("option operations").located(By.xpath("//bc-icon[@aria-label='Operaciones']"));
    public static final Target OPTION_CLIENT = Target.the("option client").located(By.xpath("//bc-icon[@aria-label='Gestión de clientes']"));
    public static final Target OPTION_COLLECTION = Target.the("option income register").locatedBy("//div[@class=\"bc-menu-content-column\"]/div/bc-menu-section/ul/div/bc-menu-option/a/li[contains(text(),'Recaudos registrados')]");
    public static final Target BUTTON_COLLECTION = Target.the("OptionRegisterCollection").located(By.id("btn-makeaction"));
    public static final Target SELECT_SINGLE_LOAD = Target.the("SelectOptionSingleLoad").located(By.xpath("//bc-icon[@class='bc-icon bc-xs bc-md']"));
    public static final Target SELECT_SINGLE_MASSIVE_LOAD = Target.the("Select Option Single Massive Load").located(By.xpath("(//bc-icon[@class='bc-icon bc-xs bc-md'])[2]"));

    public static final Target SELECT_NEXT = Target.the("SelectOptionNext").located(By.xpath("//button[@class='bc-col-7 bc-button-primary bc-button-small']"));
    public static final Target OPTION_ANNULMENT = Target.the("option select  collection").locatedBy("//div[@class=\"bc-menu-content-column\"]/div/bc-menu-section/ul/div/bc-menu-option/a/li[contains(text(),' Aplicaciones de pago ')]");
    public static final Target INPUT_PAYMENT_DATE = Target.the("input payment date").located(By.id("input-payment-date"));
    public static final Target BUTTON_SEARCH_ANNULMENT = Target.the("button search annulment").located(By.cssSelector("bc-icon[class='bc-icon bc-st fc-pointer bc-sm']"));




    private MenuCollectionPage() {
    }

}

