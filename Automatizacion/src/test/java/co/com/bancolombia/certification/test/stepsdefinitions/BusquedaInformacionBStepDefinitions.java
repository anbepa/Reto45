package co.com.bancolombia.certification.test.stepsdefinitions;

import co.com.bancolombia.certification.test.questions.ObtenerLink;
import co.com.bancolombia.certification.test.tasks.DescargarDocumento;
import co.com.bancolombia.certification.test.tasks.IngresarModulo;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.ensure.Ensure;
import org.openqa.selenium.By;

import javax.print.DocFlavor;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

import static co.com.bancolombia.certification.test.utils.constants.EnvironmentConstants.*;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.*;
import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getDriver;

public class BusquedaInformacionBStepDefinitions {
    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        setTheStage(new OnlineCast());
        OnStage.theActorCalled(ADMINISTRATOR).wasAbleTo(
                Open.url(ENVIRONMENT));

    }

    @Given("^El usuario deber estar en la pagina de busqyeda$")
    public void elUsuarioDeberEstarEnLaPaginaDeBusqyeda() {
        theActorInTheSpotlight().attemptsTo(
                IngresarModulo.porOpcionMenuNosotros(),
                DescargarDocumento.policasTratamiento()
        );

    }


    @When("^Descargar documento Pdf$")
    public void descargarDocumentoPdf() throws IOException {
        theActorInTheSpotlight().attemptsTo(
                IngresarModulo.porOpcionMenuNosotros()

        );


    }

    @Then("^Validar que la descarga sea exitosa$")
    public void validarQueLaDescargaSeaExitosa() throws IOException {
        HttpURLConnection httpConnection = (HttpURLConnection)(new URL(ObtenerLink.textoDashboard().answeredBy(theActor("andres"))).openConnection());
        httpConnection.setRequestMethod("HEAD");
        httpConnection.connect();
        String contentType = httpConnection.getContentType();
        OnStage.theActorInTheSpotlight().attemptsTo(
                Ensure.that(contentType).contains("application/octet-stream")
        );

    }

}
