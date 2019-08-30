package com.jobsity.tenPinBowling;

import java.util.List;

public class DefaultGame implements Game{


    Player player;
    List<Frame> frames;

    public DefaultGame(Player player, List<Frame> frames) {
        this.player = player;
        this.frames = frames;
    }

    public void print(Console console){

        console.printf("%-10s %3s %3s %3s %3s %3s %3s %3s %3s %3s %3s ", "Frame", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10");

    }
}
