package co.com.bancolombia.certification.test.stepsdefinitions;

import co.com.bancolombia.certification.test.models.DatosContrasena;
import co.com.bancolombia.certification.test.models.DatosDireccion;
import co.com.bancolombia.certification.test.models.DatosDispositivos;
import co.com.bancolombia.certification.test.models.DatosPersonales;
import co.com.bancolombia.certification.test.questions.TextDashboard;
import co.com.bancolombia.certification.test.tasks.*;
import cucumber.api.java.Before;
import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Dado;
import cucumber.api.java.es.Entonces;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import org.hamcrest.Matchers;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static co.com.bancolombia.certification.test.utils.constants.EnvironmentConstants.*;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.*;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static net.serenitybdd.screenplay.questions.WebElementQuestion.the;
import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getDriver;

public class CreacionUsuarioUtestStepDefinitions {
    @Before
    public void setUp() {
        setTheStage(new OnlineCast());
        OnStage.theActorCalled(ADMINISTRATOR).wasAbleTo(
                Open.url(ENVIRONMENT_UTEST));

    }

    @Dado("^que el usuario debe estar pagina de creacion$")
    public void queElUsuarioDebeEstarPaginaDeCreacion() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                IniciarCreacion.enHomePage()
        );

    }

    @Cuando("^el usuario diligencia el formulario con los datos personales$")
    public void elUsuarioDiligenciaElFormularioConLosDatosPersonales(List<DatosPersonales> datosPersonales) {

        OnStage.theActorInTheSpotlight().attemptsTo(
                IngresarDatosPersonales.conFormulario(datosPersonales.get(0))
        );

    }

    @Cuando("^el usuario diligencia el formulario de direccion$")
    public void elUsuarioDiligenciaElFormularioDeDireccion(List<DatosDireccion> datosDireccion) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                IngresarDatosDireccion.conFormulario(datosDireccion.get(0))
        );



    }

    @Cuando("^el usuario diligencia el formulario de dispositivos$")
    public void elUsuarioDiligenciaElFormularioDeDispositivos(List<DatosDispositivos> datosDispositivos) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                IngresarDatosDispositivos.conFormulario(datosDispositivos.get(0))
        );
    }

    @Cuando("^el usuario crea la contrasena$")
    public void elUsuarioCreaLaContrasena() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                CreacionContrasena.conFormulario(PASSWORD)
        );
    }

    @Entonces("^deberia  visualizar mensaje de creacion$")
    public void deberiaVisualizarMensajeDeCreacion() {
        OnStage.theActorInTheSpotlight().should(seeThat(TextDashboard.textoDashboard()));

    }
}
