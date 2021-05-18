package logic.ai.evaluation;

import core.Board;
import core.Player;
import core.SquareState;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class ScoreDiffEvalTest {

    @Test
    void Evaluate_Valid_Default_White_Should_Return_0() {
        Board board = new Board();
        ScoreDiffEval diffEval = new ScoreDiffEval();

        Assertions.assertEquals(diffEval.evaluate(board, Player.BLACK), 0);
    }

    @Test
    void Evaluate_Valid_Default_Black_Should_Return_0() {
        Board board = new Board();
        ScoreDiffEval diffEval = new ScoreDiffEval();

        Assertions.assertEquals(diffEval.evaluate(board, Player.WHITE), 0);
    }

    @Test
    void Evaluate_Valid_After_Add_1Black_Should_Return_Black_3() {
        Board board = new Board();
        ScoreDiffEval diffEval = new ScoreDiffEval();

        board.makeMove(new Point(2,3), SquareState.BLACK);

        Assertions.assertEquals(diffEval.evaluate(board, Player.BLACK), 3);
    }

    @Test
    void Evaluate_Valid_After_Add_1Black_Should_Return_White_Neg_3() {
        Board board = new Board();
        ScoreDiffEval diffEval = new ScoreDiffEval();

        board.makeMove(new Point(2,3), SquareState.BLACK);

        Assertions.assertEquals(diffEval.evaluate(board, Player.WHITE), -3);
    }

    @Test
    void Evaluate_Valid_FullBlackBoard_Should_Return_Black_64() {
        Board board = new Board();
        ScoreDiffEval diffEval = new ScoreDiffEval();
        int BOARD_LENGTH = 8;
        int BOARD_WIDTH = 8;
        Point point = new Point();

        for (point.x = 0; point.x < BOARD_LENGTH; point.x++) {
            for (point.y = 0; point.y < BOARD_WIDTH; point.y++) {
                board.makeMove(point, SquareState.BLACK);
            }
        }

        Assertions.assertEquals(diffEval.evaluate(board, Player.BLACK), 64);
    }

    @Test
    void Evaluate_Valid_FullBlackBoard_Should_Return_White_Neg_64() {
        Board board = new Board();
        ScoreDiffEval diffEval = new ScoreDiffEval();
        int BOARD_LENGTH = 8;
        int BOARD_WIDTH = 8;
        Point point = new Point();

        for (point.x = 0; point.x < BOARD_LENGTH; point.x++) {
            for (point.y = 0; point.y < BOARD_WIDTH; point.y++) {
                board.makeMove(point, SquareState.BLACK);
            }
        }

        Assertions.assertEquals(diffEval.evaluate(board, Player.WHITE), -64);
    }
}

