package co.com.bancolombia.certification.saf.userinterfaces.collection;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class ManualRecordIncomePage {
    public static final Target SELECT_DATE = Target.the("Date Reception").located(By.id("date-receipt"));
    public static final Target OPTION_HOUR = Target.the("Hour Reception").located(By.xpath("(//em[@class='bc-input-select-toggle'])[1]"));
    public static final Target SELECT_HOUR = Target.the("Select Hour").locatedBy("(//li[@class='bc-input-select-item']/span[contains(text(),'{0}')]/ancestor::li)");
    public static final Target OPTION_CITY = Target.the("City Reception").located(By.xpath("(//em[@class='bc-input-select-toggle'])[2]"));
    public static final Target SELECT_CITY = Target.the("Select City").located(By.xpath("(//li[@class='bc-input-select-item'])/span[contains(text(),'Medellín, Antioquia')]"));
    public static final Target CLIENT_REFERENT = Target.the("Client Referente").located(By.xpath("(//em[@class='bc-input-select-toggle'])[3]"));
    public static final Target SELECT_CLIENT_REFERENT = Target.the("select referent client ").locatedBy("((//li[@class='bc-input-select-item'])/span[contains(text(),'{0}')])[1]");
    public static final Target OPTION_CLIENT_BENEFICIARY = Target.the("Select client beneficiary").located(By.xpath("(//em[@class='bc-input-select-toggle'])[4]"));
    public static final Target SELECT_CLIENT_BENEFICIARY = Target.the("Select client beneficiary").locatedBy("((//li[@class='bc-input-select-item'])/span[contains(text(),'{0}')])[2]");
    public static final Target OPTION_SELECT_PAYMENT = Target.the("Option Payment").located(By.xpath("(//em[@class='bc-input-select-toggle'])[5]"));
    public static final Target SELECT_PAYMENT = Target.the("select TypePayment").locatedBy("((//li[@class='bc-input-select-item'])/span[contains(text(),'{0}')])[1]");
    public static final Target OPTION_MONEY = Target.the("Option Money").located(By.xpath("(//em[@class='bc-input-select-toggle'])[6]"));
    public static final Target SELECT_MONEY = Target.the("Select Money").located(By.xpath("(//li[@class='bc-input-select-item']/span[contains(text(),'COP')])"));
    public static final Target VALUE_COLLECTION = Target.the("Option Value Collection").located(By.id("total-value-collection"));
    public static final Target CHANNEL_COLLECTION = Target.the("OptionChanel Collection").located(By.xpath("(//em[@class='bc-input-select-toggle'])[7]"));
    public static final Target SELECT_CHANNEL = Target.the("Select Option Channel").locatedBy("(//li[@class='bc-input-select-item']/span[contains(text(),'{0}')])[1]");
    public static final Target OPTION_JUSTIFICATION = Target.the("Option Justificaction Registration").located(By.xpath("(//em[@class='bc-input-select-toggle'])[8]"));
    public static final Target SELECT_JUSTIFICATION = Target.the("Select Justificacion Registration").located(By.xpath("(//li[@class='bc-input-select-item']/span[contains(text(),'Contingencia')])"));
    public static final Target REGISTRATION = Target.the("Registration Collection").located(By.xpath("//button[@typebutton='primary']"));
    public static final Target CONFIRMATION = Target.the("Select Registration Confirm").located(By.xpath("//button[@class='bc-button-primary bc-button-small']"));

    private ManualRecordIncomePage() {
    }

}
