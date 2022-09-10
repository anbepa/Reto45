
package com.testautomation.stepdefinitions;

import com.testautomation.sop.models.builders.DatosPruebaDataBuilder;
import com.testautomation.sop.tasks.*;
import com.testautomation.sop.utils.reader.PropsCsv;
import cucumber.api.java.Before;
import cucumber.api.java.en.When;
import net.serenitybdd.screenplay.actors.OnlineCast;

import java.io.IOException;
import static net.serenitybdd.screenplay.actors.OnStage.setTheStage;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class WidgetsFlujo02StepDefinitions {

    @Before
    public void setUp() {
        setTheStage(new OnlineCast());
    }

    @When("^el usuario selecciona fecha (.*) (.*)$")
    public void elUsuarioSeleccionaFecha(String idEscenario , String Csv) throws IOException {
        theActorInTheSpotlight().attemptsTo(
                BuscarFecha.registrandoSoloFecha(DatosPruebaDataBuilder.PersonInformation(PropsCsv.getDataCsv(Csv,idEscenario)).build())
        );
    }

    @When("^fecha con hora (.*) (.*)$")
    public void fechaConHora(String idEscenario , String Csv) throws IOException  {
        theActorInTheSpotlight().attemptsTo(
                BuscarFechaHora.registrandoFechaHora(DatosPruebaDataBuilder.PersonInformation(PropsCsv.getDataCsv(Csv,idEscenario)).build())
        );
    }


}

