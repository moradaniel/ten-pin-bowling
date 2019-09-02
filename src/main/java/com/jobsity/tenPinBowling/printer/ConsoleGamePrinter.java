package com.jobsity.tenPinBowling.printer;

import com.jobsity.tenPinBowling.Frame;
import com.jobsity.tenPinBowling.Game;

public class ConsoleGamePrinter implements GamePrinter {

    private Console console;
    private FramePrinter framePrinter;


    public ConsoleGamePrinter(Console console,FramePrinter framePrinter) {
        this.console = console;
        this.framePrinter = framePrinter;
    }

    @Override
    public void print(Game game) {
        console.printf("%-10s",game.getPlayer().getName());
        console.print("\n");

        printPinFals(game);

        printScores(game);

        console.print("\n");
    }

    private void printScores(Game game) {
        console.printf("%-10s ","Score");

        Frame current = game.head();
        while(current!=null){
            framePrinter.printScore(current);
            current = current.next();
        }
        console.print("\n");
    }

    private void printPinFals(Game game) {
        console.printf("%-10s ","Pinfals");

        Frame current = game.head();
        while(current!=null){
            framePrinter.printPinfals(current);
            current = current.next();
        }
        console.print("\n");
    }
}
