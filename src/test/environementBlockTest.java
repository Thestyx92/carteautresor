package test;

import main.Solver;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.nio.file.Files;

import static org.junit.jupiter.api.Assertions.fail;

class environementBlockTest {

    private static final String missingMapLine = "Le fichier ne commence pas par l'initialisation de la carte.";

    @Test
    void mountainBlock() {
        try {
            Solver.solve("src/test/resources/inputs/mountainBlock.txt");
            File expected = new File("src/test/resources/outputs/mountainBlockOutput.txt");
            File output = new File("output.txt");

            String expectedLine = Files.readAllLines(expected.toPath()).stream().reduce((a, b) -> a + b).orElse("");
            String outputLine = Files.readAllLines(output.toPath()).stream().reduce((a, b) -> a + b).orElse("");

            if (!expectedLine.equals(outputLine))
                fail();
        } catch (Exception e) {
            fail();
        }
    }

    @Test
    void adventurerBlock() {
        try {
            Solver.solve("src/test/resources/inputs/adventurerBlock.txt");
            File expected = new File("src/test/resources/outputs/adventurerBlockOutput.txt");
            File output = new File("output.txt");

            String expectedLine = Files.readAllLines(expected.toPath()).stream().reduce((a, b) -> a + b).orElse("");
            String outputLine = Files.readAllLines(output.toPath()).stream().reduce((a, b) -> a + b).orElse("");

            if (!expectedLine.equals(outputLine))
                fail();
        } catch (Exception e) {
            fail();
        }
    }

    @Test
    void mapBlock() {
        try {
            Solver.solve("src/test/resources/inputs/mapBlock.txt");
            File expected = new File("src/test/resources/outputs/mapBlockOutput.txt");
            File output = new File("output.txt");

            String expectedLine = Files.readAllLines(expected.toPath()).stream().reduce((a, b) -> a + b).orElse("");
            String outputLine = Files.readAllLines(output.toPath()).stream().reduce((a, b) -> a + b).orElse("");

            if (!expectedLine.equals(outputLine))
                fail();
        } catch (Exception e) {
            fail();
        }
    }
}