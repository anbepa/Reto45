package co.com.bancolombia.certification.income.manualtest.stepdefinitions;

import cucumber.api.Scenario;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;

import static co.com.bancolombia.certification.income.manualtest.ManualTest.validate;

public class GeneralStepDefinitions {
    private Scenario scenario;

    @Before
    public void getScenario(Scenario scenario) {
        this.scenario = scenario;
    }

    @Given("^(.*)$")
    public void elUsuarioSeEncuentraEnElSistemaDelfin(String step) {
        validate(step, scenario.getName());
    }

}
