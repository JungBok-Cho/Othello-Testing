package core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


class SquareStateTest {

    /*
     Testcases to check for Opposites
     */
    @Test
    void SquareState_Opposite_Valid_Black_To_White() {
        SquareState currentSquareState = SquareState.BLACK;
        SquareState oppositeState = currentSquareState.opposite();

        // currentSquareState should not be black
        Assertions.assertNotEquals(oppositeState, SquareState.BLACK);

        // currentSquareState should be white
        Assertions.assertEquals(oppositeState, SquareState.WHITE);
    }

    @Test
    void SquareState_Opposite_Valid_White_To_Black() {
        SquareState currentSquareState = SquareState.WHITE;
        SquareState oppositeState = currentSquareState.opposite();

        //currentSquareState should not be white
        Assertions.assertNotEquals(oppositeState, SquareState.WHITE);

        //currentSquareState should be black
        Assertions.assertEquals(oppositeState, SquareState.BLACK);
    }

    @Test
    void SquareState_Opposite_Invalid_Empty() {
        SquareState currentSquareState = SquareState.EMPTY;
        SquareState oppositeSquareState = currentSquareState.opposite();
        
        Assertions.assertNotEquals(oppositeSquareState, SquareState.EMPTY);
    }

    @Test
    void SquareState_Opposite_Invalid_Next_possible() {
        SquareState currentSquareState = SquareState.PSSBL;
        SquareState oppositeSquareState = currentSquareState.opposite();

        Assertions.assertNotEquals(oppositeSquareState, SquareState.PSSBL);
    }

    /*
    Test cases to check for Symbols
     */
    @Test
    void SquareState_Symbol_Valid_Black() {
        char blackSymbol = '●';
        SquareState currentSquareState = SquareState.BLACK;
        char currentSquareStateSymbol = currentSquareState.symbol();

        Assertions.assertEquals(currentSquareStateSymbol, blackSymbol);
    }

    @Test
    void SquareState_Symbol_Valid_White() {
        char whiteSymbol = '○';
        SquareState currentSquareState = SquareState.WHITE;
        char currentSquareStateSymbol = currentSquareState.symbol();

        Assertions.assertEquals(currentSquareStateSymbol, whiteSymbol);
    }

    @Test
    void SquareState_Symbol_Valid_Empty() {
        char emptySymbol = ' ';
        SquareState currentSquareState = SquareState.EMPTY;
        char currentSquareStateSymbol = currentSquareState.symbol();
        
        Assertions.assertEquals(currentSquareStateSymbol, emptySymbol);
    }

    @Test
    void SquareState_Symbol_Valid_Pssbl() {
        char pssblSymbol = '.';
        SquareState currentSquareState = SquareState.PSSBL;
        char currentSquareStateSymbol = currentSquareState.symbol();

        Assertions.assertEquals(currentSquareStateSymbol, pssblSymbol);
    }

    /*
     Testcases to check for Symbols of Opposite state
     */
    @Test
    void SquareState_Opposite_Symbol_Valid_White_To_Black() {
        char blackSymbol = '●';
        char whiteSymbol = '○';
        SquareState currentSquareState = SquareState.WHITE;
        SquareState oppositeSquareState = currentSquareState.opposite();
        char oppositeSquareStateSymbol = oppositeSquareState.symbol();

        // SquareState should not have white character
        Assertions.assertNotEquals(oppositeSquareStateSymbol, whiteSymbol);

        // SquareState should have black Character
        Assertions.assertEquals(oppositeSquareStateSymbol, blackSymbol);
    }

    @Test
    void SquareState_Opposite_Symbol_Valid_Black_To_White() {
        char blackSymbol = '●';
        char whiteSymbol = '○';
        SquareState currentSquareState = SquareState.BLACK;
        SquareState oppositeSquareState = currentSquareState.opposite();
        char oppositeSquareStateSymbol = oppositeSquareState.symbol();

        // SquareState should not have black character
        Assertions.assertNotEquals(oppositeSquareStateSymbol, blackSymbol);

        // SquareState should have white character
        Assertions.assertEquals(oppositeSquareStateSymbol, whiteSymbol);
    }

    @Test
    void SquareState_Opposite_Symbol_Invalid_Empty() {
        char emptySymbol = ' ';
        SquareState currentSquareState = SquareState.EMPTY;
        SquareState oppositeSquareState = currentSquareState.opposite();
        char oppositeSquareStateSymbol = oppositeSquareState.symbol();

        Assertions.assertNotEquals(oppositeSquareStateSymbol, emptySymbol);
    }

    @Test
    void SquareState_Opposite_Symbol_Invalid_Pssbl() {
        char pssblSymbol = '.';
        SquareState currentSquareState = SquareState.PSSBL;
        SquareState oppositeSquareState = currentSquareState.opposite();
        char oppositeSquareStateSymbol = oppositeSquareState.symbol();

        Assertions.assertNotEquals(oppositeSquareStateSymbol, pssblSymbol);
    }

    /*
     Testcases to check toString values of states
     */
    @Test
    void SquareState_ToString_Valid_Black() {
        String blackString = "●";
        SquareState currentSquareState = SquareState.BLACK;
        String currentSquareStateString = currentSquareState.toString();

        Assertions.assertEquals(currentSquareStateString, blackString);
    }

    @Test
    void SquareState_ToString_Valid_White() {
        String whiteString = "○";
        SquareState currentSquareState = SquareState.WHITE;
        String currentSquareStateString = currentSquareState.toString();
        
        Assertions.assertEquals(currentSquareStateString, whiteString);
    }

    @Test
    void SquareState_ToString_Valid_Empty() {
        String emptyString = " ";
        SquareState currentSquareState = SquareState.EMPTY;
        String currentSquareStateString = currentSquareState.toString();
        
        Assertions.assertEquals(currentSquareStateString, emptyString);
    }

    @Test
    void SquareState_ToString_Valid_Pssbl() {
        String pssblString = ".";
        SquareState currentSquareState = SquareState.PSSBL;
        String currentSquareStateString = currentSquareState.toString();
        
        Assertions.assertEquals(currentSquareStateString, pssblString);
    }

    @Test
    void SquareState_Opposite_ToString_Valid_Black() {
        String whiteString = "○";
        SquareState currentSquareState = SquareState.BLACK;
        SquareState oppositeSquareState = currentSquareState.opposite();
        String oppositeSquareStateString = oppositeSquareState.toString();
        
        Assertions.assertEquals(oppositeSquareStateString, whiteString);
    }

    @Test
    void SquareState_Opposite_ToString_Valid_White() {
        String blackString = "●";
        SquareState currentSquareState = SquareState.WHITE;
        SquareState oppositeSquareState = currentSquareState.opposite();
        String oppositeSquareStateString = oppositeSquareState.toString();
        
        Assertions.assertEquals(oppositeSquareStateString, blackString);
    }

    @Test
    void SquareState_Opposite_ToString_Invalid_Pssbl() {
        String pssblString = ".";
        SquareState currentSquareState = SquareState.PSSBL;
        SquareState oppositeSquareState = currentSquareState.opposite();
        String oppositeSquareStateString = oppositeSquareState.toString();
        
        Assertions.assertNotEquals(oppositeSquareStateString, pssblString);
    }

    @Test
    void SquareState_Opposite_ToString_Invalid_Empty() {
        String emptyString = " ";
        SquareState currentSquareState = SquareState.EMPTY;
        SquareState oppositeSquareState = currentSquareState.opposite();
        String oppositeSquareStateString = oppositeSquareState.toString();

        Assertions.assertNotEquals(oppositeSquareStateString, emptyString);
    }

}

