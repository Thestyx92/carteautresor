package main;

import main.models.Adventurer;
import main.models.Map;
import main.models.Mountain;
import main.models.Treasure;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Parser {

    private static final String regexMap = "C - \\d+ - \\d+";
    private static final String regexMountain = "M - \\d+ - \\d+";
    private static final String regexTreasure = "T - \\d+ - \\d+ - \\d+";
    private static final String regexAdventurer = "A - ([A-zA-Z]+) - \\d+ - \\d+ - ([NSEO]{1}) - ([AGD]+)";
    private final Map map;
    private final List<Mountain> mountains;
    private final List<Treasure> treasures;
    private final List<Adventurer> adventurers;

    public Parser() {
        map = new Map();
        mountains = new ArrayList<>();
        treasures = new ArrayList<>();
        adventurers = new ArrayList<>();
    }

    public void parseFile(String file) throws Exception {

        Pattern intPattern = Pattern.compile("\\d+");
        Pattern namePattern = Pattern.compile("[A-zA-Z]+");
        Pattern directionPattern = Pattern.compile("[NSEO]{1}");
        Pattern movePattern = Pattern.compile("[AGD]+");

        List<String> lines = new BufferedReader(new InputStreamReader(new FileInputStream(file)))
                .lines()
                .filter(line -> !line.startsWith("#"))
                .collect(Collectors.toList());

        // Si le fichier ne commence pas par les données de carte on leve une exeption.
        if (lines.isEmpty() || !lines.get(0).matches(regexMap))
            throw new RuntimeException("Le fichier ne commence pas par l'initialisation de la carte.");
        else {
            Matcher matcher = intPattern.matcher(lines.get(0));
            if (matcher.find())
                map.setWidth(Integer.parseInt(matcher.group()));
            if (matcher.find())
                map.setHeight(Integer.parseInt(matcher.group()));
        }

        lines.forEach(line -> {
            if (line.matches(regexMountain)) {
                Mountain mountain = new Mountain();
                Matcher matcher = intPattern.matcher(line);
                if (matcher.find())
                    mountain.getPosition().setX(Integer.parseInt(matcher.group()));
                if (matcher.find())
                    mountain.getPosition().setY(Integer.parseInt(matcher.group()));
                mountains.add(mountain);
            } else if (line.matches(regexTreasure)) {
                Treasure treasure = new Treasure();
                Matcher matcher = intPattern.matcher(line);
                if (matcher.find())
                    treasure.getPosition().setX(Integer.parseInt(matcher.group()));
                if (matcher.find())
                    treasure.getPosition().setY(Integer.parseInt(matcher.group()));
                if (matcher.find())
                    treasure.setCount(Integer.parseInt(matcher.group()));
                treasures.add(treasure);
            } else if (line.matches(regexAdventurer)) {
                Adventurer adventurer = new Adventurer();
                Matcher nameMatcher = namePattern.matcher(line.split(" - ")[1]);
                if (nameMatcher.find())
                    adventurer.setName(nameMatcher.group());

                Matcher positionMatcher = intPattern.matcher(line);
                if (positionMatcher.find())
                    adventurer.getPosition().setX(Integer.parseInt(positionMatcher.group()));
                if (positionMatcher.find())
                    adventurer.getPosition().setY(Integer.parseInt(positionMatcher.group()));

                Matcher directionMatcher = directionPattern.matcher(line.split(" - ")[4]);
                if (directionMatcher.find())
                    adventurer.setDirection(directionMatcher.group());

                Matcher moveMatcher = movePattern.matcher(line.split(" - ")[5]);
                if (moveMatcher.find())
                    adventurer.setMoves(Arrays.stream(moveMatcher.group().split(""))
                            .collect(Collectors.toList()));

                adventurers.add(adventurer);
            }
        });
    }

    public Map getMap() {
        return map;
    }

    public List<Mountain> getMountains() {
        return mountains;
    }

    public List<Treasure> getTreasures() {
        return treasures;
    }

    public List<Adventurer> getAdventurers() {
        return adventurers;
    }
}
