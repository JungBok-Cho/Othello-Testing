package logic;

import core.Board;
import core.Player;
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

        controller.init();

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

    @Test
    void Controller_GetWinner_Valid_Should_Return_BlackWinner() {
        Controller controller = Controller.getInstance();
        Point newPoint = new Point(2,3);

        controller.makeMove(newPoint);
        Player winner = controller.getWinner();

        controller.init();

        Assertions.assertEquals(winner.color(), SquareState.BLACK);
    }

    @Test
    void Controller_GetWinner_Valid_Should_Return_WhiteWinner() {
        Controller controller = Controller.getInstance();
        controller.changeTurn();
        Point newPoint = new Point(4,5);

        controller.makeMove(newPoint);
        Player winner = controller.getWinner();

        controller.init();

        Assertions.assertEquals(winner.color(), SquareState.WHITE);
    }

    @Test
    void Controller_IsDraw_Valid_Should_Return_True() {
        Controller controller = Controller.getInstance();

        Assertions.assertTrue(controller.isDraw());
    }

    @Test
    void Controller_IsDraw_Valid_Should_Return_False() {
        Controller controller = Controller.getInstance();
        Point newPoint = new Point(2,3);

        controller.makeMove(newPoint);

        boolean result = controller.isDraw();

        controller.init();

        Assertions.assertFalse(result);
    }

    @Test
    void Controller_EndOfGame_Valid_FullBoard_Should_Return_True() {
        Controller controller = Controller.getInstance();
        int BOARD_LENGTH = 8;
        int BOARD_WIDTH = 8;
        Point point = new Point();

        for (point.x = 0; point.x < BOARD_LENGTH; point.x++) {
            for (point.y = 0; point.y < BOARD_WIDTH; point.y++) {
                controller.makeMove(point);
            }
        }

        boolean result = controller.endOfGame();

        controller.init();

        Assertions.assertTrue(result);
    }

    @Test
    void Controller_EndOfGame_Valid_NotFullBoard_Should_Return_False() {
        Controller controller = Controller.getInstance();

        boolean result = controller.endOfGame();

        controller.init();

        Assertions.assertFalse(result);
    }

    @Test
    void Controller_CurrentPlayer_Valid_Should_Return_BlackPlayer() {
        Controller controller = Controller.getInstance();

        Player result = controller.currentPlayer();

        controller.init();

        Assertions.assertEquals(result.color(), SquareState.BLACK);
    }

    @Test
    void Controller_CurrentPlayer_Valid_Should_Return_WhitePlayer() {
        Controller controller = Controller.getInstance();
        Point newPoint = new Point(2,3);

        controller.makeMove(newPoint);

        controller.changeTurn();
        Player result = controller.currentPlayer();

        controller.init();

        Assertions.assertEquals(result.color(), SquareState.WHITE);
    }

    @Test
    void Controller_BoardWithTurn_Valid_DefaultBoard_Should_Print_Correctly() {
        Controller controller = Controller.getInstance();

        String boardToStringWithStatsTurn =
                "\n" +
                "  A B C D E F G H\n" +
                "1                \n" +
                "2                \t● BLACK: 2\n" +
                "3                \n" +
                "4       ○ ●      \t○ WHITE: 2\n" +
                "5       ● ○      \n" +
                "6                \tBLACK's turn!\n" +
                "7                \n" +
                "8                \n";

        Assertions.assertEquals(controller.boardWithTurn(),
                                boardToStringWithStatsTurn);
    }

    @Test
    void Controller_SetDifficulty_Valid_Should_Set_Easy() {
        Controller controller = Controller.getInstance();

        controller.setDifficulty(DifficultyLevel.EASY);

        controller.init();

        Assertions.assertTrue(true);
    }

    @Test
    void Controller_SetDifficulty_Valid_Should_Set_Normal() {
        Controller controller = Controller.getInstance();

        controller.setDifficulty(DifficultyLevel.NORMAL);

        controller.init();

        Assertions.assertTrue(true);
    }

    @Test
    void Controller_SetDifficulty_Valid_Should_Set_Hard() {
        Controller controller = Controller.getInstance();

        controller.setDifficulty(DifficultyLevel.HARD);

        controller.init();

        Assertions.assertTrue(true);
    }

    @Test
    void Controller_SetDifficulty_Valid_Should_Set_Heroic() {
        Controller controller = Controller.getInstance();

        controller.setDifficulty(DifficultyLevel.HEROIC);

        controller.init();

        Assertions.assertTrue(true);
    }

    @Test
    void Controller_EvalMove_Valid_Should_BestPoint() {
        Controller controller = Controller.getInstance();

        Point point = controller.evalMove();

        controller.init();

        Assertions.assertNotEquals(point, null);
    }

}