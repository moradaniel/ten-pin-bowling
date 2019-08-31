package com.jobsity.tenpinBowling;

import com.jobsity.tenPinBowling.*;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class PrintScoreFeatureTest {

    @Mock
    DefaultConsole console;

    private Game game;

    Match match;

    @Before
    public void initialise(){
        Player player = new DefaultPlayer("Carl");

        List<Roll> rolls = Arrays.asList(
                new DefaultRoll(Roll.PinFalls.TEN));

        game = new DefaultGame(player,rolls);

        match = new DefaultMatch(Arrays.asList(game));
    }

    @Test
    @Ignore
    public void testHeaderFormat(){
        match.print(console);
        verify(console).printf("%-10s %3s %3s %3s %3s %3s %3s %3s %3s %3s %3s ", "Frame", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10");
    }

    @Test
    @Ignore
    public void testHeader(){

        ByteArrayOutputStream outSpy = new ByteArrayOutputStream();

        DefaultConsole writer = new DefaultConsole(new PrintStream(outSpy));

        match.print(writer);

        assertThat(outSpy.toString()).isEqualTo("Frame      1    2    3    4    5    6    7    8    9    10    ");

    }
}
