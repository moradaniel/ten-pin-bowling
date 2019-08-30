package com.jobsity.tenPinBowling;

import java.util.ArrayList;
import java.util.List;

public class GamePrinter {

    public static void main(String[] args){

        Player player = new DefaultPlayer();
        List<Frame> frames = new ArrayList<>();

        Game game = new DefaultGame(player,frames);

        game.print(new DefaultConsole(System.out));

    }

}
