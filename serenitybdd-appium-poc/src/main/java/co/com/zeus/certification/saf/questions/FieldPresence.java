package co.com.zeus.certification.saf.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Presence;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isEnabled;

public class FieldPresence implements Question<Boolean> {

    private Target elements;

    public FieldPresence(Target elements) {
        this.elements = elements;
    }



 public static Question<Boolean> element(Target elements){

     return new FieldPresence(elements);
 }

    @Override
    public Boolean answeredBy(Actor actor) {
        WaitUntil.the(elements, isEnabled());
        return Presence.of(elements).viewedBy(actor).asBoolean();
    }
}
