package com.testautomation.sop.tasks;



import com.testautomation.sop.models.entitys.DatosPruebaFormModels;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;
import static com.testautomation.sop.userinterfaces.BuscarFechaPage.ENTRADA_FECHAHORA;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isPresent;


public class BuscarFechaHora implements Task {


    public BuscarFechaHora(DatosPruebaFormModels datosPruebaFormModels) {
        this.datosPruebaFormModels = datosPruebaFormModels;
    }

    private DatosPruebaFormModels datosPruebaFormModels;

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(

                WaitUntil.the(ENTRADA_FECHAHORA, isPresent()).forNoMoreThan(80).seconds(),
                Enter.theValue(datosPruebaFormModels.getDate()+ ", "+ datosPruebaFormModels.getTime()).into(ENTRADA_FECHAHORA)

        );


    }


    public static BuscarFechaHora registrandoFechaHora(DatosPruebaFormModels datosPruebaFormModels) {

        return Tasks.instrumented(BuscarFechaHora.class, datosPruebaFormModels);
    }


}
