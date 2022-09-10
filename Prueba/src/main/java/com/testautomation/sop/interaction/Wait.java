package com.testautomation.sop.interaction;

import net.serenitybdd.core.time.InternalSystemClock;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;

public class Wait implements Interaction {

    private int time;

    public Wait(int time) {
        this.time = time;
    }

    public static Wait aTime(int time) {
        return Tasks.instrumented(Wait.class, time);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        InternalSystemClock clock = new InternalSystemClock();
        clock.pauseFor(time);
    }
}
