package com.jobsity.tenPinBowling;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GamePrinter {

    public static void main(String[] args){

        Player player = new DefaultPlayer("Carl");
        List<Roll> rolls = Arrays.asList(
                new DefaultRoll(Roll.PinFalls.TEN),
                new DefaultRoll(Roll.PinFalls.TEN),
                new DefaultRoll(Roll.PinFalls.TEN),
                new DefaultRoll(Roll.PinFalls.TEN),
                new DefaultRoll(Roll.PinFalls.TEN),
                new DefaultRoll(Roll.PinFalls.TEN),
                new DefaultRoll(Roll.PinFalls.TEN),
                new DefaultRoll(Roll.PinFalls.TEN),
                new DefaultRoll(Roll.PinFalls.TEN),
                new DefaultRoll(Roll.PinFalls.TEN),
                new DefaultRoll(Roll.PinFalls.TEN),
                new DefaultRoll(Roll.PinFalls.TEN)
        );

        Game game = new DefaultGame(player, rolls);


        Match match = new DefaultMatch(Arrays.asList(game));

        match.print(new DefaultConsole(System.out));

    }

}
