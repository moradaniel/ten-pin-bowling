package com.jobsity.tenPinBowling.printer;

import java.io.PrintStream;

public class DefaultConsole implements Console {

    private PrintStream printStream;

    public DefaultConsole(PrintStream printStream) {
        this.printStream = printStream;
    }

    @Override
    public void printf(String format, Object... args) {
        printStream.printf(format,args);
    }

    @Override
    public void print(String s){
        printStream.print(s);
    }
}
