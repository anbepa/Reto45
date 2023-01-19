package co.com.bancolombia.certification.saf.tasks.collection;


import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.rest.interactions.Put;
import org.json.simple.JSONObject;
import org.json.simple.parser.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileReader;
import java.io.IOException;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;

public class ApplyFinanceCharges implements Task {
    private static final Logger LOGGER = LoggerFactory.getLogger(ApplyFinanceCharges.class);
    private   JSONObject js ;



    @Override
    public <T extends Actor> void performAs(T actor) {
         Object ob;

        try {

            ob = new JSONParser().parse(new FileReader("src/test/resources/DataDriven/finance-charges.json"));
            js = (JSONObject) ob;


        } catch (IOException | ParseException e) {
            LOGGER.error(e.getMessage(), e);
        }

        actor.attemptsTo(
                Put.to("/obligation/api/finance-charges")
                        .with(requestSpecification -> requestSpecification
                                .relaxedHTTPSValidation()
                                .header("Authorization","API Key")
                                .header("api-key","e19554b1-8c29-4e36-97b2-c3410e0ef573")
                                .header("Content-Type","application/json")
                                .body(js))

        );


        theActorInTheSpotlight().should(
                seeThatResponse( "User details should be correct",
                        response -> response.statusCode(200)

                )
        );


    }
    public static ApplyFinanceCharges obligation(){

        return Tasks.instrumented(ApplyFinanceCharges.class);
    }

}
