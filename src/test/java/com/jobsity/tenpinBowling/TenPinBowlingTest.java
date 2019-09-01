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
        /**
         * Carl	0
         * Carl	0
         * Carl	0
         * Carl	0
         * Carl	0
         * Carl	0
         * Carl	0
         * Carl	0
         * Carl	0
         * Carl	0
         * Carl	0
         * Carl	0
         * Carl	0
         * Carl	0
         * Carl	0
         * Carl	0
         * Carl	0
         * Carl	0
         * Carl	0
         * Carl	0
         * Carl	0
         */

        Player player = new DefaultPlayer("Carl      ");
        List<Roll> rolls = Arrays.asList(
                new DefaultRoll(Roll.PinFalls.ZERO),
                new DefaultRoll(Roll.PinFalls.ZERO),
                new DefaultRoll(Roll.PinFalls.ZERO),
                new DefaultRoll(Roll.PinFalls.ZERO),
                new DefaultRoll(Roll.PinFalls.ZERO),
                new DefaultRoll(Roll.PinFalls.ZERO),
                new DefaultRoll(Roll.PinFalls.ZERO),
                new DefaultRoll(Roll.PinFalls.ZERO),
                new DefaultRoll(Roll.PinFalls.ZERO),
                new DefaultRoll(Roll.PinFalls.ZERO),
                new DefaultRoll(Roll.PinFalls.ZERO),
                new DefaultRoll(Roll.PinFalls.ZERO),
                new DefaultRoll(Roll.PinFalls.ZERO),
                new DefaultRoll(Roll.PinFalls.ZERO),
                new DefaultRoll(Roll.PinFalls.ZERO),
                new DefaultRoll(Roll.PinFalls.ZERO),
                new DefaultRoll(Roll.PinFalls.ZERO),
                new DefaultRoll(Roll.PinFalls.ZERO),
                new DefaultRoll(Roll.PinFalls.ZERO),
                new DefaultRoll(Roll.PinFalls.ZERO),
                new DefaultRoll(Roll.PinFalls.ZERO)
        );

        Game game = new DefaultGame(player, rolls);


        Match match = new DefaultMatch(Arrays.asList(game));

        ByteArrayOutputStream outSpy = new ByteArrayOutputStream();

        DefaultConsole writer = new DefaultConsole(new PrintStream(outSpy));

        match.print(writer);

        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("Frame      1    2    3    4    5    6    7    8    9    10    ").append("\n");
        stringBuffer.append(player.getName()).append("\n");
        stringBuffer.append("Pinfals    0 0  0 0  0 0  0 0  0 0  0 0  0 0  0 0  0 0  0   0   0   ").append("\n");
        stringBuffer.append("Score      0    0    0    0    0    0    0    0    0    0    ").append("\n");
        stringBuffer.append("\n");

        assertThat(outSpy.toString()).isEqualTo(stringBuffer.toString());
    }

    @Test
    public void testAllRollsFouls(){
        /**
         * Carl	F
         * Carl	F
         * Carl	F
         * Carl	F
         * Carl	F
         * Carl	F
         * Carl	F
         * Carl	F
         * Carl	F
         * Carl	F
         * Carl	F
         * Carl	F
         * Carl	F
         * Carl	F
         * Carl	F
         * Carl	F
         * Carl	F
         * Carl	F
         * Carl	F
         * Carl	F
         * Carl	F
         */

        Player player = new DefaultPlayer("Carl      ");
        List<Roll> rolls = Arrays.asList(
                new DefaultRoll(Roll.PinFalls.FOUL),
                new DefaultRoll(Roll.PinFalls.FOUL),
                new DefaultRoll(Roll.PinFalls.FOUL),
                new DefaultRoll(Roll.PinFalls.FOUL),
                new DefaultRoll(Roll.PinFalls.FOUL),
                new DefaultRoll(Roll.PinFalls.FOUL),
                new DefaultRoll(Roll.PinFalls.FOUL),
                new DefaultRoll(Roll.PinFalls.FOUL),
                new DefaultRoll(Roll.PinFalls.FOUL),
                new DefaultRoll(Roll.PinFalls.FOUL),
                new DefaultRoll(Roll.PinFalls.FOUL),
                new DefaultRoll(Roll.PinFalls.FOUL),
                new DefaultRoll(Roll.PinFalls.FOUL),
                new DefaultRoll(Roll.PinFalls.FOUL),
                new DefaultRoll(Roll.PinFalls.FOUL),
                new DefaultRoll(Roll.PinFalls.FOUL),
                new DefaultRoll(Roll.PinFalls.FOUL),
                new DefaultRoll(Roll.PinFalls.FOUL),
                new DefaultRoll(Roll.PinFalls.FOUL),
                new DefaultRoll(Roll.PinFalls.FOUL),
                new DefaultRoll(Roll.PinFalls.FOUL)
        );

        Game game = new DefaultGame(player, rolls);


        Match match = new DefaultMatch(Arrays.asList(game));

        ByteArrayOutputStream outSpy = new ByteArrayOutputStream();

        DefaultConsole writer = new DefaultConsole(new PrintStream(outSpy));

        match.print(writer);

        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("Frame      1    2    3    4    5    6    7    8    9    10    ").append("\n");
        stringBuffer.append(player.getName()).append("\n");
        stringBuffer.append("Pinfals    F F  F F  F F  F F  F F  F F  F F  F F  F F  F   F   F   ").append("\n");
        stringBuffer.append("Score      0    0    0    0    0    0    0    0    0    0    ").append("\n");
        stringBuffer.append("\n");

        assertThat(outSpy.toString()).isEqualTo(stringBuffer.toString());

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
        stringBuffer.append("Pinfals    X    X    X    X    X    X    X    X    X    X   X   X   ").append("\n");
        stringBuffer.append("Score      30   60   90   120  150  180  210  240  270  300  ").append("\n");
        stringBuffer.append("\n");

        assertThat(outSpy.toString()).isEqualTo(stringBuffer.toString());


    }


    @Test
    public void testJeff(){

        /*
        Jeff	10
        Jeff	7
        Jeff	3
        Jeff	9
        Jeff	0
        Jeff	10
        Jeff	0
        Jeff	8
        Jeff	8
        Jeff	2
        Jeff	F
        Jeff	6
        Jeff	10
        Jeff	10
        Jeff	10
        Jeff	8
        Jeff	1
        */

        Player player = new DefaultPlayer("Jeff      ");
        List<Roll> rolls = Arrays.asList(
                new DefaultRoll(Roll.PinFalls.TEN),
                new DefaultRoll(Roll.PinFalls.SEVEN),
                new DefaultRoll(Roll.PinFalls.THREE),
                new DefaultRoll(Roll.PinFalls.NINE),
                new DefaultRoll(Roll.PinFalls.ZERO),
                new DefaultRoll(Roll.PinFalls.TEN),
                new DefaultRoll(Roll.PinFalls.ZERO),
                new DefaultRoll(Roll.PinFalls.EIGHT),
                new DefaultRoll(Roll.PinFalls.EIGHT),
                new DefaultRoll(Roll.PinFalls.TWO),
                new DefaultRoll(Roll.PinFalls.FOUL),
                new DefaultRoll(Roll.PinFalls.SIX),
                new DefaultRoll(Roll.PinFalls.TEN),
                new DefaultRoll(Roll.PinFalls.TEN),
                new DefaultRoll(Roll.PinFalls.TEN),
                new DefaultRoll(Roll.PinFalls.EIGHT),
                new DefaultRoll(Roll.PinFalls.ONE)
        );

        Game game = new DefaultGame(player, rolls);


        Match match = new DefaultMatch(Arrays.asList(game));

        ByteArrayOutputStream outSpy = new ByteArrayOutputStream();

        DefaultConsole writer = new DefaultConsole(new PrintStream(outSpy));

        match.print(writer);

        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("Frame      1    2    3    4    5    6    7    8    9    10    ").append("\n");
        stringBuffer.append(player.getName()).append("\n");
        stringBuffer.append("Pinfals    X    7 /  9 0  X    0 8  8 /  F 6  X    X    X   8   1   ").append("\n");
        stringBuffer.append("Score      20   39   48   66   74   84   90   120  148  167  ").append("\n");
        stringBuffer.append("\n");

        assertThat(outSpy.toString()).isEqualTo(stringBuffer.toString());

    }

}
