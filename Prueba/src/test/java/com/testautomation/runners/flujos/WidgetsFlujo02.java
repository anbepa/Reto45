package com.testautomation.runners.flujos;


import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = {"src/test/resources/features/widgets_flujo02.feature"},
        glue = {"com.testautomation.stepdefinitions"},
        snippets = SnippetType.CAMELCASE

)
public class WidgetsFlujo02 {
}
