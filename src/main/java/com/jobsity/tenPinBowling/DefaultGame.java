package com.jobsity.tenPinBowling;

import org.apache.commons.lang3.Validate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class DefaultGame implements Game{

    Player player;
    List<Frame> frames;

    public DefaultGame(Player player, List<Roll> rolls) {
        Validate.notNull(player);
        Validate.notEmpty(rolls, "Rolls cannot be empty");
        //Validate.isTrue(frames.size() == 10,"A game must have 10 frames",frames.size());

        this.player = player;

        this.frames = populateFrames(rolls);
    }

    private List<Frame> populateFrames(List<Roll> rolls) {
        List linkedListFrames = new LinkedList();

        for(Roll roll: rolls){
            if(roll.getPinfalls().equals(Roll.PinFalls.TEN)){
                linkedListFrames.add(new DefaultFrame(Arrays.asList(roll)));
            }
        }
        return linkedListFrames;
    }



    @Override
    public void print(Console console){

        console.printf("%-10s",player.getName());
        console.print("\n");

        console.printf("%-10s ","Pinfals");

        frames.stream()
                .forEach(frame->frame.printPinfals(console));

        console.print("\n");
    }
}
