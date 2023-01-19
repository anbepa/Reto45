package co.com.bancolombia.certification.saf.models.builders;

import co.com.bancolombia.certification.saf.models.entitys.Obligation;
import co.com.bancolombia.certification.saf.utils.Builder;
import java.util.List;


public class ObligationDataBuilder implements Builder<Obligation> {

    private List<String> obligationData;

    public List<String> getObligationData() {
        return obligationData;
    }



    @Override
    public Obligation build(){

        return new Obligation(this);
    }


    public ObligationDataBuilder withScenary(List<String> obligationData) {
        this.obligationData = obligationData;
        return this;
    }






    public static ObligationDataBuilder inThe(){
        return new ObligationDataBuilder();
    }

    public static ObligationDataBuilder withNumber(){
        return new ObligationDataBuilder();
    }
}
