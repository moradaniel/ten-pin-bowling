package com.jobsity.tenPinBowling;

import org.apache.commons.lang3.Validate;

import java.util.*;

public class DefaultGame implements Game{

    Player player;
    Frame head = null;
    int size = 0;

    public DefaultGame(Player player, List<Roll> rolls) {
        Validate.notNull(player);
        Validate.notEmpty(rolls, "Rolls cannot be empty");

        this.player = player;

        populateFrames(rolls);
        calculateScore();
    }

    private void populateFrames(List<Roll> rolls) {

        List<Roll> rollsPerFrame = new ArrayList<>();
        for(Roll roll: rolls){
            if(size<9) {
                if (roll.getPinfalls().equals(Roll.PinFalls.TEN)) {
                    rollsPerFrame.add(roll);
                    addFrame(rollsPerFrame);
                    rollsPerFrame = new ArrayList<>();
                }
                else{
                    rollsPerFrame.add(roll);
                    if(rollsPerFrame.size()==2){
                        addFrame(rollsPerFrame);
                        rollsPerFrame = new ArrayList<>();
                    }
                }
            }else{
                //last frame
                rollsPerFrame.add(roll);
                if(rollsPerFrame.size()==3){
                    addFrame(rollsPerFrame);
                }
            }
        }

        Validate.isTrue(size == 10,"A game must have 10 frames.",size);
    }

    Frame addFrame(List<Roll> rolls){
        Frame newFrame = new DefaultFrame(rolls);

        if(head==null){
            head = newFrame;
        }else{
            Frame current = head;
            while(current.next()!=null){
                current = current.next();
            }

            current.setNext(newFrame);
        }

        size++;

        return newFrame;
    }



    private void calculateScore() {

        Frame current = head;

        int previousFrameScore = 0;
        while(current!=null) {
            Frame nextFrame = current.next();
            if (!current.isLast()){
                if (current.isStrike()) {
                    current.setAccumulatedScore(previousFrameScore + current.getScore() + addAccumulatedScore(nextFrame, 2));
                }else {
                    if (current.isSpare()) {
                        current.setAccumulatedScore(previousFrameScore + current.getScore() + nextFrame.getRolls().get(0).getPinfalls().getValue());
                    }else {
                        current.setAccumulatedScore(previousFrameScore + current.getScore());
                    }
                }
            }else{
                current.setAccumulatedScore(previousFrameScore + current.getScore());
            }
                previousFrameScore = current.getAccumulatedScore();
            current = current.next();
        }
    }

    private int addAccumulatedScore(Frame frame,int lookforwardMax){

        Frame current = frame;

        int accumulatedScore = 0;

        if(current!=null) {
            if (lookforwardMax > 0) {
                if (!current.isLast()) {
                    if (current.isStrike()) {
                        accumulatedScore = current.getScore();
                        accumulatedScore += addAccumulatedScore(current.next(), lookforwardMax - 1);
                    }else{
                        accumulatedScore = current.getScore();
                    }

                } else {//current is last

                        List<Roll> rolls = current.getRolls();
                        Roll firstRoll = rolls.get(0);
                        if (firstRoll.getPinfalls().equals(Roll.PinFalls.TEN)) {
                            accumulatedScore += firstRoll.getPinfalls().getValue();
                            if (lookforwardMax==2){
                                Roll secondRoll = rolls.get(1);
                                accumulatedScore += secondRoll.getPinfalls().getValue();
                            }
                        } else {
                            accumulatedScore += firstRoll.getPinfalls().getValue();
                        }
                }

            }//lookforwardMax
        }
        return accumulatedScore;
    }

    @Override
    public Frame head() {
        return this.head;
    }

    @Override
    public Player getPlayer() {
        return this.player;
    }
}
