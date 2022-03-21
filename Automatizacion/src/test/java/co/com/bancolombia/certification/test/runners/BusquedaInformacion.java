package co.com.bancolombia.certification.test.runners;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;



@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features/busqueda_info_bc.feature",
        glue = "co.com.bancolombia.certification.test.stepsdefinitions",
        snippets = SnippetType.CAMELCASE

)
public class BusquedaInformacion {

}
