package com.testautomation.sop.tasks;



import com.testautomation.sop.models.entitys.DatosPruebaFormModels;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;
import static com.testautomation.sop.userinterfaces.TablaDatosPage.ENTRADA_BUSQUEDA_DATOS;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;


public class BuscarDatosTabla implements Task {


    public BuscarDatosTabla(DatosPruebaFormModels datosPruebaFormModels) {
        this.datosPruebaFormModels = datosPruebaFormModels;
    }

    private DatosPruebaFormModels datosPruebaFormModels;

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(


                WaitUntil.the(ENTRADA_BUSQUEDA_DATOS, isVisible()).forNoMoreThan(80).seconds(),
                Enter.theValue(datosPruebaFormModels.getTypeSearch()).into(ENTRADA_BUSQUEDA_DATOS)

        );


    }

    public static BuscarDatosTabla porCampoBusqueda(DatosPruebaFormModels datosPruebaFormModels) {

        return Tasks.instrumented(BuscarDatosTabla.class, datosPruebaFormModels);
    }


}
