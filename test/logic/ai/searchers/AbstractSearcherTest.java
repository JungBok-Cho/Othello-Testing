package logic.ai.searchers;

import core.Board;
import core.Player;
import core.SquareState;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.util.*;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AbstractSearcherTest {

    @Test
    void max_Valid_ShouldReturnMaximumValue() {
        NegaMax nm = new NegaMax();
        int a = 1;
        int b = 9;

        int expected = 9;

        int actual = nm.max(a, b);
        assertEquals(expected, actual);
    }

    @Test
    void min_Valid_ShouldReturnMinimumValue() {
        NegaMax nm = new NegaMax();
        int a = 1;
        int b = 9;

        int expected = a;

        int actual = nm.min(a, b);
        assertEquals(expected, actual);
    }


    // This test will very occasionally fail.
    @Test
    void randomChoice_Invalid_ShouldNotReturnSameNumberMultipleTimes() {
        NegaMax nm = new NegaMax();
        Board board = new Board();
        Player player = Player.BLACK;

        List<Point> possibleMoves = new ArrayList<Point>(board.getPossibleMoves(player));
        Point testAgainst = nm.randomChoice(board, player);
        Boolean allResultsAreTheSame = true;

        Point temp;

        for (int i = 0; i < 32; i++) {
            temp = nm.randomChoice(board, player);
            if (!temp.toString().equals(testAgainst.toString())) {
                allResultsAreTheSame = false;
            }
        }
        assertFalse(allResultsAreTheSame);
    }


    @Test
    void isEndState_Valid_ShouldReturnTrueIfOnlyBlackPiecesExist() {
        NegaMax nm = new NegaMax();
        Board board = new Board();
        Player player = Player.BLACK;
        SquareState state = SquareState.BLACK;

        board.makeMove(new Point(3, 3), state);
        board.makeMove(new Point(4, 4), state);

        Boolean end = nm.isEndState(board);

        assertTrue(end);
    }

}