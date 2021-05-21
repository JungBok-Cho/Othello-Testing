package logic.ai.searchers;

import core.Board;
import core.Player;
import core.SquareState;
import logic.MoveExplorer;
import logic.ai.evaluation.Evaluation;
import logic.ai.evaluation.ScoreCornerWeightEval;
import logic.ai.evaluation.ScoreDiffEval;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.lang.invoke.SwitchPoint;
import java.util.Arrays;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class NegaMaxTest {


    // Case -1
    @Test
    void simpleSearch_Valid_ShouldFindNothingAndNegativeScoreWhenWhiteLoses() {
        Board board = new Board();
        int depth = 4;
        Evaluation evalfunc = new ScoreDiffEval();
        Player player = Player.WHITE;
        SearchResult expected = new SearchResult(null, Integer.MIN_VALUE);
        int[][] coordinates = {
                {4, 5}, {0, 0}, {2, 3}, {3,0}, {1, 0}, {2,0}, {4, 0}, {5, 0}, {5, 4}
        };

        setupBoard(board, coordinates);

        Set<Point> possibleMoves = MoveExplorer.explore(board, player.color());
        NegaMax nm = new NegaMax();
        SearchResult actual = nm.simpleSearch(board, player, depth, evalfunc);
        assertEquals(expected.getPoint(), actual.getPoint());
        assertEquals(expected.getScore(), actual.getScore());
    }


    // Case 0
    @Test
    void simpleSearch_Valid_ShouldFindNothingAndZeroScoreOnStalemate() {
        Board board = new Board();
        int depth = 4;
        Evaluation evalfunc = new ScoreDiffEval();
        Player player = Player.WHITE;

        SearchResult expected = new SearchResult(null, 0);

        int[][] coordinates = {
                {4, 5}, {0, 0}, {2, 3}, {3,0}, {1, 0}, {2,0}, {4, 0}, {5, 0}
        };

        setupBoard(board, coordinates);

        Set<Point> possibleMoves = MoveExplorer.explore(board, player.color());
        NegaMax nm = new NegaMax();
        SearchResult actual = nm.simpleSearch(board, player, depth, evalfunc);
        assertEquals(expected.getPoint(), actual.getPoint());
        assertEquals(expected.getScore(), actual.getScore());
    }


    // Case 1
    @Test
    void simpleSearch_Valid_ShouldReturnPositiveScoreWhenBlackLoses() {
        Board board = new Board();
        int depth = 4;
        Evaluation evalfunc = new ScoreDiffEval();
        Player player = Player.BLACK;
        SearchResult expected = new SearchResult(null, Integer.MAX_VALUE);

        int[][] coordinates = {
                {4, 5}, {0, 0}, {2, 3}, {3,0}, {1, 0}, {2,0}, {4, 0}, {5, 0}
        };

        setupBoard(board, coordinates);

        board.makeMove(new Point(5, 4), SquareState.BLACK);
        board.makeMove(new Point(6, 4), SquareState.BLACK);

        Set<Point> possibleMoves = MoveExplorer.explore(board, player.color());
        NegaMax nm = new NegaMax();
        SearchResult actual = nm.simpleSearch(board, player, depth, evalfunc);
        assertEquals(expected.getPoint(), actual.getPoint());
        assertEquals(expected.getScore(), actual.getScore());
    }


    @Test
    void simpleSearch_Valid_ShouldEndSearchAtDepthZero() {
        Board board = new Board();
        int depth = 0;
        Evaluation evalfunc = new ScoreDiffEval();
        Player player = Player.WHITE;

        SearchResult expected = new SearchResult(null, -3);

        int[][] coordinates = {
                {4, 5}, {0, 0}, {2, 3}, {3,0}, {1, 0}, {2,0}, {4, 0}
        };

        setupBoard(board, coordinates);

        Set<Point> possibleMoves = MoveExplorer.explore(board, player.color());
        NegaMax nm = new NegaMax();
        SearchResult actual = nm.simpleSearch(board, player, depth, evalfunc);
        assertEquals(expected.getPoint(), actual.getPoint());
        assertEquals(expected.getScore(), actual.getScore());
    }


    // One player can't move, the other can
    @Test
    void simpleSearch_Valid_ShouldMoveOnWhenCurrentPlayerCanNotMove() {
        Board board = new Board();
        int depth = 4;
        Evaluation evalfunc = new ScoreDiffEval();
        Player player = Player.BLACK;
        SearchResult expected = new SearchResult(new Point(3, 0), Integer.MAX_VALUE);

        int[][] coordinates = {
                {4, 5}, {0, 0}, {2, 3}, {1,0}, {2, 0}
        };

        setupBoard(board, coordinates);

        Set<Point> possibleMoves = MoveExplorer.explore(board, player.color());
        NegaMax nm = new NegaMax();
        SearchResult actual = nm.simpleSearch(board, player, depth, evalfunc);
        assertEquals(expected.getPoint(), actual.getPoint());
        assertEquals(expected.getScore(), actual.getScore());
    }

    // Case -1
    @Test
    void search_Valid_ShouldFindNothingAndNegativeScoreWhenWhiteLoses() {
        Board board = new Board();
        int depth = 4;
        int alpha = 1;
        int beta = 2;
        Evaluation evalfunc = new ScoreDiffEval();
        Player player = Player.WHITE;
        SearchResult expected = new SearchResult(null, Integer.MIN_VALUE);
        int[][] coordinates = {
                {4, 5}, {0, 0}, {2, 3}, {3,0}, {1, 0}, {2,0}, {4, 0}, {5, 0}, {5, 4}
        };

        setupBoard(board, coordinates);

        Set<Point> possibleMoves = MoveExplorer.explore(board, player.color());
        NegaMax nm = new NegaMax();
        SearchResult actual = nm.search(board, player, alpha, beta, depth, evalfunc);
        assertEquals(expected.getPoint(), actual.getPoint());
        assertEquals(expected.getScore(), actual.getScore());
    }

    // Case 0
    @Test
    void search_Valid_ShouldFindNothingAndZeroScoreOnStalemate() {
        Board board = new Board();
        int depth = 4;
        Evaluation evalfunc = new ScoreDiffEval();
        Player player = Player.WHITE;
        int alpha = 1;
        int beta = 2;

        SearchResult expected = new SearchResult(null, 0);

        int[][] coordinates = {
                {4, 5}, {0, 0}, {2, 3}, {3,0}, {1, 0}, {2,0}, {4, 0}, {5, 0}
        };

        setupBoard(board, coordinates);

        Set<Point> possibleMoves = MoveExplorer.explore(board, player.color());
        NegaMax nm = new NegaMax();
        SearchResult actual = nm.search(board, player, alpha, beta, depth, evalfunc);
        assertEquals(expected.getPoint(), actual.getPoint());
        assertEquals(expected.getScore(), actual.getScore());
    }

    // Case 1
    @Test
    void search_Valid_ShouldReturnPositiveScoreWhenBlackLoses() {
        Board board = new Board();
        int depth = 4;
        Evaluation evalfunc = new ScoreDiffEval();
        Player player = Player.BLACK;
        SearchResult expected = new SearchResult(null, Integer.MAX_VALUE);
        int alpha = 1;
        int beta = 2;

        int[][] coordinates = {
                {4, 5}, {0, 0}, {2, 3}, {3,0}, {1, 0}, {2,0}, {4, 0}, {5, 0}
        };

        setupBoard(board, coordinates);

        board.makeMove(new Point(5, 4), SquareState.BLACK);
        board.makeMove(new Point(6, 4), SquareState.BLACK);

        Set<Point> possibleMoves = MoveExplorer.explore(board, player.color());
        NegaMax nm = new NegaMax();
        SearchResult actual = nm.search(board, player, alpha, beta, depth, evalfunc);
        assertEquals(expected.getPoint(), actual.getPoint());
        assertEquals(expected.getScore(), actual.getScore());
    }

    @Test
    void search_Valid_ShouldEndSearchAtDepthZero() {
        Board board = new Board();
        int depth = 0;
        Evaluation evalfunc = new ScoreDiffEval();
        Player player = Player.WHITE;
        int alpha = 1;
        int beta = 2;

        SearchResult expected = new SearchResult(null, -3);

        int[][] coordinates = {
                {4, 5}, {0, 0}, {2, 3}, {3,0}, {1, 0}, {2,0}, {4, 0}
        };

        setupBoard(board, coordinates);

        Set<Point> possibleMoves = MoveExplorer.explore(board, player.color());
        NegaMax nm = new NegaMax();
        SearchResult actual = nm.search(board, player, alpha, beta, depth, evalfunc);
        assertEquals(expected.getPoint(), actual.getPoint());
        assertEquals(expected.getScore(), actual.getScore());
    }

    // One player can't move, the other can
    @Test
    void search_Valid_ShouldMoveOnWhenCurrentPlayerCanNotMove() {
        Board board = new Board();
        int depth = 4;
        Evaluation evalfunc = new ScoreDiffEval();
        Player player = Player.BLACK;
        SearchResult expected = new SearchResult(null, Integer.MAX_VALUE);
        int alpha = 1;
        int beta = Integer.MAX_VALUE;

        int[][] coordinates = {
                {4, 5}, {0, 0}, {2, 3}, {1,0}, {2, 0}
        };

        setupBoard(board, coordinates);

        Set<Point> possibleMoves = MoveExplorer.explore(board, player.color());
        NegaMax nm = new NegaMax();
        SearchResult actual = nm.search(board, player, alpha, beta, depth, evalfunc);
        assertEquals(expected.getPoint(), actual.getPoint());
        assertEquals(expected.getScore(), actual.getScore());
    }

    @Test
    void search_Valid_ShouldReturnBestWhenAlphaLessThanBetaLessThanScore() {
        Board board = new Board();
        int depth = 4;
        Evaluation evalfunc = new ScoreDiffEval();
        Player player = Player.WHITE;
        int alpha = Integer.MIN_VALUE + 1;
        int beta = Integer.MIN_VALUE;

        SearchResult expected = new SearchResult(new Point(5, 0), 0);

        int[][] coordinates = {
                {4, 5}, {0, 0}, {2, 3}, {3,0}, {1, 0}, {2,0}, {4, 0}
        };

        setupBoard(board, coordinates);

        Set<Point> possibleMoves = MoveExplorer.explore(board, player.color());
        NegaMax nm = new NegaMax();
        SearchResult actual = nm.search(board, player, alpha, beta, depth, evalfunc);
        assertEquals(expected.getPoint(), actual.getPoint());
        assertEquals(expected.getScore(), actual.getScore());
    }



    // Takes in a board and coordinates. For each coordinate, alternating between
    // black and then white, it places a piece (changes the state) on the board.
    private void setupBoard(Board board, int[][] coordinates) {
        SquareState state;
        for (int i = 0; i < coordinates.length; i++) {
            if (i % 2 == 0) {
                state = SquareState.BLACK;
            } else {
                state = SquareState.WHITE;
            }
            board.makeMove(new Point(coordinates[i][0], coordinates[i][1]), state);
        }
    }

}