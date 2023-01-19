package co.com.bancolombia.certification.saf.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Enabled;
import net.serenitybdd.screenplay.targets.Target;

public class DisabledButton implements Question<Boolean> {

    private Target elements;

    public DisabledButton(Target elements) {
        this.elements = elements;
    }

    public static Question<Boolean> productModality(Target elements){

     return new DisabledButton(elements);
 }

    @Override
    public Boolean answeredBy(Actor actor) {

        return Enabled.of(elements).viewedBy(actor).asBoolean();
    }
}
