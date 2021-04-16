package logic;

import core.Board;
import core.SquareState;
import java.awt.Point;
import java.util.Iterator;
import java.util.Set;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MoveExplorerTest {

    @Test
    void MoveExplorer_explore_Valid_ShouldStartWith4TilesAvailable() {
        Board board = new Board();
        Set<Point> possibleMoves = MoveExplorer.explore(board, SquareState.BLACK);
        int startingOptions = 4;
        assertEquals(startingOptions, possibleMoves.size());
    }

    @Test
    void MoveExplorer_squaresToFill_Valid_ShouldReturnASquareToChange() {
        Board board = new Board();
        Point seed = new Point(5, 3);
        Point knownChanged = new Point(4, 3);

        Set<Point> squaresThatAreFilled = MoveExplorer.squaresToFill(board, seed);
        assertTrue(squaresThatAreFilled.contains(knownChanged));
    }

    @Test
    void MoveExplorer_explore_Valid_ShouldExploreMoreThanOnceInADirection() {
        Board board = new Board();
        Point moveLoc = new Point(2, 3);
        Point possibleMove = new Point(1, 3);

        board.makeMove(moveLoc, SquareState.WHITE);
        Set<Point> possibleMoves = MoveExplorer.explore(board, SquareState.BLACK);

        assertTrue(possibleMoves.contains(possibleMove));
    }

}