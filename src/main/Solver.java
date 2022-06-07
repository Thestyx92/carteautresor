package main;

import main.models.Adventurer;
import main.models.Mountain;
import main.models.Treasure;
import main.utils.AdventurerUtils;
import main.utils.FileUtils;

import java.nio.file.NoSuchFileException;
import java.util.List;

public class Solver {

    public static void solve(String file) throws Exception {

        if (file == null || file.isEmpty())
            throw new NoSuchFileException("Aucun nom de fichier");

        Parser parser = new Parser();

        parser.parseFile(file);
        main.models.Map map = parser.getMap();
        List<Mountain> mountains = parser.getMountains();
        List<Treasure> treasures = parser.getTreasures();
        List<Adventurer> adventurers = parser.getAdventurers();

        while (AdventurerUtils.movesRemaining(adventurers))
            AdventurerUtils.playTurn(map, mountains, treasures, adventurers);

        FileUtils.createOutputFile(map, mountains, treasures, adventurers);
    }
}
