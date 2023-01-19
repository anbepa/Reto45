package co.com.bancolombia.certification.saf.questions.collection;
import co.com.bancolombia.certification.saf.integrations.ConnectionWithBD;
import co.com.bancolombia.certification.saf.interactions.Wait;
import co.com.bancolombia.certification.saf.models.builders.AccountingDataBuilder;
import net.serenitybdd.screenplay.Question;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;





public class ValidateTheRecordsOfOgligationsTheInDataBase {
    private static final Logger LOGGER = LoggerFactory.getLogger(ValidateTheRecordsOfOgligationsTheInDataBase.class);


   public     String opcion;

    public ValidateTheRecordsOfOgligationsTheInDataBase(String opcion) {
        this.opcion = opcion;
    }

    private ValidateTheRecordsOfOgligationsTheInDataBase() {}

    public static Question<Boolean> existsInTheDatabase(String query,String opcion){
        return actor -> theRecordExists(query,opcion);
    }


    public static Question<Boolean> doesNotexistsInTheDatabase(String query,String opcion){
        return actor -> !theRecordExists(query,opcion);
    }

    private static Boolean theRecordExists(String query, String opcion) {
         boolean flag = true;
        switch (opcion) {
            case "paymentApplication":
                Wait.aTime(20000);
                String[][] responseTableAnnulmentDebit;
                Object[] parameterAnnulmentDebit = {};
                responseTableAnnulmentDebit = ConnectionWithBD.postgresql().getInfoOfDataBaseForRowsObligation(parameterAnnulmentDebit, query);
                int rt = 0;
                while (flag && rt <= 4) {
                    Wait.aTime(30000);
                    for (int i = 1; i <= 5; i++) {
                        flag = (responseTableAnnulmentDebit[rt][i].trim().
                                equals(AccountingDataBuilder.inThe().
                                        PaymentAplication().getAccountingData().get(i - 1).trim()));
                        System.out.println(flag);
                        if (!flag) {
                            break;
                        }
                    }
                    rt++;
                }
                break;


            case "paymentApplicationAnnulment":
                Wait.aTime(20000);
                String[][] responseTableAnnulment;
                Object[] parameterAnnulment = {};
                responseTableAnnulment = ConnectionWithBD.postgresql().getInfoOfDataBaseForRowsObligation(parameterAnnulment, query);

                int rty = 0;
                while (flag && rty <= 4) {
                    Wait.aTime(30000);
                    for (int i = 1; i <= 3; i++) {
                        flag = (!responseTableAnnulment[rty][i].trim().equals(AccountingDataBuilder.inThe().
                                        PaymentAplicationAnnulment()
                                        .getAccountingData().get(i - 1).trim()));

                        System.out.println(flag);
                        if (!flag) {
                            break;
                        }
                    }
                    rty++;
                }
                break;
            default: break;
        }

        return  flag;
        }


    }


