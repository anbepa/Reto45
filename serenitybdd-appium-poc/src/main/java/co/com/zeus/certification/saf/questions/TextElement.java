package co.com.zeus.certification.saf.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.targets.Target;


public class TextElement implements Question<String> {

    private Target elements;

    public TextElement(Target elements) {
        this.elements = elements;
    }

    public static Question<String> login(Target elements){

     return new TextElement(elements);
 }

    @Override
    public String answeredBy(Actor actor) {

        return Text.of(elements).viewedBy(actor).asString().trim();
    }
}
