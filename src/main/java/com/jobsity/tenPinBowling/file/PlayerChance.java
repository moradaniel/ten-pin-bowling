package com.jobsity.tenPinBowling.file;

import com.jobsity.tenPinBowling.Roll;
import org.apache.commons.lang3.Validate;

public class PlayerChance {
    String playerName;
    Roll.PinFalls pinFalls;

    public PlayerChance(String playerName, String rollScore) {

        Validate.notEmpty(playerName, "Player name cannot be empty");


        String mnemonic = rollScore;
        int value;

        switch (mnemonic) {
            case "10":
                mnemonic = "X";
                value = 10;
                break;
            case "F":
                value = 0;
                break;
            default:
                value = Integer.valueOf(rollScore);

        }


        boolean isValidPinFalls = false;

        for (Roll.PinFalls pinFalls : Roll.PinFalls.values()) {
            if (pinFalls.getMnemonic().equals(mnemonic) && pinFalls.getValue() == value) {
                this.pinFalls = pinFalls;
                isValidPinFalls = true;
                break;
            }
        }
        Validate.isTrue(isValidPinFalls, "Roll score not valid", playerName, rollScore);


        this.playerName = playerName;
    }

    public String getPlayerName() {
        return playerName;
    }

    Roll.PinFalls getRollPinFalls(){
        return pinFalls;
    }
}
