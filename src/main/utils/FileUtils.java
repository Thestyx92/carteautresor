package main.utils;

import main.models.Adventurer;
import main.models.Map;
import main.models.Mountain;
import main.models.Treasure;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class FileUtils {

    public static void createOutputFile(Map map,
                                        List<Mountain> mountains,
                                        List<Treasure> treasures,
                                        List<Adventurer> adventurers) {
        try {
            FileWriter myWriter = new FileWriter("output.txt");
            myWriter.write(String.format("C - %d - %d\n", map.getWidth(), map.getHeight()));
            mountains.forEach(mountain -> {
                try {
                    myWriter.write(String.format("M - %d - %d\n",
                            mountain.getPosition().getX(),
                            mountain.getPosition().getY()));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
            treasures.forEach(treasure -> {
                try {
                    if (treasure.getCount() > 0)
                        myWriter.write(String.format("T - %d - %d - %d\n",
                                treasure.getPosition().getX(),
                                treasure.getPosition().getY(),
                                treasure.getCount()));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
            adventurers.forEach(adventurer -> {
                try {
                    myWriter.write(String.format("A - %s - %d - %d - %s - %d\n",
                            adventurer.getName(),
                            adventurer.getPosition().getX(),
                            adventurer.getPosition().getY(),
                            adventurer.getDirection(),
                            adventurer.getTreasures()));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
            myWriter.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
