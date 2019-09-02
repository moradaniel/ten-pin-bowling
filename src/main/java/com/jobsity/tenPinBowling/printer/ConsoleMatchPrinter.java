package com.jobsity.tenPinBowling.printer;

import com.jobsity.tenPinBowling.Match;

public class ConsoleMatchPrinter implements MatchPrinter {

    private Console console;

    private GamePrinter gamePrinter;

    private String headerFormat = "%-10s %-4s %-4s %-4s %-4s %-4s %-4s %-4s %-4s %-4s %-5s %n";

    public ConsoleMatchPrinter(Console console,GamePrinter gamePrinter) {
        this.console = console;
        this.gamePrinter = gamePrinter;
    }

    @Override
    public void print(Match match) {
        console.printf(headerFormat, "Frame", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10");
        match.getGames().stream()
                .forEach(game->gamePrinter.print(game));
    }
}
