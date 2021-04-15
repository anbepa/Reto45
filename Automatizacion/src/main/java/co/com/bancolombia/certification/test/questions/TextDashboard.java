
package co.com.bancolombia.certification.test.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Presence;

import static co.com.bancolombia.certification.test.userinterfaces.PaginaContrasena.PRESENCIA;


public class TextDashboard implements Question<Boolean> {

 public static TextDashboard textoDashboard(){
      return new TextDashboard ();
 }

    @Override
    public Boolean answeredBy(Actor actor) {
        return Presence.of(PRESENCIA).viewedBy(actor).asBoolean();
    }
}

