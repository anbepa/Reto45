package co.com.bancolombia.certification.saf.runners.createincome;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = {"src/test/resources/features/Collections/create_collections.feature"},
        glue = {"co.com.bancolombia.certification.saf.stepdefinitions"},
        tags = {"@UserStory=280090"},
        snippets = SnippetType.CAMELCASE

)
public class CreateCollection {

}
