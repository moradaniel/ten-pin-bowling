package com.jobsity.tenpinBowling;


import com.jobsity.tenPinBowling.*;
import org.junit.Test;


import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class TenPinBowlingTest {


    @Test
    public void testAllRollsAre0(){
     //TODO
    }

    @Test
    public void testAllRollsFouls(){
      //TODO
    }

    @Test
    public void testAllRollsStrikes(){
        /**
         * Carl	10
         * Carl	10
         * Carl	10
         * Carl	10
         * Carl	10
         * Carl	10
         * Carl	10
         * Carl	10
         * Carl	10
         * Carl	10
         * Carl	10
         * Carl	10
         */

        Player player = new DefaultPlayer("Carl      ");
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

        ByteArrayOutputStream outSpy = new ByteArrayOutputStream();

        DefaultConsole writer = new DefaultConsole(new PrintStream(outSpy));

        match.print(writer);

        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("Frame      1    2    3    4    5    6    7    8    9    10    ").append("\n");
        stringBuffer.append(player.getName()).append("\n");
        stringBuffer.append("Pinfals       X    X    X    X    X    X    X    X    X    X    X    X ").append("\n");
        stringBuffer.append("Score      30   60   90   120  150  180  210  240  270  300  ").append("\n");
        stringBuffer.append("\n");

        assertThat(outSpy.toString()).isEqualTo(stringBuffer.toString());


    }

}
