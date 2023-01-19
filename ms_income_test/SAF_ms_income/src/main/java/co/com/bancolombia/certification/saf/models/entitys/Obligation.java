package co.com.bancolombia.certification.saf.models.entitys;


import co.com.bancolombia.certification.saf.models.builders.ObligationDataBuilder;

import java.util.List;

public class Obligation {


    private final List<String> obligationData;

    public List<String> getObligationData() {

        return obligationData;
    }

    public Obligation(ObligationDataBuilder obligationDataBuilder) {


        this.obligationData = obligationDataBuilder.getObligationData();

    }





}
