package logic.ai.searchers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class MiniMaxTest {

    @Test
    void MiniMax_Valid_Should_Be_Run() {
        MiniMax minMax = new MiniMax();
        Assertions.assertNotEquals(minMax, null);
    }

}