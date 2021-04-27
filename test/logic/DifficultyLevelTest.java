package logic;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class DifficultyLevelTest {

    @Test

    void DifficultyLevel_description_Valid_Should_Set_Easy() {
        DifficultyLevel difficultyLevelInstance = DifficultyLevel.EASY;

        Assertions.assertEquals(difficultyLevelInstance.description(), DifficultyLevel.EASY.description());
        Assertions.assertEquals(difficultyLevelInstance.level(), DifficultyLevel.EASY.level());
    }

}