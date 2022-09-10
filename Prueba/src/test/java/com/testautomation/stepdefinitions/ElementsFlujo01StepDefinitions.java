
package com.testautomation.stepdefinitions;

import com.testautomation.sop.models.builders.DatosPruebaDataBuilder;
import com.testautomation.sop.tasks.BuscarDatosTabla;
import com.testautomation.sop.tasks.CrearDatosTabla;
import com.testautomation.sop.tasks.EliminarDatosTabla;
import com.testautomation.sop.utils.EnvironmentConstants;
import com.testautomation.sop.utils.reader.PropsCsv;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;

import java.io.IOException;

import static com.testautomation.sop.utils.EnvironmentConstants.ADMINISTRATOR;
import static net.serenitybdd.screenplay.actors.OnStage.setTheStage;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class ElementsFlujo01StepDefinitions {

    @Before
    public void setUp() {

        setTheStage(
                new OnlineCast());
    }

    @Given("^el usuario esta en la pagina$")
    public void elUsuarioEstaEnLaPagina() {
        WebDriverManager.chromedriver().setup();
        OnStage.theActorCalled(ADMINISTRATOR).wasAbleTo(
                Open.url(EnvironmentConstants.ENVIRONMENT_SAF));
    }


    @When("^el usuario agrega un nuevo registro en la tabla diligenciando el formulario con los campos (.*) (.*)$")
    public void elUsuarioAgregaUnNuevoRegistroEnLaTablaDiligenciandoElFormularioConLosCampos(String idEscenario , String Csv) throws IOException {

        theActorInTheSpotlight().attemptsTo(
                CrearDatosTabla.conFormularioRegistro(DatosPruebaDataBuilder.PersonInformation(PropsCsv.getDataCsv(Csv,idEscenario)).build())
        );

    }

    @When("^el usuario pueda eliminar cualquier registro que este en la tabla (.*) (.*)$")
    public void elUsuarioPuedaEliminarCualquierRegistroQueEsteEnLaTabla(String idEscenario , String Csv) throws IOException {
        theActorInTheSpotlight().attemptsTo(
                BuscarDatosTabla.porCampoBusqueda(DatosPruebaDataBuilder.PersonInformation(PropsCsv.getDataCsv(Csv,idEscenario)).build()),
                EliminarDatosTabla.conBoton()

        );


    }

}

