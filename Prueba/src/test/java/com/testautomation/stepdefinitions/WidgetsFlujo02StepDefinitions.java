
package com.testautomation.stepdefinitions;

import com.testautomation.sop.models.WidgetsFechaHoraModel;
import com.testautomation.sop.models.WidgetsFechaModel;
import com.testautomation.sop.tasks.*;
import cucumber.api.java.Before;
import cucumber.api.java.en.When;
import net.serenitybdd.screenplay.actors.OnlineCast;
import java.util.List;
import static net.serenitybdd.screenplay.actors.OnStage.setTheStage;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class WidgetsFlujo02StepDefinitions {

    @Before
    public void setUp() {
        setTheStage(new OnlineCast());
    }

    @When("^el usuario selecciona fecha$")
    public void elUsuarioSeleccionaFecha(List<WidgetsFechaModel> widgetsFechaModels) {
        theActorInTheSpotlight().attemptsTo(
                BuscarFecha.registrandoSoloFecha(widgetsFechaModels.get(0))
        );
    }

    @When("^fecha con hora$")
    public void fechaConHora(List<WidgetsFechaHoraModel> widgetsFechaHoraModels) {
        theActorInTheSpotlight().attemptsTo(
                BuscarFechaHora.registrandoFechaHora(widgetsFechaHoraModels.get(0))
        );
    }


}

