package co.com.bancolombia.certification.income.manualtest.runners.createincome;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features/Collections/create_payment_aplication_uno.feature",
        glue = "co/com/bancolombia/certification/income/manualtest/stepdefinitions",
        snippets = SnippetType.CAMELCASE
)
public class CreatePaymentAplication {
}
