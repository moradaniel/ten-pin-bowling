package com.jobsity.tenPinBowling;

import java.util.List;

public class DefaultMatch implements Match {

    List<Game> games;

    private String headerFormat = "%-10s %-4s %-4s %-4s %-4s %-4s %-4s %-4s %-4s %-4s %-5s %n";

    public DefaultMatch(List<Game> games) {
        this.games = games;
    }

    @Override
    public void print(Console console){
        console.printf(headerFormat, "Frame", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10");
        games.stream()
                .forEach(game->game.print(console));
    }

}
