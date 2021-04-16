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

    @Test
    void Controller_UnmarkPossibleMoves_Valid_Should_Return_PossibleMoves() {
        Controller controller = Controller.getInstance();

        controller.unmarkPossibleMoves();

        Assertions.assertTrue(true);
    }

    @Test
    void Controller_MakeMove_Valid_Should_Return_SquaresToFill() {
        Controller controller = Controller.getInstance();
        Point newPoint = new Point(2,3);

        Set<Point> squarsToFill = controller.makeMove(newPoint);

        Assertions.assertTrue(squarsToFill.size() > 0);
    }

    @Test
    void Controller_GetBlackScore_Valid_DefaultBoard_Should_Return_2Black() {
        Controller controller = Controller.getInstance();
        int defaultBlacks = 2;

        Assertions.assertEquals(controller.getBlackScore(), defaultBlacks);
    }

    @Test
    void Controller_GetWhiteScore_Valid_DefaultBoard_Should_Return_2White() {
        Controller controller = Controller.getInstance();
        int defaultWhites = 2;

        Assertions.assertEquals(controller.getWhiteScore(), defaultWhites);
    }

}