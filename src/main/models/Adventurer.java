package main.models;

import java.util.ArrayList;
import java.util.List;

public class Adventurer {
    private String name;
    private Position position;
    private String direction;
    private List<String> moves;
    private int treasures;

    public Adventurer() {
        name = "";
        position = new Position();
        direction = "";
        moves = new ArrayList<>();
        treasures = 0;
    }

    public Adventurer(String name, Position position, String direction, List<String> moves, int treasures) {
        this.name = name;
        this.position = position;
        this.direction = direction;
        this.moves = moves;
        this.treasures = treasures;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public List<String> getMoves() {
        return moves;
    }

    public void setMoves(List<String> moves) {
        this.moves = moves;
    }

    public int getTreasures() {
        return treasures;
    }

    public void setTreasures(int treasures) {
        this.treasures = treasures;
    }
}
