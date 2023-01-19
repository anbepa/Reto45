package co.com.bancolombia.certification.saf.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.targets.Target;


public class TextAlert implements Question<String> {

    private Target elements;

    public TextAlert(Target elements) {
        this.elements = elements;
    }

    public static Question<String> productModality(Target elements){

     return new TextAlert(elements);
 }

    @Override
    public String answeredBy(Actor actor) {

        return Text.of(elements).viewedBy(actor).asString().trim();
    }
}
