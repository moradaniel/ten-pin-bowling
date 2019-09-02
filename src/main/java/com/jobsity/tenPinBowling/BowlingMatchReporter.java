package com.jobsity.tenPinBowling;

import com.jobsity.tenPinBowling.file.MatchInFileReader;
import com.jobsity.tenPinBowling.file.MatchReader;
import com.jobsity.tenPinBowling.printer.*;

import java.io.File;

public class BowlingMatchReporter {

    public static void main(String[] args) {

        if (args.length==0){
            System.out.println("Error: Bad filename.");
            System.out.println("Syntax: java -jar pepe.jar /path/to/inputfile.txt");
            System.exit(0);
        }

        String fileName = args[0];

        MatchReader matchReader = new MatchInFileReader(new File(fileName));

        Match match = matchReader.read();

        Console console = new DefaultConsole(System.out);

        MatchPrinter matchPrinter = new ConsoleMatchPrinter(console,
                                    new ConsoleGamePrinter(console,
                                    new ConsoleFramePrinter(console)));
        matchPrinter.print(match);

    }

}
