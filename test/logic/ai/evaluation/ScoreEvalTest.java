package logic.ai.evaluation;

import core.Board;
import core.Player;
import core.SquareState;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class ScoreEvalTest {

    @Test
    void Evaluate_Valid_Default_Should_Return_2_Black() {
        Board board = new Board();
        ScoreEval eval = new ScoreEval();

        Assertions.assertEquals(eval.evaluate(board, Player.BLACK), 2);
    }

    @Test
    void Evaluate_Valid_Default_Should_Return_2_White() {
        Board board = new Board();
        ScoreEval eval = new ScoreEval();

        Assertions.assertEquals(eval.evaluate(board, Player.WHITE), 2);
    }

    @Test
    void Evaluate_Valid_Add_1Black_Should_Return_4_Black() {
        Board board = new Board();
        ScoreEval eval = new ScoreEval();

        board.makeMove(new Point(2,3), SquareState.BLACK);

        Assertions.assertEquals(eval.evaluate(board, Player.BLACK), 4);
    }

    @Test
    void Evaluate_Valid_Add_1White_Should_Return_4_White() {
        Board board = new Board();
        ScoreEval eval = new ScoreEval();

        board.makeMove(new Point(2,4), SquareState.WHITE);

        Assertions.assertEquals(eval.evaluate(board, Player.WHITE), 4);
    }

    @Test
    void Evaluate_Valid_FullBlackBoard_Should_Return_0_White() {
        Board board = new Board();
        ScoreEval eval = new ScoreEval();
        int BOARD_LENGTH = 8;
        int BOARD_WIDTH = 8;
        Point point = new Point();

        for (point.x = 0; point.x < BOARD_LENGTH; point.x++) {
            for (point.y = 0; point.y < BOARD_WIDTH; point.y++) {
                board.makeMove(point, SquareState.BLACK);
            }
        }

        Assertions.assertEquals(eval.evaluate(board, Player.WHITE), 0);
    }

    @Test
    void Evaluate_Valid_FullWhiteBoard_Should_Return_0_Black() {
        Board board = new Board();
        ScoreEval eval = new ScoreEval();
        int BOARD_LENGTH = 8;
        int BOARD_WIDTH = 8;
        Point point = new Point();

        for (point.x = 0; point.x < BOARD_LENGTH; point.x++) {
            for (point.y = 0; point.y < BOARD_WIDTH; point.y++) {
                board.makeMove(point, SquareState.WHITE);
            }
        }

        Assertions.assertEquals(eval.evaluate(board, Player.BLACK), 0);
    }
}