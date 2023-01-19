package co.com.bancolombia.certification.saf.questions.collection;

import co.com.bancolombia.certification.saf.questions.TextAlert;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.targets.Target;

public class StatusText implements Question<String> {

    private Target elements;

    public StatusText(Target elements) {
        this.elements = elements;
    }

    public static Question<String> income(Target elements){

        return new TextAlert(elements);
    }

    @Override
    public String answeredBy(Actor actor) {

        return Text.of(elements).viewedBy(actor).asString().trim();
    }
}
