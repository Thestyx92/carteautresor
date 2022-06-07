package test;

import main.Solver;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.fail;

class commentLineTest {

    private static final String noFileName = "Aucun nom de fichier";

    @Test
    void commentLine() {
        try {
            Solver.solve("src/test/resources/inputs/commentLine.txt");
        } catch (Exception e) {
            fail();
        }
    }
}