package com.jobsity.tenPinBowling;

import com.jobsity.tenPinBowling.file.MatchInFileReader;
import com.jobsity.tenPinBowling.file.MatchReader;

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
        match.print(new DefaultConsole(System.out));

    }

}
