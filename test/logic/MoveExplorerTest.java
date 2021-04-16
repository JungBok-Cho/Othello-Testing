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
    void MoveExplorer_Explore_Valid_ShouldStartWith4TilesFilled() {
        Board board = new Board();
        Set<Point> possibleMoves = MoveExplorer.explore(board, SquareState.BLACK);
        int startingOptions = 4;

        System.out.println(possibleMoves);
        assertEquals(startingOptions, possibleMoves.size());
    }

}