package com.jobsity.tenPinBowling.printer;

import com.jobsity.tenPinBowling.Frame;
import com.jobsity.tenPinBowling.Roll;

public class ConsoleFramePrinter implements FramePrinter{


    private Console console;

    public ConsoleFramePrinter(Console console) {
        this.console = console;
    }


    @Override
    public void printPinfals(Frame frame){
        if (frame.isStrike()){
            Roll.PinFalls ten = frame.getRolls().get(0).getPinfalls();
            console.printf("%-4s ", ten.getMnemonic());
        }else{
            if(frame.isLast()){
                console.printf("%-3s ", frame.getRolls().get(0).getPinfalls().getMnemonic());
                console.printf("%-3s ", frame.getRolls().get(1).getPinfalls().getMnemonic());
                console.printf("%-3s ", frame.getRolls().get(2).getPinfalls().getMnemonic());
            }else{
                console.printf("%-2s", frame.getRolls().get(0).getPinfalls().getMnemonic());
                if(frame.isSpare()){
                    console.printf("%-2s", "/");
                }else {
                    console.printf("%-2s", frame.getRolls().get(1).getPinfalls().getMnemonic());
                }
                console.print(" ");
            }
        }
    }

    @Override
    public void printScore(Frame frame){
        console.printf("%-4s ", frame.getAccumulatedScore());

    }
}
