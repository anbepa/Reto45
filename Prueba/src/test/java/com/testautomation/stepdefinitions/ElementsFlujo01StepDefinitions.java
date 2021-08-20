
package com.testautomation.stepdefinitions;

import com.testautomation.sop.models.ElementsModel;
import com.testautomation.sop.models.SearchModel;
import com.testautomation.sop.tasks.BuscarDatosTabla;
import com.testautomation.sop.tasks.CrearDatosTabla;
import com.testautomation.sop.tasks.EliminarDatosTabla;
import com.testautomation.sop.utils.EnvironmentConstants;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import java.util.List;

import static com.testautomation.sop.utils.EnvironmentConstants.ADMINISTRATOR;
import static net.serenitybdd.screenplay.actors.OnStage.setTheStage;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class ElementsFlujo01StepDefinitions {

    @Before
    public void setUp() {
        setTheStage(new OnlineCast());
    }

    @Given("^el usuario esta en la pagina$")
    public void elUsuarioEstaEnLaPagina() {
        OnStage.theActorCalled(ADMINISTRATOR).wasAbleTo(
                Open.url(EnvironmentConstants.ENVIRONMENT_SAF));
    }


    @When("^el usuario agrega un nuevo registro en la tabla diligenciando el formulario con los campos$")
    public void elUsuarioAgregaUnNuevoRegistroEnLaTablaDiligenciandoElFormularioConLosCampos(List<ElementsModel> elementsModel) {

        theActorInTheSpotlight().attemptsTo(
                CrearDatosTabla.conFormularioRegistro(elementsModel.get(0))
        );

    }

    @When("^el usuario pueda eliminar cualquier registro que este en la tabla$")
    public void elUsuarioPuedaEliminarCualquierRegistroQueEsteEnLaTabla(List<SearchModel> searchModel) {
        theActorInTheSpotlight().attemptsTo(
                BuscarDatosTabla.porCampoBusqueda(searchModel.get(0)),
                EliminarDatosTabla.conBoton()

        );

        System.out.println(searchModel.get(0).getTypeSearch());
    }

}

