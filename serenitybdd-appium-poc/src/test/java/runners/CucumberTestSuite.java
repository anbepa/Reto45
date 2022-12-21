package runners;

import cucumber.api.CucumberOptions;

import cucumber.api.SnippetType;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"stepdefinitions"},
        tags = {"@UserStory=2800901"},
        snippets = SnippetType.CAMELCASE

)

public class CucumberTestSuite {
}