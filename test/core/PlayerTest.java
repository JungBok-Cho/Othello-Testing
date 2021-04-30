package core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {
    @Test
    void Player_color_Valid_should_be_black() {
        Player player = Player.BLACK;
        Assertions.assertEquals(player.color(),SquareState.BLACK);
    }

    @Test
    void Player_color_Valid_should_be_white() {
        Player player = Player.WHITE;
        Assertions.assertEquals(player.color(), SquareState.WHITE);
    }

    @Test
    void Player_opponent_Valid_Should_Be_white() {
        Player currentPlayer = Player.WHITE;
        Player opponentPlayer = currentPlayer.opponent();

        Assertions.assertEquals(opponentPlayer, Player.BLACK);
        Assertions.assertNotEquals(currentPlayer.color(), opponentPlayer.color());
    }

    @Test
    void Player_opponent_Valid_Should_be_black() {
        Player currentPlayer = Player.BLACK;
        Player opponentPlayer = currentPlayer.opponent();

        Assertions.assertEquals(opponentPlayer, Player.WHITE);
        Assertions.assertNotEquals(currentPlayer.color(), opponentPlayer.color());
    }

    @Test
    void Player_opponent_opponent_Valid_Should_Be_Player() {
        Player currentPlayer = Player.BLACK;
        Player opponentPlayer = currentPlayer.opponent();
        Player opponentOfOpponentPlayer = opponentPlayer.opponent();

        Assertions.assertEquals(currentPlayer, opponentOfOpponentPlayer);

        SquareState colorCurrentPlayer = currentPlayer.color();
        SquareState colorOpponentOfOpponentPlayer = opponentOfOpponentPlayer.color();

        Assertions.assertEquals(colorCurrentPlayer, colorOpponentOfOpponentPlayer);
    }
}