package com.jobsity.tenPinBowling.file;


import java.util.Scanner;

public class PlayerChanceFileReader implements PlayerChanceReader{

    public PlayerChance parse(String str, String separator){
        String playerName = null;
        String rollScore = null;
        Scanner sc = new Scanner(str);
        sc.useDelimiter(separator);

        while(sc.hasNext()){
            playerName = sc.next();
            rollScore = sc.next();
        }
        sc.close();

        return new PlayerChance(playerName,rollScore);
    }


}
