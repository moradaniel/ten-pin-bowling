package com.jobsity.tenPinBowling;

public class DefaultRoll implements Roll{

    PinFalls pinfalls;

    public DefaultRoll(PinFalls pinfalls) {
        this.pinfalls = pinfalls;
    }


    @Override
    public PinFalls getPinfalls() {
        return pinfalls;
    }


}
