package co.com.bancolombia.certification.saf.models.entitys;


import co.com.bancolombia.certification.saf.models.builders.AccountingDataBuilder;


import java.util.List;

public class Accounting {


    private final List<String> accountingData;

    public List<String> getAccountingData() {
        return accountingData;
    }

    public Accounting(AccountingDataBuilder deskDataBuilder) {


        this.accountingData = deskDataBuilder.getAccountingData();

    }





}
