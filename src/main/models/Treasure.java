package main.models;

public class Treasure {
    private Position position;
    private int count;

    public Treasure() {
        position = new Position();
        count = 0;
    }

    public Treasure(Position position, int number) {
        this.position = position;
        this.count = number;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
