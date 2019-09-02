package com.jobsity.tenPinBowling;

import java.util.List;

public interface Frame {

    List<Roll> getRolls();

    boolean isStrike();

    int getScore();

    int getAccumulatedScore();

    void setAccumulatedScore(int score);

    void setNext(Frame nextFrame);

    Frame next();

    boolean hasNext();

    boolean isLast();

    boolean isSpare();
}
