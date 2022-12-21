package stepdefinitions;

import co.com.zeus.certification.saf.questions.FieldPresence;
import co.com.zeus.certification.saf.questions.TextElement;
import co.com.zeus.certification.saf.tasks.AccessMenu;
import co.com.zeus.certification.saf.tasks.Login;
import co.com.zeus.certification.saf.tasks.LoginIncomplete;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.thucydides.core.annotations.Managed;
import org.openqa.selenium.WebDriver;

import static co.com.zeus.certification.saf.userinterfaces.LoginPage.CONTAINER;
import static co.com.zeus.certification.saf.userinterfaces.LoginPage.TEXT_ELEMENT;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class LoginStepDefinitions {


    @Managed(driver = "Appium")
    public WebDriver hisMobileDevice;

    @Before
    public void set_the_stage() {
        OnStage.setTheStage(new OnlineCast());
    }





    @Given("^user is in apps zeus$")
    public void userIsInAppsZeus() {
        theActorCalled("Jhon")
                .can(BrowseTheWeb.with(hisMobileDevice));
        theActorInTheSpotlight().attemptsTo(
                AccessMenu.byGuest()

        );

    }




    @When("^the user fills out the registration form name  (.*)  mail (.*)  pass  (.*)$")
    public void theUserFillsOutTheRegistrationFormNameANDRESMailANDROANTOGMAILCOMPass(String name, String mail, String pass) {
        theActorInTheSpotlight().attemptsTo(
                Login.guest(name,mail,pass)
        );
    }

    @Then("^should see zeus logo$")
    public void shouldSeeZeusLogo() {
        theActorInTheSpotlight().attemptsTo(
                Ensure.that(FieldPresence.element(CONTAINER).answeredBy(theActorInTheSpotlight())).isTrue()
        );
    }


    @When("^the user logs in without filling in fields$")
    public void theUserLogsInWithoutFillingInFields() {
        theActorInTheSpotlight().attemptsTo(
                LoginIncomplete.form()
        );
    }

    @Then("^should see a message \"([^\"]*)\"$")
    public void shouldSeeAMessage(String texto) {
        theActorInTheSpotlight().attemptsTo(
                Ensure.that(TextElement.login(TEXT_ELEMENT).answeredBy(theActorInTheSpotlight())).isEqualTo(texto)
        );
    }
}
