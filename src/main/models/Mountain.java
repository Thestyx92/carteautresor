package main.models;

public class Mountain {
    private Position position;

    public Mountain() {
        position = new Position();
    }

    public Mountain(Position position) {
        this.position = position;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }
}
