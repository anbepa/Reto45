
package com.testautomation.stepdefinitions;


import com.testautomation.sop.tasks.AccionVentanasEmergentes;
import cucumber.api.java.Before;
import cucumber.api.java.en.When;
import net.serenitybdd.screenplay.actors.OnlineCast;

import static net.serenitybdd.screenplay.actors.OnStage.setTheStage;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
public class AlertsFlujo03StepDefinitions {

    @Before
    public void setUp() {
        setTheStage(new OnlineCast());
    }


    @When("^usuario interactua con las  ventanas emergentes activando y desactivando (.*)$")
    public void usuarioInteractuaConLasVentanasEmergentesActivandoYDesactivando(String arg2) {
        theActorInTheSpotlight().attemptsTo(
                AccionVentanasEmergentes.conDespliegueVentanas()
        );
    }



}

