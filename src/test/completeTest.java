package test;

import main.Solver;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.nio.file.Files;

import static org.junit.jupiter.api.Assertions.fail;

class completeTest {

    private static final String missingMapLine = "Le fichier ne commence pas par l'initialisation de la carte.";

    @Test
    void completeMap() {
        try {
            Solver.solve("src/test/resources/inputs/completeMap.txt");
            File expected = new File("src/test/resources/outputs/completeMapOutput.txt");
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