package logic.ai.evaluation;

import core.Board;
import core.Player;
import core.SquareState;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class ScoreCornerWeightEvalTest {

    @Test
    void Default_Constructor_Valid_Object_Should_Not_Null() {
        ScoreCornerWeightEval obj = new ScoreCornerWeightEval();

        Assertions.assertNotEquals(null, obj);
    }

    @Test
    void Constructor_Valid_Edge3Points_Object_Should_Not_Null() {
        ScoreCornerWeightEval obj = new ScoreCornerWeightEval(3);

        Assertions.assertNotEquals(null, obj);
    }

    @Test
    void Evaluate_Valid_Default_White_Should_Return_2() {
        ScoreCornerWeightEval obj = new ScoreCornerWeightEval();

        int result = obj.evaluate(new Board(), Player.WHITE);

        Assertions.assertEquals(2, result);
    }

    @Test
    void Evaluate_Valid_Default_Black_Should_Return_2() {
        ScoreCornerWeightEval obj = new ScoreCornerWeightEval();

        int result = obj.evaluate(new Board(), Player.BLACK);

        Assertions.assertEquals(2, result);
    }

    @Test
    void Evaluate_Valid_OneEdgeFilledBoard_White_Should_Return_4() {
        ScoreCornerWeightEval obj = new ScoreCornerWeightEval();
        Board board = new Board();
        board.makeMove(new Point(0,0), SquareState.WHITE);

        int result = obj.evaluate(board, Player.WHITE);

        Assertions.assertEquals(result, 4);
    }

    @Test
    void Evaluate_Valid_OneEdgeFilledBoard_Edge3Points_White_Should_Return_7() {
        ScoreCornerWeightEval obj = new ScoreCornerWeightEval(3);
        Board board = new Board();
        board.makeMove(new Point(0,0), SquareState.WHITE);

        int result = obj.evaluate(board, Player.WHITE);

        Assertions.assertEquals(result, 6);
    }

    @Test
    void Evaluate_Valid_EveryEdgeFilledBoard_White_Should_Return_10() {
        ScoreCornerWeightEval obj = new ScoreCornerWeightEval(1);
        Board board = new Board();
        board.makeMove(new Point(0,0), SquareState.WHITE);
        board.makeMove(new Point(Board.BOARD_LENGTH, 0), SquareState.WHITE);
        board.makeMove(new Point(0, Board.BOARD_WIDTH), SquareState.WHITE);
        board.makeMove(new Point(Board.BOARD_LENGTH, Board.BOARD_WIDTH), SquareState.WHITE);

        int result = obj.evaluate(board, Player.WHITE);

        Assertions.assertEquals(result, 10);
    }

    @Test
    void Evaluate_Valid_EveryEdgeFilledBoard_Edge5Points_White_Should_Return_7() {
        ScoreCornerWeightEval obj = new ScoreCornerWeightEval(5);
        Board board = new Board();
        board.makeMove(new Point(0,0), SquareState.WHITE);
        board.makeMove(new Point(Board.BOARD_LENGTH, 0), SquareState.WHITE);
        board.makeMove(new Point(0, Board.BOARD_WIDTH), SquareState.WHITE);
        board.makeMove(new Point(Board.BOARD_LENGTH, Board.BOARD_WIDTH), SquareState.WHITE);

        int result = obj.evaluate(board, Player.WHITE);

        Assertions.assertEquals(result, 26);
    }
}