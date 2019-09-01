package com.jobsity.tenPinBowling.file;

import com.jobsity.tenPinBowling.*;

import java.io.File;
import java.io.IOException;
import java.util.*;

final public class MatchInFileReader implements MatchReader {
    private final File file;

    public MatchInFileReader(final File src) {
        this.file = src;
    }

    @Override
    public Match read() {
        Map<String, List<Roll>> rollsByPlayer = new HashMap<>();

        Scanner sc = null;
        try {
            sc = new Scanner(file);
            while(sc.hasNextLine()){
                String str = sc.nextLine();
                PlayerChance playerChance = new PlayerChanceFileReader().parse(str,"\t");

                if(rollsByPlayer.get(playerChance.getPlayerName())==null){
                    rollsByPlayer.put(playerChance.getPlayerName(),new ArrayList<>());
                }
                rollsByPlayer.get(playerChance.getPlayerName()).add(new DefaultRoll(playerChance.getRollPinFalls()));
            }

        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }

        sc.close();

        //------------------------------------------------------------------------------

        List<Game> games = new ArrayList<>();

        for (Map.Entry<String, List<Roll>> mapElement : rollsByPlayer.entrySet()) {
            String playerName = mapElement.getKey();
            games.add(new DefaultGame(new DefaultPlayer(playerName), mapElement.getValue()));
        }


        Match match = new DefaultMatch(games);

        return match;
    }

}