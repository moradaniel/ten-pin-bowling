package com.jobsity.tenPinBowling;

import java.util.List;

public class DefaultFrame implements Frame {

    List<Roll> rolls;

    int accumulatedScore;

    Frame next;

    public DefaultFrame(List<Roll> rolls) {
        this.rolls = rolls;
        next = null;
    }

    @Override
    public List<Roll> getRolls() {
        return rolls;
    }

    @Override
    public boolean isStrike(){
        return rolls.size()==1 && rolls.get(0).getPinfalls().equals(Roll.PinFalls.TEN);
    }

    @Override
    public int getScore() {
        int score = 0;
        for(Roll roll: rolls){
            score = score + roll.getPinfalls().getValue();
        }
        return score;
    }

    @Override
    public void setScore(int score) {
        // TODO remove this method
    }


    @Override
    public int getAccumulatedScore() {
        return accumulatedScore;
    }

    @Override
    public void setAccumulatedScore(int accumulatedScore) {
        this.accumulatedScore = accumulatedScore;
    }

    @Override
    public void setNext(Frame nextFrame) {
        this.next = nextFrame;
    }



    @Override
    public void printPinfals(Console console){
        if (isStrike()){
            Roll.PinFalls ten = rolls.get(0).getPinfalls();
            console.printf("%-2s ", " ");
            console.printf("%-2s", ten.getMnemonic());
        }else{
            if(isLast()){
                console.printf("%-2s ", " ");
                console.printf("%-2s", rolls.get(0).getPinfalls().getMnemonic());
                console.printf("%-2s ", " ");
                console.printf("%-2s", rolls.get(1).getPinfalls().getMnemonic());
                console.printf("%-2s ", " ");
                console.printf("%-2s", rolls.get(2).getPinfalls().getMnemonic());
            }
        }
    }

    @Override
    public void printScore(Console console){
        console.printf("%-4s ", getAccumulatedScore());

    }

    @Override
    public Frame next() {
        return this.next;
    }

    @Override
    public boolean hasNext() {
        return this.next!=null;
    }

    @Override
    public boolean isLast() {
        return !hasNext();
    }

}
