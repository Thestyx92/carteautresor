package main.utils;

import main.models.Adventurer;
import main.models.Map;
import main.models.Mountain;
import main.models.Position;

import java.util.List;

public class MapUtils {

    public static boolean checkBound(Position position, Map map) {
        return position.getX() >= 0
                && position.getY() >= 0
                && position.getX() < map.getWidth()
                && position.getY() < map.getHeight();
    }

    public static boolean checkColisions(Position position, List<Mountain> mountains, List<Adventurer> adventurers) {
        return mountains.stream().noneMatch(mountain -> mountain.getPosition().samePosition(position))
                && adventurers.stream().noneMatch(other -> other.getPosition().samePosition(position));
    }
}
