package core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.awt.Point;
import java.util.HashSet;
import java.util.Set;

class BoardTest {

    @Test
    void Board_Constructor_Valid_DefaultBoard_Should_Have_33White() {
        Board board = new Board();
        // should create 8 x 8 board
        Point point = new Point(3, 3);
        Assertions.assertEquals(board.getSquareState(point), SquareState.WHITE);
    }

    @Test
    void Board_Constructor_Valid_DefaultBoard_Should_Have_55Empty() {
        Board board = new Board();
        // should create 8 x 8 board
        Point point = new Point(5, 5);
        Assertions.assertEquals(board.getSquareState(point), SquareState.EMPTY);
    }

    @Test
    void Board_Constructor_Valid_DefaultBoard_Should_Initiazlie_Board() {
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
    void Board_GetSquares_Valid_Should_Return_ALlDefaultBlack() {
        Board board = new Board();
        Set<Point> blackPoints = new HashSet<>();
        blackPoints.add(new Point(3,4));
        blackPoints.add(new Point(4,3));

        Assertions.assertEquals(board.getSquares(SquareState.BLACK), blackPoints);
    }

    @Test
    void Board_GetSquares_Valid_Should_Return_ALlDefaultWhite() {
        Board board = new Board();
        Set<Point> whitePoints = new HashSet<>();
        whitePoints.add(new Point(3,3));
        whitePoints.add(new Point(4,4));

        Assertions.assertEquals(board.getSquares(SquareState.WHITE), whitePoints);
    }

    @Test
    void Board_GetSquares_Valid_Should_Return_ALlDefaultEmpty() {
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

    @Test
    void Board_IsFull_Valid_DefaultBoard_Should_Return_False() {
        Board board = new Board();

        Assertions.assertFalse(board.isFull());
    }

    @Test
    void Board_IsFull_Valid_DefaultBoard_Should_Return_True() {
        Board board = new Board();
        int BOARD_LENGTH = 8;
        int BOARD_WIDTH = 8;
        Point point = new Point();

        for (point.x = 0; point.x < BOARD_LENGTH; point.x++) {
            for (point.y = 0; point.y < BOARD_WIDTH; point.y++) {
                board.makeMove(point, SquareState.WHITE);
            }
        }

        Assertions.assertTrue(board.isFull());
    }

    @Test
    void Board_Count_Valid_DefaultBoard_Should_Have_2Black() {
        Board board = new Board();
        SquareState state = SquareState.BLACK;
        int beginningBlack = 2;

        Assertions.assertEquals(board.count(state), beginningBlack);
    }

    @Test
    void Board_Count_Valid_DefaultBoard_Should_Have_2White() {
        Board board = new Board();
        SquareState state = SquareState.WHITE;
        int beginningWhite = 2;

        Assertions.assertEquals(board.count(state), beginningWhite);
    }

    @Test
    void Board_Count_Valid_DefaultBoard_Should_Have_60Empty() {
        Board board = new Board();
        SquareState state = SquareState.EMPTY;
        int beginningEmpty = 60;

        Assertions.assertEquals(board.count(state), beginningEmpty);
    }

    @Test
    void Board_MarkPossibleMoves_Valid_DefaultBoard_Should_Have_BlackPossibleMoves() {
        Board board = new Board();
        SquareState statePossible = SquareState.PSSBL;

        Set<Point> blackPossibleMoves = board.getPossibleMoves(Player.BLACK);

        board.markPossibleMoves(blackPossibleMoves);

        for(Point x : blackPossibleMoves) {
            Assertions.assertEquals(board.getSquareState(x), statePossible);
        }
    }

    @Test
    void Board_MarkPossibleMoves_Valid_DefaultBoard_Should_Have_WhitePossibleMoves() {
        Board board = new Board();
        SquareState statePossible = SquareState.PSSBL;

        Set<Point> whitePossibleMoves = board.getPossibleMoves(Player.WHITE);

        board.markPossibleMoves(whitePossibleMoves);

        for(Point x : whitePossibleMoves) {
            Assertions.assertEquals(board.getSquareState(x), statePossible);
        }
    }

    @Test
    void Board_UnmarkPossibleMoves_Valid_DefaultBoard_Should_Not_Have_PossibleMoves() {
        Board board = new Board();
        int ZERO = 0;

        board.markPossibleMoves(board.getPossibleMoves(Player.WHITE));
        board.unmarkPossibleMoves();

        Assertions.assertEquals(board.count(SquareState.PSSBL), ZERO);
    }

    @Test
    void Board_ToString_Valid_DefaultBoard_Should_Print_Correctly() {
        Board board = new Board();
        String boardToString =
                "  A B C D E F G H\n" +
                "1                \n" +
                "2                \n" +
                "3                \n" +
                "4       ○ ●      \n" +
                "5       ● ○      \n" +
                "6                \n" +
                "7                \n" +
                "8                \n";

        Assertions.assertEquals(board.toString(), boardToString);
    }

    @Test
    void Board_ToStringWithStats_Valid_DefaultBoard_Should_Print_Correctly() {
        Board board = new Board();

        String boardToStringWithStats =
                "\n" +
                "  A B C D E F G H\n" +
                "1                \n" +
                "2                \t● BLACK: 2\n" +
                "3                \n" +
                "4       ○ ●      \t○ WHITE: 2\n" +
                "5       ● ○      \n" +
                "6                \n" +
                "7                \n" +
                "8                \n";

        Assertions.assertEquals(board.toStringWithStats(), boardToStringWithStats);
    }

    @Test
    void Board_ToStringWithStatsBlackTurn_Valid_DefaultBoard_Should_Print_Correctly() {
        Board board = new Board();

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

        Assertions.assertEquals(board.toStringWithStatsTurn(Player.BLACK),
                                boardToStringWithStatsTurn);
    }

    @Test
    void Board_ToStringWithStatsWhiteTurn_Valid_DefaultBoard_Should_Print_Correctly() {
        Board board = new Board();

        String boardToStringWithStatsTurn =
                "\n" +
                "  A B C D E F G H\n" +
                "1                \n" +
                "2                \t● BLACK: 2\n" +
                "3                \n" +
                "4       ○ ●      \t○ WHITE: 2\n" +
                "5       ● ○      \n" +
                "6                \tWHITE's turn!\n" +
                "7                \n" +
                "8                \n";

        Assertions.assertEquals(board.toStringWithStatsTurn(Player.WHITE),
                                boardToStringWithStatsTurn);
    }

    @Test
    void Board_Clone_Valid_Should_Return_ClonedBoard() {
        Board board = new Board();
        board.makeMove(new Point(2,3), SquareState.BLACK);

        Board clonedBoard = board.clone();

        Assertions.assertNotEquals(board, clonedBoard);
    }

    @Test
    void Board_Clone_Valid_Should_Have_SameBoardSituation() {
        Board board = new Board();
        board.makeMove(new Point(2,3), SquareState.BLACK);

        Board clonedBoard = board.clone();

        Assertions.assertEquals(board.toString(), clonedBoard.toString());
    }

    @Test
    void Board_Clone_Valid_ModifiedBoard_Should_Be_Different_From_Default() {
        Board board = new Board();
        board.makeMove(new Point(2,3), SquareState.BLACK);

        Board clonedBoard = board.clone();
        Board newBoard = new Board();

        Assertions.assertNotEquals(clonedBoard, newBoard);
    }

}