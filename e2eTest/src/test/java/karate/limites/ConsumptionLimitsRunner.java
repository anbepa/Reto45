package karate.limites;

import com.intuit.karate.junit5.Karate;


import static karate.infrastructure.utils.ConstantsFeatures.CONSUMPTION_LIMITS;


public class ConsumptionLimitsRunner {


    @Karate.Test
    Karate queryTermsFindByChannel() {
        return Karate.run(CONSUMPTION_LIMITS).relativeTo(getClass());
    }
}
