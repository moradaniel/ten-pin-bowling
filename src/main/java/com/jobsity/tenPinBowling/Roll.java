package com.jobsity.tenPinBowling;

public interface Roll {

    enum PinFalls {
        Zero("0"),
        ONE("1"),
        TWO("2"),
        THREE("3"),
        FOUR("4"),
        FIVE("5"),
        SIX("6"),
        SEVEN("7"),
        EIGHT("8"),
        NINE("9"),
        TEN("10"),
        FAIL("F");



        PinFalls(String mnemonic) {
            this.mnemonic = mnemonic;
        }

        private final String mnemonic;

        public int getValue() {
            int value;
            if(mnemonic.equalsIgnoreCase("F")){
                value = 0;
            }else {
                try {
                    value = Integer.valueOf(mnemonic);

                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
            }

            return value;

        }
        public String getMnemonic() {
            return mnemonic;
        }
    }


    PinFalls getPinfalls();

}
