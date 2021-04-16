package logic;

import core.Board;
import core.SquareState;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class ControllerTest {

    @Test
    void Controller_GetInstance_Valid_Should_Return_Singleton() {
        Controller controller = Controller.getInstance();

        Assertions.assertNotEquals(controller, null);
    }

    @Test
    void Controller_MarkPossibleMoves_Valid_Should_Return_PossibleMoves() {
        Controller controller = Controller.getInstance();
        int ZERO = 0;

        Set<Point> openSpots = controller.markPossibleMoves();

        Assertions.assertNotEquals(openSpots.size(), ZERO);
    }

}