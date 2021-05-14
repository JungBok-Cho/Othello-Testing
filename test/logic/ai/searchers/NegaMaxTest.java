package logic.ai.searchers;

import core.Board;
import core.Player;
import core.SquareState;
import logic.ai.evaluation.Evaluation;
import logic.ai.evaluation.ScoreCornerWeightEval;
import logic.ai.evaluation.ScoreDiffEval;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class NegaMaxTest {


    @Test
    void simpleSearch_Valid_ShouldFindMoveOnStartingBoard() {
        Board board = new Board();
        int depth = 4;
        Player player = Player.BLACK;
        Evaluation evalfunc = new ScoreDiffEval();
        Point expectedPoint = new Point(5, 4);

        NegaMax nm = new NegaMax();
        Point point = nm.simpleSearch(board, player, depth, evalfunc).getPoint();

        assertEquals(expectedPoint, point);
    }

}