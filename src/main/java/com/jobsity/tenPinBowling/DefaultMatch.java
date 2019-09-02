package com.jobsity.tenPinBowling;

import java.util.List;

public class DefaultMatch implements Match {

    List<Game> games;

    public DefaultMatch(List<Game> games) {
        this.games = games;
    }

    @Override
    public List<Game> getGames() {
        return games;
    }


}
