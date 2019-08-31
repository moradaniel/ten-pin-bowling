package com.jobsity.tenPinBowling;

public class DefaultPlayer implements Player {

    final private String name;

    public DefaultPlayer(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }
}
