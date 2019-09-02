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
    public boolean isSpare() {
        return rolls.size()==2 && getScore()==10;
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
