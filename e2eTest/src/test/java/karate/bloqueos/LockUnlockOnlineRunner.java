package karate.bloqueos;

import com.intuit.karate.junit5.Karate;

import static karate.infrastructure.utils.ConstantsFeatures.CONSUMPTION_LIMITS;
import static karate.infrastructure.utils.ConstantsFeatures.LOCKUNLOCKON_LINE;


public class LockUnlockOnlineRunner {


    @Karate.Test
    Karate queryTermsFindByChannel() {
        return Karate.run(LOCKUNLOCKON_LINE).relativeTo(getClass());
    }
}
