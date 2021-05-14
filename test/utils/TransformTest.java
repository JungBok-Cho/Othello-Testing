package utils;

import org.junit.jupiter.api.Test;
import core.Board;
import java.awt.Point;

import static org.junit.jupiter.api.Assertions.*;

class TransformTest {

    // Implementation does not test for invalid locations

    @Test
    void indexToPoint1arg_Valid_Should_CreatePointFromLowerBoundIndexOfZero() {
        Transform tf = new Transform();
        int index = 0;
        Point expected = new Point(0, 0);

        Point p = tf.indexToPoint(index);

        assertEquals(expected, p);
    }

    @Test
    void indexToPoint1arg_Valid_Should_CreatePointFromBoardUpperBound() {
        Transform tf = new Transform();
        int index = Board.BOARD_LENGTH * Board.BOARD_WIDTH;
        Point expected = new Point(index / Board.BOARD_LENGTH, index % Board.BOARD_WIDTH);

        Point p = tf.indexToPoint(index);

        assertEquals(expected, p);
    }

    // This method is not used in the program.

    @Test
    void indexToPoint2args_Valid_Should_CreatePointFromBoardLowerBound() {
        Transform tf = new Transform();
        int index = 0;
        Point expected = new Point(index / Board.BOARD_LENGTH, index % Board.BOARD_WIDTH);

        Point p = tf.indexToPoint(index, Board.BOARD_LENGTH);

        assertEquals(expected, p);
    }

    @Test
    void indexToPoint2args_Valid_Should_CreatePointFromEndOfBoard() {
        Transform tf = new Transform();
        int index = Board.BOARD_LENGTH * Board.BOARD_WIDTH;
        Point expected = new Point(index / Board.BOARD_LENGTH, index % Board.BOARD_WIDTH);

        Point p = tf.indexToPoint(index, Board.BOARD_LENGTH);

        assertEquals(expected, p);
    }


    @Test
    void pointToIndex_Valid_Should_TurnPointIntoIndexBasedOnBoardStartingPosition() {
        Transform tf = new Transform();
        Point pt = new Point(0, 0);
        int expectedIndex = 0;

        int index = tf.pointToIndex(pt);

        assertEquals(expectedIndex, index);
    }

    @Test
    void pointToIndex_Valid_Should_TurnPointIntoIndexBasedOnBoardLastTile() {
        Transform tf = new Transform();
        Point pt = new Point(Board.BOARD_LENGTH, Board.BOARD_WIDTH);
        int expectedIndex = Board.BOARD_LENGTH * Board.BOARD_WIDTH + Board.BOARD_WIDTH;

        int index = tf.pointToIndex(pt);

        assertEquals(expectedIndex, index);
    }

    @Test
    void toBoardNotation_Valid_Should_Show1APosition() {
        Transform tf = new Transform();
        Point pt = new Point(0, 0);
        String expectedResult = "1A";

        String result = tf.toBoardNotation(pt);

        assertEquals(expectedResult, result);
    }


    // Hardcoded to the expected size of board
    @Test
    void toBoardNotations_Valid_Should_ReturnLastPositionOnBoard() {
        Transform tf = new Transform();
        Point pt = new Point(Board.BOARD_LENGTH - 1, Board.BOARD_WIDTH - 1);
        String expectedResult = "8H";

        String result = tf.toBoardNotation(pt);

        assertEquals(expectedResult, result);
    }

    // Implementation should probably be altered.
    /*
    	public static Point fromBoardNotation(String coordinate) {
		return new Point(coordinate.charAt(0) - 49, coordinate.charAt(1) - 65);
	}
     */
    @Test
    void fromBoardNotation_Valid_Should_ReturnStartingPointOnBoard() {
        Transform tf = new Transform();
        String coordinate = "1A";
        Point expectedResult = new Point(0, 0);

        Point result = tf.fromBoardNotation(coordinate);

        assertEquals(expectedResult, result);
    }
}