package core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


import java.awt.Point;


import static org.junit.jupiter.api.Assertions.*;

class BoardTest {

    @Test
    void Board_valid_33isWhite_shouldCreateNewBoardWithInitialPlacement() {
        Board board = new Board();
        // should create 8 x 8 board
        Point point = new Point(3, 3);
        Assertions.assertEquals(board.getSquareState(point), SquareState.WHITE);
    }

    @Test
    void Board_invalid_55IsEmpty_shouldCreateNewBoardWithInitialPlacement() {
        Board board = new Board();
        // should create 8 x 8 board
        Point point = new Point(5, 5);
        Assertions.assertEquals(board.getSquareState(point), SquareState.EMPTY);
    }

}