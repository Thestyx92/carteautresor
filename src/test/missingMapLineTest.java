package test;

import main.Solver;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

class missingMapLineTest {

    private static final String missingMapLine = "Le fichier ne commence pas par l'initialisation de la carte.";

    @Test
    void missingMapLine() {
        assertThrows(RuntimeException.class,
                () -> Solver.solve("src/test/resources/inputs/missingMapLine.txt"),
                missingMapLine);
    }

    @Test
    void missingWidthMapLine() {
        assertThrows(RuntimeException.class,
                () -> Solver.solve("src/test/resources/inputs/missingWidthMapLine.txt"),
                missingMapLine);
    }
}