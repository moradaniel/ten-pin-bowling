package com.jobsity.tenPinBowling;

import java.util.Arrays;

public interface Roll {

    enum PinFalls {
        ZERO("0",0),
        ONE("1",1),
        TWO("2",2),
        THREE("3",3),
        FOUR("4",4),
        FIVE("5",5),
        SIX("6",6),
        SEVEN("7",7),
        EIGHT("8",8),
        NINE("9",9),
        TEN("X",10),
        FOUL("F",0);



        PinFalls(String mnemonic,int value) {
            this.mnemonic = mnemonic;
            this.value = value;
        }

        private final String mnemonic;
        private final int value;

        public int getValue() {
            return this.value;
        }
        public String getMnemonic() {
            return mnemonic;
        }

    }


    PinFalls getPinfalls();

}
