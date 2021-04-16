package core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


class SquareStateTest {
    // Character type state information
    char blackChar = '●';
    char whiteChar = '○';
    char pssblChar = '.';
    char emptyChar = ' ';

    // Character type state information
    String blackStr = "●";
    String whiteStr = "○";
    String pssblStr = ".";
    String emptyStr = " ";

    // Check for Opposites
    @Test
    void verifyBlackSquareStateOpposite() {
        SquareState squareState = SquareState.BLACK;
        // should create 8 x 8 board

        SquareState oppositeState = squareState.opposite();

        // squareState should not be black
        Assertions.assertNotEquals(oppositeState, SquareState.BLACK);

        // squareState should be white
        Assertions.assertEquals(oppositeState, SquareState.WHITE);
    }

    @Test
    void verifyWhiteSquareStateOpposite() {
        SquareState squareState = SquareState.WHITE;
        // should create 8 x 8 board

        SquareState oppositeState = squareState.opposite();
        // squareState should not be white
        Assertions.assertNotEquals(oppositeState, SquareState.WHITE);

        //squareState should be black
        Assertions.assertEquals(oppositeState, SquareState.BLACK);
    }

    @Test
    void verifyEmptySquareStateOpposite() {
        SquareState squareState = SquareState.EMPTY;
        // should create 8 x 8 board
        Assertions.assertEquals(squareState.opposite(), SquareState.EMPTY);
    }

    // Check for Symbols
    @Test
    void verifyBlackSquareStateSymbol() {
        SquareState squareState = SquareState.BLACK;
        // should create 8 x 8 board
        Assertions.assertEquals(squareState.symbol(), this.blackChar);
    }

    @Test
    void verifyWhiteSquareStateSymbol() {
        SquareState squareState = SquareState.WHITE;
        // should create 8 x 8 board
        Assertions.assertEquals(squareState.symbol(), this.whiteChar);
    }

    @Test
    void verifyEmptySquareStateSymbol() {
        SquareState squareState = SquareState.EMPTY;
        // should create 8 x 8 board
        Assertions.assertEquals(squareState.symbol(), this.emptyChar);
    }

    @Test
    void verifyNextPossSquareStateSymbol() {
        SquareState squareState = SquareState.PSSBL;
        // should create 8 x 8 board
        Assertions.assertEquals(squareState.symbol(), this.pssblChar);
    }

    // Check for Symbols of Opposite state
    @Test
    void verifyWhiteSquareStateOppositeSymbol() {
        SquareState squareState = SquareState.WHITE;
        // should create 8 x 8 board
        Assertions.assertEquals(squareState.opposite().symbol(), this.blackChar);
    }

    @Test
    void verifyBlackSquareStateOppositeSymbol() {
        SquareState squareState = SquareState.BLACK;
        // should create 8 x 8 board
        Assertions.assertEquals(squareState.opposite().symbol(), this.whiteChar);
    }

    // Check toString values of states
    @Test
    void verifyBlackSquareStateToString() {
        SquareState squareState = SquareState.BLACK;
        // should create 8 x 8 board
        Assertions.assertEquals(squareState.toString(), String.valueOf(this.blackChar));
    }

    @Test
    void verifyWhiteSquareStateToString() {
        SquareState squareState = SquareState.WHITE;
        // should create 8 x 8 board
        Assertions.assertEquals(squareState.toString(), this.whiteStr);
    }

    @Test
    void verifyEmptySquareStateToString() {
        SquareState squareState = SquareState.EMPTY;
        // should create 8 x 8 board
        Assertions.assertEquals(squareState.toString(), this.emptyStr);
    }

    @Test
    void verifyPossibleSquareStateToString() {
        SquareState squareState = SquareState.PSSBL;
        // should create 8 x 8 board
        Assertions.assertEquals(squareState.toString(), this.pssblStr);
    }

}

