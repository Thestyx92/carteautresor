package test;

import main.Solver;
import org.junit.jupiter.api.Test;

import java.nio.file.NoSuchFileException;

import static org.junit.jupiter.api.Assertions.assertThrows;

class missingFileNameTest {

    private static final String noFileName = "Aucun nom de fichier";

    @Test
    void missingFileName() {
        assertThrows(NoSuchFileException.class, () -> Solver.solve(""), noFileName);
    }
}