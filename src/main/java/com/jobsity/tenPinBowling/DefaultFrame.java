package com.jobsity.tenPinBowling;

import java.util.List;

public class DefaultFrame implements Frame {

    List<Roll> rolls;

    int score;

    public DefaultFrame(List<Roll> rolls) {
        this.rolls = rolls;
    }

    boolean isStrike(){
        return rolls.get(0).getPinfalls().equals(Roll.PinFalls.TEN);
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public void printPinfals(Console console){
        if(rolls.size()==1 && rolls.get(0).getPinfalls().equals(Roll.PinFalls.TEN)){
            console.printf("%-2s ", " ");
            console.printf("%-2s", "X");
        }
    }
}
