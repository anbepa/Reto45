package co.com.bancolombia.certification.saf.tasks.collection;
import co.com.bancolombia.certification.saf.integrations.ConnectionWithBD;
import co.com.bancolombia.certification.saf.utils.PropertiesReader;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;

public class ResetField implements Task {

    private String query;

    public ResetField(String query) {
        this.query = query;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        Object[] parameters1 = {};
        ConnectionWithBD.postgresql().updateInformation(parameters1,PropertiesReader.getInstance().getProperties(query));



    }

    public static ResetField dataBase(String query){
        return Tasks.instrumented(ResetField.class,query);
    }
}
