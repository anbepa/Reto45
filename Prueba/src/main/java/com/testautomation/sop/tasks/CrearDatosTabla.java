package com.testautomation.sop.tasks;



import com.testautomation.sop.models.entitys.DatosPruebaFormModels;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.JavaScriptClick;
import net.serenitybdd.screenplay.waits.WaitUntil;
import static com.testautomation.sop.userinterfaces.CrearDatosPage.*;
import static com.testautomation.sop.userinterfaces.MenuPage.LINK_MENU_ELEMENTOS;
import static com.testautomation.sop.userinterfaces.MenuPage.LINK_MENU_TABLA;
import static com.testautomation.sop.userinterfaces.TablaDatosPage.BOTON_NUEVO_DATO;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;


public class CrearDatosTabla implements Task {


    public CrearDatosTabla(DatosPruebaFormModels datosPruebaFormModels) {
        this.datosPruebaFormModels = datosPruebaFormModels;
    }

    private DatosPruebaFormModels datosPruebaFormModels;

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(

                WaitUntil.the(LINK_MENU_ELEMENTOS, isPresent()).forNoMoreThan(80).seconds(),
                JavaScriptClick.on(LINK_MENU_ELEMENTOS),
                JavaScriptClick.on(LINK_MENU_TABLA),
                WaitUntil.the(BOTON_NUEVO_DATO, isClickable()).forNoMoreThan(80).seconds(),
                Click.on(BOTON_NUEVO_DATO),
                Enter.theValue(datosPruebaFormModels.getFirstName()).into(ENTRADA_NOMBRE),
                Enter.theValue(datosPruebaFormModels.getLastName()).into(ENTRADA_APELLIDO),
                Enter.theValue(datosPruebaFormModels.getEmail()).into(ENTRADA_CORREO),
                Enter.theValue(datosPruebaFormModels.getAge()).into(ENTRADA_EDAD),
                Enter.theValue(datosPruebaFormModels.getSalary()).into(ENTRADA_SALARIO),
                Enter.theValue(datosPruebaFormModels.getDepartment()).into(ENTRADA_DEPARTAMENTO),
                WaitUntil.the(BOTON_GUARDAR_DATOS, isClickable()).forNoMoreThan(80).seconds(),
                Click.on(BOTON_GUARDAR_DATOS)

        );

    }

    public static CrearDatosTabla conFormularioRegistro(DatosPruebaFormModels datosPruebaFormModels) {

        return Tasks.instrumented(CrearDatosTabla.class, datosPruebaFormModels);
    }


}
