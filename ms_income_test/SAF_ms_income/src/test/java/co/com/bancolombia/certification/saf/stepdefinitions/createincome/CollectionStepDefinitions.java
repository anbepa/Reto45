package co.com.bancolombia.certification.saf.stepdefinitions.createincome;
import co.com.bancolombia.certification.saf.exceptions.ElementNotFound;
import co.com.bancolombia.certification.saf.interactions.Wait;
import co.com.bancolombia.certification.saf.models.collection.Data;
import co.com.bancolombia.certification.saf.questions.collection.ValidateTheRecordsOfOgligationsTheInDataBase;
import co.com.bancolombia.certification.saf.questions.collection.StatusText;
import co.com.bancolombia.certification.saf.tasks.collection.*;
import co.com.bancolombia.certification.saf.tasks.login.Login;
import co.com.bancolombia.certification.saf.utils.PropertiesReader;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import net.thucydides.core.util.EnvironmentVariables;
import org.hamcrest.Matchers;
import org.joda.time.LocalDate;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import static co.com.bancolombia.certification.saf.userinterfaces.collection.SearchAnnulmentPage.TEXT_STATE_INCOME;
import static co.com.bancolombia.certification.saf.userinterfaces.collection.SearchIncomePage.ESTATE;
import static co.com.bancolombia.certification.saf.utils.EnvironmentConstants.ADMINISTRATOR;
import static co.com.bancolombia.certification.saf.utils.EnvironmentConstants.ENVIRONMENT_SAF;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.setTheStage;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class CollectionStepDefinitions {

    private String theRestApiBaseUrl;
    private EnvironmentVariables environmentVariables;
    private Actor sam;

    @Before
    public void setUp() {


        WebDriverManager.chromedriver().setup();
        setTheStage(new OnlineCast());

    }

    @Given("^That the user enter to the page$")
    public void thatTheUserEnterToThePage() {
        OnStage.theActorCalled(ADMINISTRATOR).whoCan(CallAnApi.at("https://financiacion-int-qa.apps.ambientesbc.com/saf"));
        OnStage.theActorCalled(ADMINISTRATOR).wasAbleTo(Open.url(ENVIRONMENT_SAF));

    }


    @Given("^Que se tiene unas ogligaciones  adecuadas  con el siguiente query \"([^\"]*)\"$")
    public void queSeTieneUnasOgligacionesAdecuadasConElSiguienteQuery(String query) {
        theActorInTheSpotlight().attemptsTo(
                ResetField.dataBase(query)
                //Login.byDocument()
        );
    }


    @Given("^Se  ejecuta los cargos financieros para las obligaciones$")
    public void queSeEjecutaLosCargosFinancieroParaLasObligaciones() {
         theActorInTheSpotlight().attemptsTo(
                 ApplyFinanceCharges.obligation()

        );
        Wait.aTime(10000);

    }




    @When("^El usuario crea un pago de forma manual con los siguiente datos$")
    public void elUsuarioCreaUnPagoDeFormaManualConLosSiguienteDatos(List<Data> information) {
        theActorInTheSpotlight().attemptsTo(

                CreateCollection.withManualRegistration(information),
                SearchIncome.on(information)

        );
    }


    @When("^Genera una aplicacion de pago al vencimiento$")
    public void generaUnaAplicacionDePagoAlVencimiento() {
        theActorInTheSpotlight().attemptsTo(
                ApplyPayments.onScenarios()
        );
    }


    @Then("^Deberia ver las obligaciones cancelada en su totalidad en la base de datos$")
    public void deberiaVerLaObligacionCanceladaEnSuTotalidad() {
        Wait.aTime(10000);
        theActorInTheSpotlight()
                .should(seeThat(ValidateTheRecordsOfOgligationsTheInDataBase
                        .existsInTheDatabase(PropertiesReader.getInstance()
                                .getProperties("queryObligation"), "paymentApplication"), Matchers.is(true)));
    }


    @When("^El usuario crea un pago de forma masiva con un archivo$")
    public void elUsuarioCreaUnPagoDeFormaMasivaConUnArchivo() throws ParseException {
        theActorInTheSpotlight().attemptsTo(
                CreateCollectionMassive.withFile()
        );

    }


    @When("^El usuario  busca y anula  la aplicacion de pago con los siguientes datos$")
    public void elUsuarioBuscaYAnulaLaAplicacionDePagoConLosSiguientesDatos(List<Data> information) {
        theActorInTheSpotlight().attemptsTo(
                 Login.byDocument(),
                 Wait.aTime(3000),
                 SearchIncome.on(information)
        );
        String numerIncome = theActorInTheSpotlight().recall("textIncome");
        theActorInTheSpotlight().attemptsTo(
                SearchAnnulment.on(information,numerIncome),
                Wait.aTime(2000),
                CollectionAnnulment.on(numerIncome)

        );

    }

    @Then("^Deberia ver las obligaciones en sus estados iniciales antes de realizar el proceso de aplicacion de pago$")
    public void deberiaVerLasObligacionesEnSusEstadosInicialesAntesDeRealizarElProcesoDeAplicacionDePago() {
        Wait.aTime(10000);
        theActorInTheSpotlight()
                .should(seeThat(ValidateTheRecordsOfOgligationsTheInDataBase
                        .existsInTheDatabase(PropertiesReader.getInstance()
                                .getProperties("queryObligation"), "paymentApplicationAnnulment"), Matchers.is(true)));

    }

    @Given("^Que se tiene unas ogligaciones  adecuadas  \"([^\"]*)\"$")
    public void queSeTieneUnasOgligacionesAdecuadas(String arg1) {
        theActorInTheSpotlight().attemptsTo(
                ResetField.dataBase("Obligation2"),
                Wait.aTime(2000),
                ResetField.dataBase(arg1),
                Login.byDocument()
        );
    }

    @When("^El usuario crea un recaudo manual uno a uno con los siguientes datos$")
    public void elUsuarioCreaUnRecaudoManualUnoAUnoConLosSiguientesDatos(List<Data> information) {

       theActorInTheSpotlight().attemptsTo(
                CreateCollection.withManualRegistration(information),
                Wait.aTime(20000)

        );
    }

    @Then("^Deberia de visualizar una alerta con el siguiente mensaje \"([^\"]*)\"  and validar las 5 obligaciones en BD  con estado cancelado$")
    public void deberiaDeVisualizarUnaAlertaConElSiguienteMensajeAndValidarLasObligacionesEnBDConEstadoCancelado(String arg1) {

    }


    @Then("^Deberia de visualizar  las 5 obligaciones en estado cancelado en la base de datos de SAF$")
    public void deberiaDeVisualizarLasObligacionesEnEstadoCanceladoEnLaBaseDeDatosDeSAF() {
        Wait.aTime(10000);
        theActorInTheSpotlight()
                .should(seeThat(ValidateTheRecordsOfOgligationsTheInDataBase
                        .existsInTheDatabase(PropertiesReader.getInstance()
                                .getProperties("queryObligation"), "paymentApplication"), Matchers.is(true)));

    }


}




