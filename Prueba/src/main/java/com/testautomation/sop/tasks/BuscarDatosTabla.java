package com.testautomation.sop.tasks;


import com.testautomation.sop.models.SearchModel;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;
import static com.testautomation.sop.userinterfaces.TablaDatosPage.ENTRADA_BUSQUEDA_DATOS;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;


public class BuscarDatosTabla implements Task {


    private SearchModel searchModel;

    public BuscarDatosTabla(SearchModel searchModel) {
        this.searchModel = searchModel;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(


                WaitUntil.the(ENTRADA_BUSQUEDA_DATOS, isVisible()).forNoMoreThan(80).seconds(),
                Enter.theValue(searchModel.getTypeSearch()).into(ENTRADA_BUSQUEDA_DATOS)

        );


    }

    public static BuscarDatosTabla porCampoBusqueda(SearchModel searchModel) {

        return Tasks.instrumented(BuscarDatosTabla.class,searchModel);
    }


}
