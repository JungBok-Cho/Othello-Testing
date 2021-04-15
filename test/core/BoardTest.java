package core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.awt.Point;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;


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
    void Board_valid_55IsEmpty_shouldCreateNewBoardWithInitialPlacement() {
        Board board = new Board();
        // should create 8 x 8 board
        Point point = new Point(5, 5);
        Assertions.assertEquals(board.getSquareState(point), SquareState.EMPTY);
    }

    @Test
    void Board_valid_CreateBoard_Should_Initiazlie_Board() {
        Board board = new Board();
        int BOARD_LENGTH = 8;
        int BOARD_WIDTH = 8;
        int middleNum1 = BOARD_LENGTH / 2;
        int middleNum2 = BOARD_LENGTH / 2 - 1;
        Point point = new Point();

        for (point.x = 0; point.x < BOARD_LENGTH; point.x++) {
            for (point.y = 0; point.y < BOARD_WIDTH; point.y++) {
                if(point.getX() == middleNum1 && point.getY() == middleNum1) {
                    Assertions.assertEquals(board.getSquareState(point), SquareState.WHITE);
                } else if(point.getX() == middleNum2 && point.getY() == middleNum2) {
                    Assertions.assertEquals(board.getSquareState(point), SquareState.WHITE);
                } else if(point.getX() == middleNum1 && point.getY() == middleNum2) {
                    Assertions.assertEquals(board.getSquareState(point), SquareState.BLACK);
                } else if(point.getX() == middleNum2 && point.getY() == middleNum1) {
                    Assertions.assertEquals(board.getSquareState(point), SquareState.BLACK);
                } else {
                    Assertions.assertEquals(board.getSquareState(point), SquareState.EMPTY);
                }
            }
        }
    }

    @Test
    void Board_valid_getSquares_should_ReturnALlDefaultBlack() {
        Board board = new Board();
        Set<Point> blackPoints = new HashSet<>();
        blackPoints.add(new Point(3,4));
        blackPoints.add(new Point(4,3));

        Assertions.assertEquals(board.getSquares(SquareState.BLACK), blackPoints);
    }

    @Test
    void Board_valid_getSquares_should_ReturnALlDefaultWhite() {
        Board board = new Board();
        Set<Point> whitePoints = new HashSet<>();
        whitePoints.add(new Point(3,3));
        whitePoints.add(new Point(4,4));

        Assertions.assertEquals(board.getSquares(SquareState.WHITE), whitePoints);
    }

    @Test
    void Board_valid_getSquares_should_ReturnALlDefaultEmpty() {
        Board board = new Board();
        Set<Point> emptyPoints = new HashSet<>();
        int BOARD_LENGTH = 8;
        int BOARD_WIDTH = 8;
        int middleNum1 = BOARD_LENGTH / 2;
        int middleNum2 = BOARD_LENGTH / 2 - 1;

        for (int i = 0; i < BOARD_LENGTH; i++) {
            for (int j = 0; j < BOARD_WIDTH; j++) {
                if(i == middleNum1 && j == middleNum1) {
                    continue;
                } else if(i == middleNum2 && j == middleNum2) {
                    continue;
                } else if(i == middleNum1 && j == middleNum2) {
                    continue;
                } else if(i == middleNum2 && j == middleNum1) {
                    continue;
                } else {
                    emptyPoints.add(new Point(i, j));
                }
            }
        }

        Assertions.assertEquals(board.getSquares(SquareState.EMPTY), emptyPoints);
    }



}