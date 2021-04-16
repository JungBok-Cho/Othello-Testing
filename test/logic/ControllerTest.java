package logic;

import core.Board;
import core.SquareState;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class ControllerTest {

    @Test
    void Controller_GetInstance_Valid_Should_Return_Singleton() {
        Controller controller = Controller.getInstance();

        Assertions.assertNotEquals(controller, null);
    }

}