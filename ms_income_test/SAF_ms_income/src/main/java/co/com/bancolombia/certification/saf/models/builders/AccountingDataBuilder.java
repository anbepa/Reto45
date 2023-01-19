package co.com.bancolombia.certification.saf.models.builders;

import co.com.bancolombia.certification.saf.models.entitys.Accounting;
import co.com.bancolombia.certification.saf.utils.Builder;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class AccountingDataBuilder implements Builder<Accounting> {

    private static final Logger LOGGER = LoggerFactory.getLogger(AccountingDataBuilder.class);


    private List<String> accountingData;

    public List<String> getAccountingData() {
        return accountingData;
    }



    @Override
    public Accounting build(){

        return new Accounting(this);
    }


    public AccountingDataBuilder withScenaryTwo(List<String> accountingData) {
        this.accountingData = accountingData;
        return this;
    }


    public Accounting PaymentAplication() {
        try {
            Object ob = new JSONParser().parse(new FileReader("src/test/resources/DataDriven/finance-charges-y.json"));
            JSONObject js = (JSONObject) ob;
            List<String> PaymentAplicationValidation = Arrays.asList((String)js.get("principal_balance"),(String)js.get("accrued_amortized"),(String)js.get("state"),(String)js.get("remunerative_balance"),(String)js.get("moratorium_balance"));
            withScenaryTwo(PaymentAplicationValidation);

        } catch (IOException | ParseException e) {
            LOGGER.error(e.getMessage(), e);
        }


        return build();
    }


    public Accounting PaymentAplicationAnnulment() {
        try {
            Object ob = new JSONParser().parse(new FileReader("src/test/resources/DataDriven/payment-aplication-annulment.json"));
            JSONObject js = (JSONObject) ob;
            List<String> PaymentAplicationValidation = Arrays.asList((String)js.get("principal_balance"),(String)js.get("accrued_amortized"),(String)js.get("state"),(String)js.get("remunerative_balance"),(String)js.get("moratorium_balance"));
            withScenaryTwo(PaymentAplicationValidation);

        } catch (IOException | ParseException e) {
            LOGGER.error(e.getMessage(), e);
        }


        return build();
    }

    public static AccountingDataBuilder inThe(){
        return new AccountingDataBuilder();
    }

    public static AccountingDataBuilder withNumber(){
        return new AccountingDataBuilder();
    }
}
