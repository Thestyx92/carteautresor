package main;

public class Main {

    public static void main(String[] args) {
        try {
            Solver.solve("src/main/resources/input.txt");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
