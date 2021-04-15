package co.com.bancolombia.certification.test.tasks;

import co.com.bancolombia.certification.test.interactions.SeleccionaCampos;
import co.com.bancolombia.certification.test.models.DatosDireccion;
import co.com.bancolombia.certification.test.models.DatosDispositivos;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;

import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;

import java.util.List;

import static co.com.bancolombia.certification.test.userinterfaces.PaginaDireccion.*;
import static co.com.bancolombia.certification.test.userinterfaces.PaginaDispositivos.*;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isPresent;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class IngresarDatosDispositivos implements Task {

   private DatosDispositivos datosDispositivos;

    public IngresarDatosDispositivos(DatosDispositivos datosDispositivos) {
        this.datosDispositivos = datosDispositivos;
    }

    public static IngresarDatosDispositivos conFormulario(DatosDispositivos datosDispositivos) {
        return instrumented(IngresarDatosDispositivos.class,datosDispositivos);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(

                SeleccionaCampos.deFormularioDispositivos(
                        _COMPUTADOR,
                        TXT_COMPUTADOR,
                        datosDispositivos.getComputador(),
                        SELECCIONAR_COMPUTADOR),
                SeleccionaCampos.deFormularioDispositivos(
                        _VERSION,
                        TXT_VERSION,
                        datosDispositivos.getVersion(),
                        SELECCIONAR_VERSION),
                SeleccionaCampos.deFormularioDispositivos(
                        _LENGUAJE,
                        TXT_LENGUAJE,
                        datosDispositivos.getLenguaje(),
                        SELECCIONAR_LENGUAJE),
                SeleccionaCampos.deFormularioDispositivos(
                        _DISPOSITIVO,
                        TXT_DISPOSITIVO,
                        datosDispositivos.getDispositivo(),
                        SELECCIONAR_DISPOSITIVO),
                SeleccionaCampos.deFormularioDispositivos(
                        _MODELO,
                        TXT_MODELO,
                        datosDispositivos.getModelo(),
                        SELECCIONAR_MODELO),
                SeleccionaCampos.deFormularioDispositivos(
                        _SISTEMA,
                        TXT_SISTEMA,
                        datosDispositivos.getSistema(),
                        SELECCIONAR_SISTEMA),

                Click.on(BTN_PROXIMO)

                );
    }
}
