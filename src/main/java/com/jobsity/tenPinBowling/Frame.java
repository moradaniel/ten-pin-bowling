package com.jobsity.tenPinBowling;

import java.util.List;

public interface Frame {

    List<Roll> getRolls();

    boolean isStrike();

    int getScore();

    void setScore(int score);

    int getAccumulatedScore();

    void setAccumulatedScore(int score);

    void setNext(Frame nextFrame);

    void printPinfals(Console console);

    void printScore(Console console);

    Frame next();

    boolean hasNext();

    boolean isLast();

}
