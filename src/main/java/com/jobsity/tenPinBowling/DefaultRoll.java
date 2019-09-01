package com.jobsity.tenPinBowling;

public class DefaultRoll implements Roll{

    PinFalls pinfalls;

    public DefaultRoll(PinFalls pinfalls) {
        /*if(pinfalls<0 || pinfalls>10){
            throw new IllegalArgumentException("pinfalls must be between 0 and 10");
        }
        */
        this.pinfalls = pinfalls;
    }


    @Override
    public PinFalls getPinfalls() {
        return pinfalls;
    }


}
