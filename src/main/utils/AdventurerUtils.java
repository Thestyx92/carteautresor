package main.utils;

import main.models.*;

import java.util.List;
import java.util.stream.Collectors;

public class AdventurerUtils {

    public static boolean movesRemaining(List<Adventurer> adventurers) {
        return adventurers.stream()
                .anyMatch(adventurer -> adventurer.getMoves() != null && !adventurer.getMoves().isEmpty());
    }

    public static void collectTreasure(Adventurer adventurer, List<Treasure> treasures) {
        treasures.forEach(treasure -> {
            if (treasure.getCount() > 0 && treasure.getPosition().samePosition(adventurer.getPosition())) {
                adventurer.setTreasures(adventurer.getTreasures() + 1);
                treasure.setCount(treasure.getCount() - 1);
            }
        });
    }

    public static void playTurn(Map map,
                                List<Mountain> mountains,
                                List<Treasure> treasures,
                                List<Adventurer> adventurers) {
        adventurers.forEach(adventurer -> {
            if (!adventurer.getMoves().isEmpty()) {
                String move = adventurer.getMoves().get(0);
                if ("D".equals(move))
                    switch (adventurer.getDirection()) {
                        case "N" -> adventurer.setDirection("E");
                        case "E" -> adventurer.setDirection("S");
                        case "S" -> adventurer.setDirection("O");
                        case "O" -> adventurer.setDirection("N");
                    }
                else if ("G".equals(move))
                    switch (adventurer.getDirection()) {
                        case "N" -> adventurer.setDirection("O");
                        case "E" -> adventurer.setDirection("N");
                        case "S" -> adventurer.setDirection("E");
                        case "O" -> adventurer.setDirection("S");
                    }
                else if ("A".equals(move)) {
                    Position position = new Position(adventurer.getPosition().getX(), adventurer.getPosition().getY());
                    List<Adventurer> othersAdventurers = adventurers.stream()
                            .filter(other -> adventurer != other).collect(Collectors.toList());

                    switch (adventurer.getDirection()) {
                        case "N" -> position.setY(position.getY() - 1);
                        case "E" -> position.setX(position.getX() + 1);
                        case "S" -> position.setY(position.getY() + 1);
                        case "O" -> position.setX(position.getX() - 1);
                    }

                    if (MapUtils.checkBound(position, map) && MapUtils.checkColisions(position, mountains, othersAdventurers)) {
                        adventurer.setPosition(position);
                        AdventurerUtils.collectTreasure(adventurer, treasures);
                    }
                }
                adventurer.getMoves().remove(0);
            }
        });
    }
}
