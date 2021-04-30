package othello;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GuiGameTest {

    @Test
    void Game_play_Valid_Should_Run() {
        Game game = new GuiGame();
        game.play();
    }
}